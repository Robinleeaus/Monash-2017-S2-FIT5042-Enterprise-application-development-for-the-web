/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.publicuser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import mbeans.IndexController;

import repository.BankingTransactionRepository;
import repository.entities.BankingAccount;
import repository.entities.BankingSystemUser;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "transferFundToOthersController")
@RequestScoped
public class TransferFundToOthersController {
    
    private String pageTitle;

    @ManagedProperty(value="#{userInput}")
    private UserInput userInput;
    
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
     
    /**
     * Creates a new instance of IndexController
     */
    public TransferFundToOthersController() {
        pageTitle = "Transfer Fund";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public BankingTransactionRepository getBankingTransactionRepository() {
        return bankingTransactionRepository;
    }

    public void setBankingTransactionRepository(BankingTransactionRepository bankingTransactionRepository) {
        this.bankingTransactionRepository = bankingTransactionRepository;
    }
    
    
    public String save()
    {
        boolean enoughBalance = false;
        boolean ValidToAccount = false;
        boolean transactionSuccess = false;

        // 1. check if the balance of "From account" is enough 
        BankingAccount fromAccount = userInput.getFromAccount();
        BankingTransaction newBankingTransaction = userInput.getNewBankingTransaction();
        
        if (fromAccount.getBalance() > newBankingTransaction.getAmount())
            enoughBalance = true;
        
        // 2. Search "To account"
        BankingAccount toAccount = new BankingAccount();
        int toAccountNumber = userInput.getToAccount().getAccountNumber();
        
        try {
            toAccount = bankingTransactionRepository.searchBankingAccountByNumber(toAccountNumber);
        } catch (Exception ex) {
            Logger.getLogger(TransferFundToOthersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (toAccount != null)
            ValidToAccount = true;
        

        // Start doing transaction
        if (enoughBalance == true && ValidToAccount == true)
        {
            // 3. Transfer - update "From account"
            BankingAccount updatedFromAccount = new BankingAccount();
            try {
                updatedFromAccount = bankingTransactionRepository.descreaseBankingAccountBalance(fromAccount, newBankingTransaction.getAmount());
                bankingTransactionRepository.editBankingAccount(updatedFromAccount);
            } catch (Exception ex) {
                Logger.getLogger(TransferFundToOthersController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // 4. Transfer - update "To account"
            BankingAccount updatedToAccount = new BankingAccount();
            try {
                updatedToAccount = bankingTransactionRepository.increaseBankingAccountBalance(toAccount, newBankingTransaction.getAmount());
                bankingTransactionRepository.editBankingAccount(updatedToAccount);
            } catch (Exception ex) {
                Logger.getLogger(TransferFundToOthersController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // 5. Store transaction information
            BankingSystemUser fromAccountBankingSystemUser = fromAccount.getBankingSystemUser();
            
            newBankingTransaction.setType("Debit");
            newBankingTransaction.setBankingSystemUser(fromAccountBankingSystemUser);
            try {
                bankingTransactionRepository.addBankingTransaction(newBankingTransaction);
            } catch (Exception ex) {
                Logger.getLogger(TransferFundToOthersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if ( enoughBalance == true && ValidToAccount == true)
            transactionSuccess = true;
        
        userInput.setEnoughBalance(enoughBalance);
        userInput.setValidToAccount(ValidToAccount);
        userInput.setTransactionSuccess(transactionSuccess);
        
        return "transferfundtoothersresult";        
    }
}
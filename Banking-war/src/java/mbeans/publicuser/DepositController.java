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
@ManagedBean(name = "depositController")
@RequestScoped
public class DepositController {
    
    private String pageTitle;

    @ManagedProperty(value="#{userInput}")
    private UserInput userInput;
    
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
     
    /**
     * Creates a new instance of IndexController
     */
    public DepositController() {
        pageTitle = "Deposit";
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

        boolean depositSuccess = false;
        
        BankingAccount toAccount = userInput.getToAccount();
        BankingTransaction newBankingTransaction = userInput.getNewBankingTransaction();
    
        // Start depositing
        // 1. Update "To account"
        BankingAccount updatedToAccount = new BankingAccount();
        try {
            updatedToAccount = bankingTransactionRepository.increaseBankingAccountBalance(toAccount, newBankingTransaction.getAmount());
            bankingTransactionRepository.editBankingAccount(updatedToAccount);
        } catch (Exception ex) {
            Logger.getLogger(TransferFundToOthersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 2. Store transaction information
        BankingSystemUser toAccountBankingSystemUser = toAccount.getBankingSystemUser();

        newBankingTransaction.setType("Credit");
        newBankingTransaction.setBankingSystemUser(toAccountBankingSystemUser);
        try {
            bankingTransactionRepository.addBankingTransaction(newBankingTransaction);
        } catch (Exception ex) {
            Logger.getLogger(TransferFundToOthersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        depositSuccess = true;
        
        userInput.setDepositSuccess(depositSuccess);
        
        return "depositresult";        
    }
}
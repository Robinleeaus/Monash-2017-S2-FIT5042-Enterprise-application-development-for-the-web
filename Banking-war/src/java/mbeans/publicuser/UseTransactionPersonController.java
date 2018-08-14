/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.publicuser;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mbeans.bankworker.ManageUsersController;
import repository.BankingTransactionRepository;
import repository.entities.BankingAccount;
import repository.entities.BankingSystemUser;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "useTransactionPersonController")
@RequestScoped
public class UseTransactionPersonController {
        
    private String pageTitle;
    private int accountNumber;
    private BankingAccount fromAccount;
    private BankingAccount toAccount;
    private BankingTransaction newBankingTransaction;
    
    @ManagedProperty(value="#{userInput}")
    private UserInput userInput;
        
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
    /**
     * Creates a new instance of SearchTransactionController
     */
    public UseTransactionPersonController() {
        pageTitle = "Operate Transaction";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankingAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(BankingAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    public BankingAccount getToAccount() {
        return toAccount;
    }

    public void setToAccount(BankingAccount toAccount) {
        this.toAccount = toAccount;
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
    
    public String transferFundToOthers(){
        try {
            accountNumber = Integer.valueOf(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap()
                    .get("accountNumber"));
            fromAccount = bankingTransactionRepository.searchBankingAccountByNumber(accountNumber);
            userInput.setFromAccount(fromAccount);
            
            toAccount = new BankingAccount();
            userInput.setToAccount(toAccount);
            
            newBankingTransaction = new BankingTransaction();
            userInput.setNewBankingTransaction(newBankingTransaction);
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "transferfundtoothers";
    }
    
    public String deposit(){
        try {
            accountNumber = Integer.valueOf(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap()
                    .get("accountNumber"));
            toAccount = bankingTransactionRepository.searchBankingAccountByNumber(accountNumber);
            userInput.setToAccount(toAccount);
            
//            fromAccount = new BankingAccount();
//            userInput.setFromAccount(fromAccount);
            
            newBankingTransaction = new BankingTransaction();
            userInput.setNewBankingTransaction(newBankingTransaction);
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "deposit";
    }
}
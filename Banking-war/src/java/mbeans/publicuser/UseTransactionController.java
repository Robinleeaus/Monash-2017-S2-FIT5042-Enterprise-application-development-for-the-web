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
//@Named(value = "publicSearchTransactionController")
@ManagedBean(name = "useTransactionController")
@RequestScoped
public class UseTransactionController {
    
    private String pageTitle;

    @ManagedProperty(value="#{userInput}")
    private UserInput userInput;
    
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
     
    /**
     * Creates a new instance of IndexController
     */
    public UseTransactionController() {
        pageTitle = "Operate Transaction";
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
    
    
    public String searchUser()
    {

        int userId = 0;

        if (userInput != null)
        {
            userId = userInput.getUserId();
        }
        
        BankingSystemUser bankingSystemUser = new BankingSystemUser();
        Set<BankingAccount> bankingAccountSet = new HashSet<BankingAccount>();
        
        try {
            bankingSystemUser = bankingTransactionRepository.searchBankingSystemUserById(userId);
            bankingAccountSet =  bankingTransactionRepository.searchBankingAccountByBankingSystemUser(bankingSystemUser);
        } catch (Exception ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (userInput != null)
            try {
                userInput.setAccounts(bankingAccountSet);
            } catch (Exception ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }

        return "usetransactionperson";        
    }
}
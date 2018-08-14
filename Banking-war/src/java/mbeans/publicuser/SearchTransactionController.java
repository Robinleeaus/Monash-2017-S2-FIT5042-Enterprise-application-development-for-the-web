/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.publicuser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import mbeans.IndexController;

import repository.BankingTransactionRepository;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
//@Named(value = "publicSearchTransactionController")
@ManagedBean(name = "searchTransactionController")
@RequestScoped
public class SearchTransactionController {
    
    private String pageTitle;

    @ManagedProperty(value="#{userInput}")
    private UserInput userInput;
    
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
     
    /**
     * Creates a new instance of IndexController
     */
    public SearchTransactionController() {
        pageTitle = "Search Transaction";
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
    
    
    public String searchAction()
    {
        String searchMethod = "";
        String searchKeyword = "";

        if (userInput != null)
        {
            searchMethod = userInput.getSearchMethod();
            searchKeyword = userInput.getSearchKeyword();
        }
        
        BankingTransaction bankingTransaction = new BankingTransaction();
        List<BankingTransaction> bankingTransactionList = new ArrayList<BankingTransaction>();

         int searchKeywordInt = 0;
        
        if (searchMethod.equals("Type"))
            try {
                bankingTransactionList = bankingTransactionRepository.searchBankingTransactionByType(searchKeyword);
        } catch (Exception ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if (searchMethod.equals("Name"))
            try {
                bankingTransactionList =  bankingTransactionRepository.searchBankingTransactionByName(searchKeyword);
        } catch (Exception ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if (searchMethod.equals("Number"))
        {
            try {
                searchKeywordInt = Integer.parseInt(searchKeyword);
                bankingTransaction = bankingTransactionRepository.searchBankingTransactionByNumber(searchKeywordInt);
                bankingTransactionList.add(bankingTransaction);
            } catch (Exception ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (userInput != null)
            try {
                userInput.setQueriedResult(bankingTransactionList);
            } catch (Exception ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }

        return "transactionresult";        
    }
}
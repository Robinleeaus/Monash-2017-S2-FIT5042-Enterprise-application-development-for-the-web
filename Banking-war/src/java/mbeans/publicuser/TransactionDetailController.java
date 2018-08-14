/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.publicuser;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import repository.BankingTransactionRepository;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
//@Named(value = "transactionDetailController")
@ManagedBean(name = "transactionDetailController")
@RequestScoped
public class TransactionDetailController {

    private String pageTitle;
//    private int transactionId;
    private int transactionNumber;
    private BankingTransaction bankingTransaction;

    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
        
    /**
     * Creates a new instance of TransactionDetailController
     */
    public TransactionDetailController() {
        pageTitle = "Transaction Detail";
        transactionNumber = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("transactionNumber"));
    }
    
    public String getPageTitle() {    
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public BankingTransaction getBankingTransaction() {
        if (bankingTransaction == null) {
            try {
                return bankingTransactionRepository.searchBankingTransactionByNumber(transactionNumber);
            } catch (Exception ex) {
                Logger.getLogger(TransactionDetailController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bankingTransaction;
    }

    public void setBankingTransaction(BankingTransaction bankingTransaction) {
        this.bankingTransaction = bankingTransaction;
    }
    
    public BankingTransactionRepository getBankingTransactionRepository() {
        return bankingTransactionRepository;
    }

    public void setBankingTransactionRepository(BankingTransactionRepository bankingTransactionRepository) {    
        this.bankingTransactionRepository = bankingTransactionRepository;
    }

}

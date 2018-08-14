/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.bankworker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import mbeans.publicuser.TransactionDetailController;
import repository.BankingTransactionRepository;
import repository.entities.BankingSystemUser;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "userDetailController")
@RequestScoped
public class UserDetailController {
    
    private String pageTitle;
    private int userIdNumber;
    private BankingSystemUser bankingSystemUser;

    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
        
    /**
     * Creates a new instance of UserDetailController
     */
    public UserDetailController() {
        pageTitle = "User Detail";
    }
    
    public String getPageTitle() {    
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public int getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(int userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    public BankingTransactionRepository getBankingTransactionRepository() {
        return bankingTransactionRepository;
    }

    public void setBankingTransactionRepository(BankingTransactionRepository bankingTransactionRepository) {    
        this.bankingTransactionRepository = bankingTransactionRepository;
    }

    public BankingSystemUser getBankingSystemUser() {
        if (bankingSystemUser == null) {
            try {
                userIdNumber = Integer.valueOf(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap()
                    .get("userIdNumber"));
                bankingSystemUser = bankingTransactionRepository.searchBankingSystemUserById(userIdNumber);
                return bankingSystemUser;
            } catch (Exception ex) {
                Logger.getLogger(TransactionDetailController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bankingSystemUser;
    }
}

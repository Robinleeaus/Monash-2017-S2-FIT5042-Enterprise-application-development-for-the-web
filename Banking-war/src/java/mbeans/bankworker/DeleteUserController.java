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
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import mbeans.publicuser.TransactionDetailController;
import repository.BankingTransactionRepository;
import repository.entities.BankingSystemUser;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "deleteUserController")
@RequestScoped
public class DeleteUserController {
    
    private String pageTitle;
    private int userIdNumber;
    private BankingSystemUser bankingSystemUser;

    @ManagedProperty(value="#{workerInput}")
    private WorkerInput workerInput;
        
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;

    public DeleteUserController() {
        pageTitle = "Delete User";
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

    public BankingSystemUser getBankingSystemUser() {
        if (bankingSystemUser == null) {
            try {
                userIdNumber = Integer.valueOf(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap()
                    .get("userIdNumber"));
                bankingSystemUser = bankingTransactionRepository.searchBankingSystemUserById(userIdNumber);
                workerInput.setBankingSystemUser(bankingSystemUser);
                return bankingSystemUser;
            } catch (Exception ex) {
                Logger.getLogger(TransactionDetailController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bankingSystemUser;
    }

    public void setBankingSystemUser(BankingSystemUser bankingSystemUser) {
        this.bankingSystemUser = bankingSystemUser;
    }

    public WorkerInput getWorkerInput() {
        return workerInput;
    }

    public void setWorkerInput(WorkerInput workerInput) {
        this.workerInput = workerInput;
    }

    public BankingTransactionRepository getBankingTransactionRepository() {
        return bankingTransactionRepository;
    }

    public void setBankingTransactionRepository(BankingTransactionRepository bankingTransactionRepository) {
        this.bankingTransactionRepository = bankingTransactionRepository;
    }
    
    public String delete(){
        userIdNumber = workerInput.getBankingSystemUser().getIdNumber();
        try {
            bankingTransactionRepository.removeBankingSystemUser(userIdNumber);
        } catch (Exception ex) {
            Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "manageusers";
    }
}

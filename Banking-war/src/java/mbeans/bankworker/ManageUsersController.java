/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.bankworker;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mbeans.IndexController;
import repository.BankingTransactionRepository;
import repository.entities.BankingSystemUser;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "manageUsersController")
@RequestScoped
public class ManageUsersController {
    
    private String pageTitle;
    private int userIdNumber;
    private BankingSystemUser bankingSystemUser;

    @ManagedProperty(value="#{workerInput}")
    private WorkerInput workerInput;
    
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
    
    public ManageUsersController() {
        pageTitle = "Manage Users";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
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

    public String addUser(){
            bankingSystemUser = new BankingSystemUser();
            workerInput.setBankingSystemUser(bankingSystemUser);
            
        return "adduser";
    }
        
    public String editUser(){
        try {
            userIdNumber = Integer.valueOf(FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap()
                    .get("userIdNumber"));
            bankingSystemUser = bankingTransactionRepository.searchBankingSystemUserById(userIdNumber);
            workerInput.setBankingSystemUser(bankingSystemUser);
            
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "edituser";
    }
    
}

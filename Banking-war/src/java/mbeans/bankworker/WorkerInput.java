/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.bankworker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mbeans.IndexController;
import repository.BankingTransactionRepository;
import repository.entities.BankingSystemUser;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "workerInput")
@SessionScoped
public class WorkerInput implements Serializable{
    
    private List<BankingSystemUser> allBankingSystemUser;
    private BankingSystemUser bankingSystemUser;
    
    @EJB
    private BankingTransactionRepository bankingTransactionRepository;
    
    public WorkerInput() {
    }

    public List<BankingSystemUser> getAllBankingSystemUser() {
        try {
            allBankingSystemUser = bankingTransactionRepository.getAllBankingSystemUser();
        } catch (Exception ex) {
            Logger.getLogger(BankWorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allBankingSystemUser;
    }

    public void setAllBankingSystemUser(List<BankingSystemUser> allBankingSystemUser) {
        this.allBankingSystemUser = allBankingSystemUser;
    }

    public BankingSystemUser getBankingSystemUser() {
        return bankingSystemUser;
    }

    public void setBankingSystemUser(BankingSystemUser bankingSystemUser) {
        this.bankingSystemUser = bankingSystemUser;
    }
    
//    public void getAllUsers()
//    {
//        try {
//            allBankingSystemUser = bankingTransactionRepository.getAllBankingSystemUser();
//        } catch (Exception ex) {
//            Logger.getLogger(BankWorkerController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}

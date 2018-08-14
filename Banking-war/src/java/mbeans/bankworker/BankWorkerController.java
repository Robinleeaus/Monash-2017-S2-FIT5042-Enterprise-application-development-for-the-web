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
import mbeans.IndexController;
import repository.BankingTransactionRepository;
import repository.entities.BankingSystemUser;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "bankWorkerController")
@RequestScoped
public class BankWorkerController {
    
    private String pageTitle;
    
//    @ManagedProperty(value="#{workerInput}")
//    private WorkerInput workerInput;
//    
//    @EJB
//    private BankingTransactionRepository bankingTransactionRepository;

    public BankWorkerController() {
        pageTitle = "Bank Worker Home Page";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.publicuser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author robinlee
 */
@ManagedBean(name = "depositResultController")
@RequestScoped
public class DepositResultController {
        
    private String pageTitle;
    
    /**
     * Creates a new instance of SearchTransactionController
     */
    public DepositResultController() {
        pageTitle = "Deposit Result";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}

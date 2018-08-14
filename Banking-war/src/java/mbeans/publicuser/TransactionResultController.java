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
@ManagedBean(name = "transactionResultController")
@RequestScoped
public class TransactionResultController {
        
    private String pageTitle;
    
    /**
     * Creates a new instance of SearchTransactionController
     */
    public TransactionResultController() {
        pageTitle = "Transaction Result";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author robinlee
 */
//@Named(value = "indexController")
@ManagedBean(name = "indexController")
@RequestScoped
public class IndexController {
    
    private String pageTitle;

//    @ManagedProperty(value="#{userInput}")
//    private UserInput userInput;
//    
//    @EJB
//    private BankingTransactionRepository bankingTransactionRepository;
     
    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
        pageTitle = "Banking Enterprise Application";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
}

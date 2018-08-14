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
//@Named(value = "publicController")
@ManagedBean(name = "publicController")
@RequestScoped
public class PublicController {
    
    private String pageTitle;

//    @ManagedProperty(value="#{userInput}")
//    private mbeans.UserInput userInput;
//    
//    @EJB
//    private BankingTransactionRepository bankingTransactionRepository;
     
     
    /**
     * Creates a new instance of IndexController
     */
    public PublicController() {
        pageTitle = "Public User Home Page";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

}

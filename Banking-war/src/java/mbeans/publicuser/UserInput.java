/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans.publicuser;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import repository.entities.BankingAccount;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
//@Named(value = "userInput")
@ManagedBean(name = "userInput")
@SessionScoped
public class UserInput implements Serializable{

    // For search transaction
    private String searchMethod;
    private String searchKeyword;
    
    private List<BankingTransaction> queriedResult;
    
    // For use transaction
    private int userId;
    private Set<BankingAccount> accounts;
    
    // For user transaction person & transfer fund $ deposit
    private BankingAccount fromAccount;
    private BankingAccount toAccount;
    private BankingTransaction newBankingTransaction;
    private boolean enoughBalance;
    private boolean validToAccount;
    private boolean transactionSuccess;
    private boolean depositSuccess;
    
    /**
     * Creates a new instance of UserInput
     */
    
    public UserInput() {
    }

    public String getSearchMethod() {
        return searchMethod;
    }

    public void setSearchMethod(String searchMethod) {
        this.searchMethod = searchMethod;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public List<BankingTransaction> getQueriedResult() {
        return queriedResult;
    }

    public void setQueriedResult(List<BankingTransaction> queriedResult) {
        this.queriedResult = queriedResult;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<BankingAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<BankingAccount> accounts) {
        this.accounts = accounts;
    }

    public BankingAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(BankingAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    public BankingAccount getToAccount() {
        return toAccount;
    }

    public void setToAccount(BankingAccount toAccount) {
        this.toAccount = toAccount;
    }

    public BankingTransaction getNewBankingTransaction() {
        return newBankingTransaction;
    }

    public void setNewBankingTransaction(BankingTransaction newBankingTransaction) {
        this.newBankingTransaction = newBankingTransaction;
    }

    public boolean isEnoughBalance() {
        return enoughBalance;
    }

    public void setEnoughBalance(boolean enoughBalance) {
        this.enoughBalance = enoughBalance;
    }

    public boolean isValidToAccount() {
        return validToAccount;
    }

    public void setValidToAccount(boolean validToAccount) {
        this.validToAccount = validToAccount;
    }

    public boolean isTransactionSuccess() {
        return transactionSuccess;
    }

    public void setTransactionSuccess(boolean transactionSuccess) {
        this.transactionSuccess = transactionSuccess;
    }

    public boolean isDepositSuccess() {
        return depositSuccess;
    }

    public void setDepositSuccess(boolean depositSuccess) {
        this.depositSuccess = depositSuccess;
    }

    
    
}

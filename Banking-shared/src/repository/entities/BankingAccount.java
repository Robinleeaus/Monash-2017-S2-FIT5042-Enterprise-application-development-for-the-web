/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author robinlee
 */
@Entity
@Table(name = "BANKING_ACCOUNT")
@NamedQueries({@NamedQuery(name = BankingAccount.GET_ALL_QUERY_NAME, query = "SELECT b FROM BankingAccount b")})
public class BankingAccount implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "BankingAccount.getAll";

    private int accountNumber;
    private String accountType;
    private int balance;
    
//    @ManyToOne
    private BankingSystemUser bankingSystemUser;
//    private BankingSystemUser accountOwner;

    public BankingAccount() {
    }

    public BankingAccount(int accountNumber, String accountType, int balance, BankingSystemUser bankingSystemUser) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.bankingSystemUser = bankingSystemUser;
//        this.accountOwner = bankingSystemUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "account_type")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @ManyToOne
    @JoinColumn( name = "User_idNumber")
    public BankingSystemUser getBankingSystemUser() {
        return bankingSystemUser;
//        return accountOwner;
    }

    public void setBankingSystemUser(BankingSystemUser bankingSystemUser) {
        this.bankingSystemUser = bankingSystemUser;
//        this.accountOwner = bankingSystemUser;
    }

}

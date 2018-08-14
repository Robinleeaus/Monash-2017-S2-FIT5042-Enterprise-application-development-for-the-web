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
@Table(name = "BANKING_TRANSACTION")
@NamedQueries({@NamedQuery(name = BankingTransaction.GET_ALL_QUERY_NAME, query = "SELECT t FROM BankingTransaction t")})
public class BankingTransaction implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "BankingTransaction.getAll";

    private int bankingTransactionNumber;
    private String bankingTransactionName;
    private String type;  //Credit, Debit
    private String description;
    
    private int amount;


    private BankingSystemUser bankingSystemUser;
    
    public BankingTransaction() {
    }

    public BankingTransaction(int bankingTransactionNumber, String bankingTransactionName, String type, String description, BankingSystemUser bankingSystemUser, int amount) {
        this.bankingTransactionNumber = bankingTransactionNumber;
        this.bankingTransactionName = bankingTransactionName;
        this.type = type;
        this.description = description;
        this.bankingSystemUser = bankingSystemUser;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banking_transaction_number")
    public int getBankingTransactionNumber() {
        return bankingTransactionNumber;
    }

    public void setBankingTransactionNumber(int bankingTransactionNumber) {
        this.bankingTransactionNumber = bankingTransactionNumber;
    }

    @Column(name = "banking_transaction_name")
    public String getBankingTransactionName() {
        return bankingTransactionName;
    }

    public void setBankingTransactionName(String bankingTransactionName) {
        this.bankingTransactionName = bankingTransactionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn( name = "User_idNumber")
    public BankingSystemUser getBankingSystemUser() {
        return bankingSystemUser;
    }

    public void setBankingSystemUser(BankingSystemUser bankingSystemUser) {
        this.bankingSystemUser = bankingSystemUser;
    }

    @Override
    public String toString() {
        return "BankingTransaction{" + "bankingTransactionNumber=" + bankingTransactionNumber + ", bankingTransactionName=" + bankingTransactionName + ", type=" + type + ", description=" + description + ", bankingSystemUser=" + bankingSystemUser + '}';
    }
    
}

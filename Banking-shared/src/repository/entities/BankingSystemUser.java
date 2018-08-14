/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author robinlee
 */
@Entity
@Table(name = "BANKING_SYSTEM_USER")
@NamedQueries({@NamedQuery(name = BankingSystemUser.GET_ALL_QUERY_NAME, query = "SELECT b FROM BankingSystemUser b")})
public class BankingSystemUser implements Serializable {
    public static final String GET_ALL_QUERY_NAME = "BankingSystemUser.getAll";

    private int idNumber;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String type;
    private String address;
    private String phoneNumber;
    
//    @OneToMany(mappedBy = "bankingSystemUser")
    private Set<BankingTransaction> bankingTransactions;
//    @OneToMany(mappedBy = "BankingSystemUser")
    private Set<BankingAccount> bankingAccounts;

    public BankingSystemUser() {
    }

    public BankingSystemUser(int idNumber, String lastName, String firstName, String email, String password, String type, String address, String phoneNumber) {
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "bankingSystemUser")
    public Set<BankingTransaction> getBankingTransactions() {
        return bankingTransactions;
    }

    public void setBankingTransactions(Set<BankingTransaction> bankingTransactions) {
        this.bankingTransactions = bankingTransactions;
    }

    @OneToMany(mappedBy = "bankingSystemUser")
    public Set<BankingAccount> getBankingAccounts() {
        return bankingAccounts;
    }

    public void setBankingAccounts(Set<BankingAccount> bankingAccounts) {
        this.bankingAccounts = bankingAccounts;
    }

    @Override
    public String toString() {
        return "BankingSystemUser{" + "idNumber=" + idNumber + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", password=" + password + ", type=" + type + ", address=" + address + ", phoneNumber=" + phoneNumber + ", bankingTransactions=" + bankingTransactions + ", bankingAccounts=" + bankingAccounts + '}';
    }

    

}

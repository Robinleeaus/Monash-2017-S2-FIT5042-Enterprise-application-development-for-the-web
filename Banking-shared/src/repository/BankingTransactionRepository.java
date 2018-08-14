/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import repository.entities.BankingAccount;
import repository.entities.BankingSystemUser;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
@Remote
public interface BankingTransactionRepository {
    
    /**
     * Add the banking transaction being passed as parameter into the repository
     *
     * @param bankingTransaction - the banking transaction to add
     * @throws java.lang.Exception
     */
    public void addBankingTransaction(BankingTransaction bankingTransaction) throws Exception;

    /**
     * Return all the banking transaction in the repository
     *
     * @return all the banking transaction in the repository
     * @throws java.lang.Exception
     */
    public List<BankingTransaction> getAllBankingTransaction() throws Exception;
    

    
    /**
     * Search for a banking transaction by its banking system user
     *
     * @param bankingSystemUser - the banking system user of the banking transaction to search for
     * @return the banking transaction found
     * @throws java.lang.Exception
     */
    public Set<BankingTransaction> searchBankingTransactionByBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception;
    
    /**
     * Search for a banking transaction by its type
     *
     * @param type - the type of the banking transaction to search for
     * @return the banking transaction found
     * @throws java.lang.Exception
     */
    public List<BankingTransaction> searchBankingTransactionByType(String type) throws Exception;
    
    /**
     * Search for a banking transaction by its name
     *
     * @param bankingTransactionName - the number of the banking transaction to search for
     * @return the banking transaction found
     * @throws java.lang.Exception
     */
    public List<BankingTransaction> searchBankingTransactionByName(String bankingTransactionName) throws Exception;
    
    /**
     * Search for a banking transaction by its number
     *
     * @param bankingTransactionNumber - the number of the banking transaction to search for
     * @return the banking transaction found
     * @throws java.lang.Exception
     */
    public BankingTransaction searchBankingTransactionByNumber(int bankingTransactionNumber) throws Exception;

    /**
     * Update a banking transaction in the repository
     *
     * @param bankingTransaction - the updated information regarding a banking transaction
     * @throws java.lang.Exception
     */
    public void editBankingTransaction(BankingTransaction bankingTransaction) throws Exception;
    
    /**
     * Remove the banking transaction, whose number matches the one being passed as parameter, from the repository
     *
     * @param bankingTransactionNumber - the number of the banking transaction to remove
     * @throws java.lang.Exception
     */
    public void removeBankingTransaction(int bankingTransactionNumber) throws Exception;
    
    /**
     * Add the banking system user being passed as parameter into the repository
     *
     * @param bankingSystemUser - the banking system user to add
     * @throws java.lang.Exception
     */
    public void addBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception;
    
    /**
     * Return all the banking system users in the repository
     *
     * @return all the banking system user in the repository
     * @throws java.lang.Exception
     */
    public List<BankingSystemUser> getAllBankingSystemUser() throws Exception;
    
    /**
     * Search for a banking system user by its id
     *
     * @param idNumber - the id number of the banking system user to search for
     * @return the banking system user found
     * @throws java.lang.Exception
     */
    public BankingSystemUser searchBankingSystemUserById(int idNumber) throws Exception;
    
    /**
     * Update a banking system user in the repository
     *
     * @param bankingSystemUser - the updated information regarding a banking system user
     * @throws java.lang.Exception
     */
    public void editBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception;
    
    /**
     * Remove the banking system user, whose number matches the one being passed as parameter, from the repository
     *
     * @param idNumber - the number of the banking system user to remove
     * @throws java.lang.Exception
     */
    public void removeBankingSystemUser(int idNumber) throws Exception;
    
    /**
     * Add the banking account being passed as parameter into the repository
     *
     * @param bankingAccount - the banking account to add
     * @throws java.lang.Exception
     */
    public void addBankingAccount(BankingAccount bankingAccount) throws Exception;
    
    /**
     * Return all the banking account in the repository
     *
     * @return all the banking account in the repository
     * @throws java.lang.Exception
     */
    public List<BankingAccount> getAllBankingAccount() throws Exception;
    
    /**
     * Search for a banking account by its banking system user
     *
     * @param bankingSystemUser - the banking system user of the banking account to search for
     * @return the banking account found
     * @throws java.lang.Exception
     */
    public Set<BankingAccount> searchBankingAccountByBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception;
    
    /**
     * Search for a banking account by its type
     *
     * @param accountType - the type of the banking account to search for
     * @return the banking account found
     * @throws java.lang.Exception
     */
    public List<BankingAccount> searchBankingAccountByType(String accountType) throws Exception;
    
    /**
     * Search for a banking account by its number
     *
     * @param accountNumber - the number of the banking account to search for
     * @return the banking account found
     * @throws java.lang.Exception
     */
    public BankingAccount searchBankingAccountByNumber(int accountNumber) throws Exception;

    /**
     * Update a banking account in the repository
     *
     * @param bankingAccount - the updated information regarding a banking account
     * @throws java.lang.Exception
     */
    public void editBankingAccount(BankingAccount bankingAccount) throws Exception;
    
    /**
     * Remove the banking account, whose number matches the one being passed as parameter, from the repository
     *
     * @param accountNumber - the number of the banking account to remove
     * @throws java.lang.Exception
     */
    public void removeBankingAccount(int accountNumber) throws Exception;
    
    /**
     * Descrease a banking account balance
     *
     * @param bankingAccount - the banking account to be updated
     * @param amount - the amount to be descreased
     * @return the updated banking account
     * @throws java.lang.Exception
     */
    public BankingAccount descreaseBankingAccountBalance(BankingAccount bankingAccount, int amount) throws Exception;
    
    /**
     * Increase a banking account balance
     *
     * @param bankingAccount - the banking account to be updated
     * @param amount - the amount to be increased
     * @return the updated banking account
     * @throws java.lang.Exception
     */
    public BankingAccount increaseBankingAccountBalance(BankingAccount bankingAccount, int amount) throws Exception;
}

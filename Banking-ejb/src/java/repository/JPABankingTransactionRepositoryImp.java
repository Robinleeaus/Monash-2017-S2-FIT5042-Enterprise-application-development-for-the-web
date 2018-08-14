/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import repository.entities.BankingAccount;
import repository.entities.BankingSystemUser;
import repository.entities.BankingTransaction;

/**
 *
 * @author robinlee
 */
@Stateless
public class JPABankingTransactionRepositoryImp implements BankingTransactionRepository {

    @PersistenceContext
    private EntityManager entityManager;
        
    // Banking Transaction operation
    @Override
    public void addBankingTransaction(BankingTransaction bankingTransaction) throws Exception {
        entityManager.persist(bankingTransaction);
    }

    @Override
    public List<BankingTransaction> getAllBankingTransaction() throws Exception {
        return entityManager.createNamedQuery(BankingTransaction.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<BankingTransaction> searchBankingTransactionByBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception {
        bankingSystemUser = entityManager.find(BankingSystemUser.class, bankingSystemUser.getIdNumber());
        bankingSystemUser.getBankingTransactions().size();
        entityManager.refresh(bankingSystemUser);

        return bankingSystemUser.getBankingTransactions();
    }

    @Override
    public List<BankingTransaction> searchBankingTransactionByType(String type) throws Exception {
        CriteriaBuilder qBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BankingTransaction> cQuery = qBuilder.createQuery(BankingTransaction.class);
        Root<BankingTransaction> b = cQuery.from(BankingTransaction.class);
        // Search by exact keyword
        //Predicate condition = qBuilder.equal(b.get("type").as(String.class), type);
        // search by partial keyword and ignore case
        Predicate condition = qBuilder.like(qBuilder.lower(b.get("type").as(String.class)), "%" + type.toLowerCase() + "%");
        cQuery.where(condition);
        TypedQuery<BankingTransaction> tQuery = entityManager.createQuery(cQuery);
        List<BankingTransaction> result = tQuery.getResultList();
        
        return result;
    }

    @Override
    public List<BankingTransaction> searchBankingTransactionByName(String bankingTransactionName) throws Exception {
        CriteriaBuilder qBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BankingTransaction> cQuery = qBuilder.createQuery(BankingTransaction.class);
        Root<BankingTransaction> b = cQuery.from(BankingTransaction.class);
        //Predicate condition = qBuilder.equal(b.get("bankingTransactionName").as(String.class), bankingTransactionName);
        // search by partial keyword and ignore case
        Predicate condition = qBuilder.like(qBuilder.lower(b.get("bankingTransactionName").as(String.class)), "%" + bankingTransactionName.toLowerCase() + "%");
        cQuery.where(condition);
        TypedQuery<BankingTransaction> tQuery = entityManager.createQuery(cQuery);
        List<BankingTransaction> result = tQuery.getResultList();
        
        return result;
    }

    @Override
    public BankingTransaction searchBankingTransactionByNumber(int bankingTransactionNumber) throws Exception {
        BankingTransaction bankingTransaction = entityManager.find(BankingTransaction.class, bankingTransactionNumber);
        return bankingTransaction;
    }

    @Override
    public void editBankingTransaction(BankingTransaction bankingTransaction) throws Exception {
        entityManager.merge(bankingTransaction);
    }

    @Override
    public void removeBankingTransaction(int bankingTransactionNumber) throws Exception {
        BankingTransaction bankingTransaction = this.searchBankingTransactionByNumber(bankingTransactionNumber);

        if (bankingTransaction != null) {
            entityManager.remove(bankingTransaction);
        }
    }
    
    //Banking System User operation
    @Override
    public void addBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception {
        entityManager.persist(bankingSystemUser);
    }
    
    @Override
    public List<BankingSystemUser> getAllBankingSystemUser() throws Exception {
        return entityManager.createNamedQuery(BankingSystemUser.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public BankingSystemUser searchBankingSystemUserById(int idNumber) throws Exception {
        BankingSystemUser bankingSystemUser = entityManager.find(BankingSystemUser.class, idNumber);
        return bankingSystemUser;
    }

    @Override
    public void editBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception {
        entityManager.merge(bankingSystemUser);
    }

    @Override
    public void removeBankingSystemUser(int idNumber) throws Exception {
        BankingSystemUser bankingSystemUser = this.searchBankingSystemUserById(idNumber);

        if (bankingSystemUser != null) {
            entityManager.remove(bankingSystemUser);
        }
    }

    // Banking Account operation
    @Override
    public void addBankingAccount(BankingAccount bankingAccount) throws Exception {
        entityManager.persist(bankingAccount);
    }

    @Override
    public List<BankingAccount> getAllBankingAccount() throws Exception {
        return entityManager.createNamedQuery(BankingAccount.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<BankingAccount> searchBankingAccountByBankingSystemUser(BankingSystemUser bankingSystemUser) throws Exception {
        bankingSystemUser = entityManager.find(BankingSystemUser.class, bankingSystemUser.getIdNumber());
        bankingSystemUser.getBankingAccounts().size();
        entityManager.refresh(bankingSystemUser);

        return bankingSystemUser.getBankingAccounts();
    }

    @Override
    public List<BankingAccount> searchBankingAccountByType(String accountType) throws Exception {
        CriteriaBuilder qBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BankingAccount> cQuery = qBuilder.createQuery(BankingAccount.class);
        Root<BankingAccount> b = cQuery.from(BankingAccount.class);
        // Search by exact keyword
        //Predicate condition = qBuilder.equal(b.get("accountType").as(String.class), accountType);
        // search by partial keyword and ignore case
        Predicate condition = qBuilder.like(qBuilder.lower(b.get("accountType").as(String.class)), "%" + accountType.toLowerCase() + "%");
        cQuery.where(condition);
        TypedQuery<BankingAccount> tQuery = entityManager.createQuery(cQuery);
        List<BankingAccount> result = tQuery.getResultList();
        
        return result;
    }

    @Override
    public BankingAccount searchBankingAccountByNumber(int accountNumber) throws Exception {
        BankingAccount bankingAccount = entityManager.find(BankingAccount.class, accountNumber);
        return bankingAccount;
    }

    @Override
    public void editBankingAccount(BankingAccount bankingAccount) throws Exception {
        entityManager.merge(bankingAccount);
    }

    @Override
    public void removeBankingAccount(int accountNumber) throws Exception {
        BankingAccount bankingAccount = this.searchBankingAccountByNumber(accountNumber);

        if (bankingAccount != null) {
            entityManager.remove(bankingAccount);
        }
    }

    @Override
    public BankingAccount descreaseBankingAccountBalance(BankingAccount bankingAccount, int amount) throws Exception {
        int oldBalance = bankingAccount.getBalance();
        int newBalance = oldBalance - amount;
        bankingAccount.setBalance(newBalance);
        return bankingAccount;
    }

    @Override
    public BankingAccount increaseBankingAccountBalance(BankingAccount bankingAccount, int amount) throws Exception {
        int oldBalance = bankingAccount.getBalance();
        int newBalance = oldBalance + amount;
        bankingAccount.setBalance(newBalance);
        return bankingAccount;
    }
    

    
}

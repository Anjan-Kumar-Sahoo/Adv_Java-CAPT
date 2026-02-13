package com.capT.OTM_Mapping;

import java.util.List;
import jakarta.persistence.*;

public class BankAccountCRUD_implementation implements BankAccountCRUD {
    
    private EntityManagerFactory emf;
    
    public BankAccountCRUD_implementation() {
        this.emf = Persistence.createEntityManagerFactory("dev");
    }

    @Override
    public void saveBank(Bank bank) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(bank);
            et.commit();
            System.out.println("Bank saved successfully with ID: " + bank.getId());
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            System.out.println("Error saving bank: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void updateBank(Bank bank) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(bank);
            et.commit();
            System.out.println("Bank updated successfully!");
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            System.out.println("Error updating bank: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Bank findBankById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Bank bank = em.find(Bank.class, id);
            if (bank != null) {
                // Initialize lazy collections
                bank.getAccounts().size();
            }
            return bank;
        } catch (Exception e) {
            System.out.println("Error finding bank: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Bank findBankByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Bank> query = em.createQuery(
                "SELECT b FROM Bank b WHERE b.name = :name", Bank.class);
            query.setParameter("name", name);
            Bank bank = query.getSingleResult();
            if (bank != null) {
                // Initialize lazy collections
                bank.getAccounts().size();
            }
            return bank;
        } catch (NoResultException e) {
            System.out.println("No bank found with name: " + name);
            return null;
        } catch (Exception e) {
            System.out.println("Error finding bank: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void assignAccountToBank(int bankId, Account newAccount) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Bank bank = em.find(Bank.class, bankId);
            if (bank != null) {
                newAccount.setB(bank);
                em.persist(newAccount);
                et.commit();
                System.out.println("Account assigned to bank successfully!");
            } else {
                System.out.println("Bank not found with ID: " + bankId);
                et.rollback();
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            System.out.println("Error assigning account to bank: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void assignAccountsToBank(String bankName, List<Account> accounts) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Bank> query = em.createQuery(
                "SELECT b FROM Bank b WHERE b.name = :name", Bank.class);
            query.setParameter("name", bankName);
            Bank bank = query.getSingleResult();
            
            if (bank != null) {
                for (Account account : accounts) {
                    account.setB(bank);
                    em.persist(account);
                }
                et.commit();
                System.out.println(accounts.size() + " accounts assigned to bank successfully!");
            } else {
                System.out.println("Bank not found with name: " + bankName);
                et.rollback();
            }
        } catch (NoResultException e) {
            System.out.println("No bank found with name: " + bankName);
            if (et.isActive()) {
                et.rollback();
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            System.out.println("Error assigning accounts to bank: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Account> findAllAccountsOfBank(int bankId) {
        EntityManager em = emf.createEntityManager();
        try {
            Bank bank = em.find(Bank.class, bankId);
            if (bank != null) {
                // Initialize lazy collection
                List<Account> accounts = bank.getAccounts();
                accounts.size(); // Force initialization
                return accounts;
            } else {
                System.out.println("Bank not found with ID: " + bankId);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error finding accounts: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
    public void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

package com.capT.OTM_Mapping;

import java.util.List;

public interface BankAccountCRUD {
    void saveBank(Bank bank);
    void updateBank(Bank bank);
    Bank findBankById(int id);
    Bank findBankByName(String name);
    void assignAccountToBank(int bannkId, Account newAccount);
    void assignAccountsToBank(String bankName, List<Account> accounts);
    List<Account> findAllAccountsOfBank(int bankId);
    void closeFactory();
}
package com.capT.OTM_Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountMAIN {
    
    private static BankAccountCRUD crud = new BankAccountCRUD_implementation();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    saveBank();
                    break;
                case 2:
                    updateBank();
                    break;
                case 3:
                    findBankById();
                    break;
                case 4:
                    findBankByName();
                    break;
                case 5:
                    assignAccountToBank();
                    break;
                case 6:
                    assignMultipleAccountsToBank();
                    break;
                case 7:
                    findAllAccountsOfBank();
                    break;
                case 8:
                    System.out.println("Exiting application...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (!exit) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        crud.closeFactory();
        scanner.close();
        System.out.println("Thank you for using Bank Account Management System!");
    }
    
    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("  BANK ACCOUNT MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Save New Bank");
        System.out.println("2. Update Bank");
        System.out.println("3. Find Bank by ID");
        System.out.println("4. Find Bank by Name");
        System.out.println("5. Assign Account to Bank");
        System.out.println("6. Assign Multiple Accounts to Bank");
        System.out.println("7. Find All Accounts of a Bank");
        System.out.println("8. Exit");
        System.out.println("========================================");
    }
    
    private static void saveBank() {
        System.out.println("\n--- Save New Bank ---");
        
        System.out.print("Enter Bank ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Bank Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Bank Location: ");
        String location = scanner.nextLine();
        
        Bank bank = new Bank();
        bank.setId(id);
        bank.setName(name);
        bank.setLocation(location);
        
        crud.saveBank(bank);
    }
    
    private static void updateBank() {
        System.out.println("\n--- Update Bank ---");
        
        System.out.print("Enter Bank ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Bank bank = crud.findBankById(id);
        if (bank != null) {
            System.out.println("Current Bank Details:");
            displayBankDetails(bank);
            
            System.out.print("\nEnter new Bank Name (or press Enter to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                bank.setName(name);
            }
            
            System.out.print("Enter new Bank Location (or press Enter to keep current): ");
            String location = scanner.nextLine();
            if (!location.isEmpty()) {
                bank.setLocation(location);
            }
            
            crud.updateBank(bank);
        } else {
            System.out.println("Bank not found!");
        }
    }
    
    private static void findBankById() {
        System.out.println("\n--- Find Bank by ID ---");
        
        System.out.print("Enter Bank ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Bank bank = crud.findBankById(id);
        if (bank != null) {
            displayBankDetails(bank);
        } else {
            System.out.println("Bank not found!");
        }
    }
    
    private static void findBankByName() {
        System.out.println("\n--- Find Bank by Name ---");
        
        System.out.print("Enter Bank Name: ");
        String name = scanner.nextLine();
        
        Bank bank = crud.findBankByName(name);
        if (bank != null) {
            displayBankDetails(bank);
        } else {
            System.out.println("Bank not found!");
        }
    }
    
    private static void assignAccountToBank() {
        System.out.println("\n--- Assign Account to Bank ---");
        
        System.out.print("Enter Bank ID: ");
        int bankId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Account Name: ");
        String accountName = scanner.nextLine();
        
        System.out.print("Enter Account Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        Account account = new Account();
        account.setId(accountId);
        account.setName(accountName);
        account.setBalance(balance);
        
        crud.assignAccountToBank(bankId, account);
    }
    
    private static void assignMultipleAccountsToBank() {
        System.out.println("\n--- Assign Multiple Accounts to Bank ---");
        
        System.out.print("Enter Bank Name: ");
        String bankName = scanner.nextLine();
        
        System.out.print("How many accounts do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<Account> accounts = new ArrayList<>();
        
        for (int i = 1; i <= count; i++) {
            System.out.println("\nEnter details for Account " + i + ":");
            
            System.out.print("Enter Account ID: ");
            int accountId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter Account Name: ");
            String accountName = scanner.nextLine();
            
            System.out.print("Enter Account Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            Account account = new Account();
            account.setId(accountId);
            account.setName(accountName);
            account.setBalance(balance);
            
            accounts.add(account);
        }
        
        crud.assignAccountsToBank(bankName, accounts);
    }
    
    private static void findAllAccountsOfBank() {
        System.out.println("\n--- Find All Accounts of a Bank ---");
        
        System.out.print("Enter Bank ID: ");
        int bankId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<Account> accounts = crud.findAllAccountsOfBank(bankId);
        
        if (accounts != null && !accounts.isEmpty()) {
            System.out.println("\nTotal Accounts: " + accounts.size());
            System.out.println("----------------------------------------");
            for (Account account : accounts) {
                System.out.println("Account ID: " + account.getId());
                System.out.println("Account Name: " + account.getName());
                System.out.println("Balance: $" + account.getBalance());
                System.out.println("----------------------------------------");
            }
        } else if (accounts != null) {
            System.out.println("No accounts found for this bank.");
        }
    }
    
    private static void displayBankDetails(Bank bank) {
        System.out.println("\n========== Bank Details ==========");
        System.out.println("Bank ID: " + bank.getId());
        System.out.println("Bank Name: " + bank.getName());
        System.out.println("Location: " + bank.getLocation());
        
        if (bank.getAccounts() != null && !bank.getAccounts().isEmpty()) {
            System.out.println("Number of Accounts: " + bank.getAccounts().size());
            System.out.println("\nAccounts:");
            for (Account account : bank.getAccounts()) {
                System.out.println("  - Account ID: " + account.getId() + 
                                 ", Name: " + account.getName() + 
                                 ", Balance: $" + account.getBalance());
            }
        } else {
            System.out.println("Number of Accounts: 0");
        }
        System.out.println("==================================");
    }
}

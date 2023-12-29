import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        displayBalance();
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully!");
            displayAccountDetails(accountNumber);
        } else {
            System.out.println("Account already exists with the given account number.");
        }
    }

    public void displayAccountDetails(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found with the given account number.");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create accounts
        bank.createAccount("123456", "John Doe", 1000.0);
        bank.createAccount("789012", "Jane Smith", 500.0);

        // Perform transactions
        bank.displayAccountDetails("123456");
        bank.displayAccountDetails("789012");

        bank.accounts.get("123456").deposit(200.0);
        bank.accounts.get("789012").withdraw(100.0);
    }
}

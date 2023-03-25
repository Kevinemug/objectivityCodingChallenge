import java.util.Scanner;
import java.util.UUID;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private int pin;

    public BankAccount(String accountHolderName, double balance, int pin) {
        this.accountNumber = UUID.randomUUID().toString();
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount,int enteredPin) {
        System.out.println("Enter your pin.");

        Scanner scan = new Scanner(System.in);
        enteredPin =scan.nextInt();
        if (enteredPin != pin) {
            System.out.println("Invalid PIN. Withdrawal cancelled.");
            return;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
//function to withdraw
    public void withdraw(double amount, int enteredPin) {
        System.out.println("Enter your pin.");

        Scanner scan = new Scanner(System.in);
        enteredPin =scan.nextInt();
        if (enteredPin != pin) {
            System.out.println("Invalid PIN. Withdrawal cancelled.");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter a 4-digit PIN: ");
        int pin = scanner.nextInt();
        BankAccount account = new BankAccount(accountHolderName, balance, pin);

        int choice = 0;
        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount,pin);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount,pin);
                    break;
                case 3:
                    account.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }
}

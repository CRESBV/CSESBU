import java.util.Date;

/**
 * @author edwardBucklerV
 * 111628438
 * L05
 * Design a class named Account that contains:
 *  A private int data field id for the account (default 0)
 *  A private double data field named balance for the account (default 0)
 *  A private double data field named annualInterestRate that stores the current interest
 * rate (default 0). Assume that all accounts have the same interest rate.
 *  A private Date data field named dateCreated that stores the date when the account was
 * created.
 *  A no-arg constructor that creates a default account.
 *  A constructor that creates an account with the specified id and initial balance.
 *  The accessor and mutator methods for id, balance, and annualInterestRate.
 *  The accessor method for dateCreated.
 * <p>
 *  A method named getMonthlyInterestRate() that returns the monthly interest rate.
 *  A method named getMonthlyInterest() that returns the monthly interest.
 *  A method named withdraw that withdraws a specific amount from the account.
 *  A method named deposit that deposits a specific amount to the account.
 * Hint : The method getMonthlyInterest() is to return monthly interest, not the interest rate. Monthly
 * interest is balance * monthlyInterestRate. monthlyInterestRate is annualInterestRate / 12. Note
 * annualInterestRate is a percentage, for example 4.5%. You need to divide it by 100.
 * Write a test program that creates an Account object with an account ID of 1122, a balance of $20,000,
 * and an annual interest rate of 4.5 %. Use the withdrawal method to withdraw $2,500, use the deposit
 * method to deposit $3,000, and print the balance, the monthly interest, and the date when this amount
 * was created.
 */
public class Account {
    private int id;
    private double balance, annualInterestRate;
    private Date dateCreated;

    public static void main(String[] args) {
        Account testing = new Account(1122, 20000);
        testing.setAnnualInterestRate(4.5);
        testing.withdraw(2500);
        testing.deposit(3000);
        System.out.println("testing.getBalance() = " + testing.getBalance());
        System.out.println("testing.getMonthlyInterest() = " + testing.getMonthlyInterest());
        System.out.println("testing.getDateCreated() = " + testing.getDateCreated());
    }

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 12);
    }

    public double getMonthlyInterest() {
        return (getMonthlyInterestRate() * balance);
    }

    public void withdraw(double withdrawing) {
        balance -= withdrawing;
    }

    public void deposit(double depositing) {
        balance += depositing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate/100;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}

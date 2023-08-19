package OperationsofATM;

public class Deposit extends User{
    private double amt;
    private double balance;
    public Deposit(double amount, String name, String type, String number, double bal) {
        super(name, type,number,bal);
        amt = amount;
        balance = bal;
    }

    @Override
    public void calc() {
        if (amt > 0) {
        balance = amt + balance;
        System.out.println("Amount Deposited Successfully!!");
        }
        else {
            System.out.println("Amount Failed to Deposit!!");
        }
    }

    @Override
    public double display() {
        return balance;
    }
}

package OperationsofATM;

public class Withdrawal extends User{
    private double amt;
    private double balance;
    public Withdrawal(double amount, String name, String type, String number, double bal) {
        super(name, type,number,bal);
        amt = amount;
        balance = bal;
    }

    @Override
    public void calc() {
        if (amt > 0 && balance >= amt) {
            balance = balance - amt;
            System.out.println("Amount withdrawn Successfully!!");
        }
        else {
            System.out.println("Amount failed to withdraw!!");
        }
   }

   @Override
   public double display() {
        return balance;
    }
}

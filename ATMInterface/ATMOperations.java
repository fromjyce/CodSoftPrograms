import OperationsofATM.*;
import java.util.*;

public class ATMOperations {
    String name, num, type;
    int choice;
    Scanner scan = new Scanner(System.in);
    double balance;
    public static void main (String[] args) {
        ATMOperations atmop = new ATMOperations();
        atmop.askuser();
        atmop.choice();

    }
    void askuser() {
        System.out.println("Welcome to ATM");
        System.out.print("Enter the type of your Account: ");
        type = scan.nextLine();
        System.out.print("Enter Account Number: ");
        num = scan.nextLine();
        System.out.print("Enter Account Holder Name: ");
        name = scan.nextLine();
        System.out.print("Enter Account Balance: ");
        balance = scan.nextDouble();
        scan.nextLine();
    }

    void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amt = scan.nextDouble();
        Withdrawal wdraw = new Withdrawal(amt,name,type,num,balance);
        wdraw.calc();
        balance = wdraw.display();
    }

    void deposit() {
        System.out.print("Enter the amount to deposit:  ");
        double amt = scan.nextDouble();
        Deposit deposit = new Deposit(amt,name,type,num,balance);
        deposit.calc();
        balance = deposit.display();

    }
    void checkbalance() {
        System.out.println("Account Information");
        System.out.println("Account Number: " + num);
        System.out.println("Account Type: " + type);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Balance: "+ balance);
    }

    void choice() {
        while(choice!=4) {
            System.out.print("Do you want to\n1. Withdraw Money\n2. Deposit Money\n3. Check Balance\n4. Exit\nEnter Your choice: ");
            choice = scan.nextInt();
            if (choice==1) {
                withdraw();
        }
            else if (choice==2) {
                deposit();
            }
            else if (choice==3) {
                checkbalance();
            }
    }

    
}
}

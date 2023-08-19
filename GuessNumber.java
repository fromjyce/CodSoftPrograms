import java.util.*;

public class GuessNumber {
    public static void main (String[] args) {
        System.out.println("Welcome to Number Guessing Game!!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Upper Limit: ");
        int limit = scan.nextInt();
        Random random = new Random();
        int orgno = random.nextInt(limit);
        System.out.println(orgno);
        int count = 0;
        while (count!=5){
            System.out.print("Enter the number: ");
            int guess = scan.nextInt();
            if (guess==orgno) {
                System.out.println("Congrats!!You have won the game!!");
                break;
            }
            else if (guess > orgno) {
                System.out.println("Your guess is too high");
            }
            else {
                System.out.println("Your guess is too low");
            }
            count++;
        }
        scan.nextLine();
        if (count==5) {
            System.out.print("You have lost the game..\nDo you want to play again?");
            String choice = scan.nextLine();
            if (choice.equals("yes") || choice.equals("YES") || choice.equals("Yes")) {
                main(args);
            } 
            else {
                System.out.println("Thank you for playing with us!!");
                System.exit(0);
            }
        }
        else {
            System.out.print("Do you want to play again?");
            String choice = scan.nextLine();
            if (choice.equals("yes") || choice.equals("YES") || choice.equals("Yes")) {
                main(args);
            } 
            else {
                System.out.println("Thank you for playing with us!!");
                System.exit(0);
            }
        }
        scan.close();
    }
}

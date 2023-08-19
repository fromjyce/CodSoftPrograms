import java.util.*;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Student Grade Calculator!!!");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Number of subjects: ");
        int subjects = scan.nextInt();
        System.out.println("Enter the Marks for each subject: ");
        int sum = 0;
        for (int i=0; i<subjects; i++){
            System.out.printf("Subject %d: ", i+1);
            int mark = scan.nextInt();
            sum += mark;
        }
        double avg = CalculateAverage(sum, subjects);
        String grade = CalculateGrade(avg);
        System.out.printf("Total: %d \nAverage: %5.2f \nGrade: %S", sum, avg, grade);
        scan.close();
    }

    public static double CalculateAverage(int sum, int no){
        return (double) (sum/no);
    }

    public static String CalculateGrade(double avg) {
        String grade;
        if (90 <= avg && avg <= 100) {
            grade = "A+";
        }
        else if (80 <= avg && avg < 89) {
            grade = "A";
        }
        else if (70 <= avg && avg < 79) {
            grade = "B+";
        }
        else if (60 <= avg && avg < 69){
            grade = "B";
        }
        else if (50 <= avg && avg < 59) {
            grade = "C+";
        }
        else if (40 <= avg && avg < 49) {
            grade = "C";
        }
        else if (30 <= avg && avg < 39) {
            grade = "D";
        }
        else {
            grade = "F";
        }
        return grade;
    }
}

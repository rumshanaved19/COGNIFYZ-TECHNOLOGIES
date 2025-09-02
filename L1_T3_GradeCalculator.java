package COGNIFYZ_TECHNOLOGIES;
import java.util.*;
public class L1_T3_GradeCalculator
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        
        if (!scanner.hasNextInt()) 
        {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.close();
            return;
        }
        int numberOfSubjects = scanner.nextInt();
        
        if (numberOfSubjects <= 0) 
        {
            System.out.println("Number of subjects must be positive.");
            scanner.close();
            return;
        }

        int totalMarks = 0;
        
        for (int i = 1; i <= numberOfSubjects; i++)
         {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            if (!scanner.hasNextInt())
             {
                System.out.println("Invalid input. Please enter a valid number for marks.");
                scanner.close();
                return;
            }
            int marks = scanner.nextInt();
            if (marks < 0 || marks > 100)
             {
                System.out.println("Marks must be between 0 and 100. Please try again.");
                i--;
                continue;
            }

            totalMarks += marks;
        }
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n-----------------------------");
        System.out.println("     Student Grade Report    ");
        System.out.println("-----------------------------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------");

        scanner.close();
    }
}
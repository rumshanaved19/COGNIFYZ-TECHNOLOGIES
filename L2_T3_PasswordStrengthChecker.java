package COGNIFYZ_TECHNOLOGIES;
import java.util.Scanner;
public class L2_T3_PasswordStrengthChecker 
{

    public static void main(String[] args)
     {
        try (Scanner scanner = new Scanner(System.in)) 
        {
            System.out.println("--- Password Strength Checker ---");
            System.out.print("Enter a password to analyze: ");

            String password = scanner.nextLine();

            analyzePassword(password);

        } 
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void analyzePassword(String password)
     {
        int strengthScore = 0;

        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() >= 8) 
        {
            strengthScore++;
        }
        if (password.length() >= 12)
         {
            strengthScore++;
        }

        for (char c : password.toCharArray()) 
        {
            if (Character.isLowerCase(c)) 
            {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) 
            {
                hasUppercase = true;
            } else if (Character.isDigit(c))
             {
                hasDigit = true;
            } 
            else
             {
               
                hasSpecialChar = true;
            }
        }

        if (hasLowercase) 
        {
            strengthScore++;
        }
        if (hasUppercase) 
        {
            strengthScore++;
        }
        if (hasDigit)
         {
            strengthScore++;
        }
        if (hasSpecialChar) 
        {
            strengthScore++;
        }

        System.out.println("\n--- Analysis Report ---");
        if (strengthScore <= 2) {
            System.out.println("Password Strength: Weak");
            System.out.println("Suggestion: Your password is too short or simple. Consider making it longer and adding different character types (e.g., uppercase, numbers, symbols).");
        } else if (strengthScore <= 4) {
            System.out.println("Password Strength: Medium");
            System.out.println("Suggestion: This is a decent password, but it could be stronger. Try adding more character variety or increasing its length.");
        } else {
            System.out.println("Password Strength: Strong");
            System.out.println("Great! Your password meets the criteria for a strong password.");
        }
    }
}

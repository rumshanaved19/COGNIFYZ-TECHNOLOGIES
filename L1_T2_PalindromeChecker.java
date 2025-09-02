package COGNIFYZ_TECHNOLOGIES;
import java.util.Scanner;

public class L1_T2_PalindromeChecker 
{

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user.
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker ---");
        System.out.print("Enter a word or phrase to check: ");

        // Reads the entire line of input from the user.
        String userInput = scanner.nextLine();

        // Checks if the input is a palindrome using our helper method.
        if (isPalindrome(userInput)) 
        {
            System.out.println("Result: '" + userInput + "' is a palindrome!");
        } 
        else
         {
            System.out.println("Result: '" + userInput + "' is not a palindrome.");
        }

        
        scanner.close();
    }

    public static boolean isPalindrome(String originalString) {
        
        String newString = originalString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (newString.length() <= 1) 
        {
            return true;
        }
        // We use the StringBuilder class for an efficient way to reverse a string.
        String reversedString = new StringBuilder(newString).reverse().toString();

        // If they are identical, the original string is a palindrome.
        return newString.equals(reversedString);
    }
}


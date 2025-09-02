package COGNIFYZ_TECHNOLOGIES;
import java.security.SecureRandom;
import java.util.*;

public class L2_T4_RandomPasswordGenerator 
{

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+<>?";
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("--- Random Password Generator ---");

            int passwordLength = getPasswordLength(scanner);

            boolean useLowercase = getUserChoice(scanner, "Include lowercase letters? (y/n): ");
            boolean useUppercase = getUserChoice(scanner, "Include uppercase letters? (y/n): ");
            boolean useNumbers = getUserChoice(scanner, "Include numbers? (y/n): ");
            boolean useSpecial = getUserChoice(scanner, "Include special characters? (y/n): ");

            StringBuilder characterPool = new StringBuilder();
            if (useLowercase) {
                characterPool.append(LOWERCASE_CHARS);
            }
            if (useUppercase) {
                characterPool.append(UPPERCASE_CHARS);
            }
            if (useNumbers) {
                characterPool.append(NUMERIC_CHARS);
            }
            if (useSpecial) {
                characterPool.append(SPECIAL_CHARS);
            }
            if (characterPool.length() == 0) {
                System.out.println("Error: You must select at least one character type. Exiting.");
                return; // Exit the program
            }
           
            String generatedPassword = generatePassword(passwordLength, characterPool.toString());

            
            System.out.println("\n------------------------------------");
            System.out.println("Your generated password is: " + generatedPassword);
            System.out.println("------------------------------------");

        } catch (Exception e) 
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static int getPasswordLength(Scanner scanner)
     {
        int length = 0;
        while (length <= 0) 
        {
            System.out.print("Enter the desired password length: ");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length <= 0) {
                    System.out.println("Password length must be a positive number. Please try again.");
                }
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
        
        scanner.nextLine();
        return length;
    }

    private static boolean getUserChoice(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    private static String generatePassword(int length, String characterPool) 
    {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) 
        {
            int randomIndex = random.nextInt(characterPool.length());
            
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }
}
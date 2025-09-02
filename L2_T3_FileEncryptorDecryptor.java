package COGNIFYZ_TECHNOLOGIES;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class L2_T3_FileEncryptorDecryptor 
{
    private static final int SHIFT_KEY = 3;
    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("--- File Encryption/Decryption Tool ---");
            System.out.println("Select an operation:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.print("Enter your choice (1 or 2): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter the path to the input file: ");
            String inputFilePath = scanner.nextLine();

            String outputFilePath;
            boolean isEncryptMode;

            if (choice == 1) 
            {
                isEncryptMode = true;
                outputFilePath = getOutputFileName(inputFilePath, ".encrypted");
            } else if (choice == 2)
             {
                isEncryptMode = false;
                outputFilePath = getOutputFileName(inputFilePath, ".decrypted");
            } 
            else
             {
                System.out.println("Invalid choice. Please run the program again and select 1 or 2.");
                return;
            }
            processFile(inputFilePath, outputFilePath, isEncryptMode);
        }
    }

    private static void processFile(String inputPath, String outputPath, boolean encrypt)
     {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath)))
             {

            String line;
            
            while ((line = reader.readLine()) != null) 
            {
                StringBuilder processedLine = new StringBuilder();
                for (char character : line.toCharArray())
                 {
                    char processedChar;
                    if (encrypt) 
                    {
                        processedChar = (char) (character + SHIFT_KEY);
                    }
                     else
                     {
                        processedChar = (char) (character - SHIFT_KEY);
                    }
                    processedLine.append(processedChar);
                }
                writer.write(processedLine.toString());
                writer.newLine(); 
            }

            System.out.println("\nOperation completed successfully!");
            System.out.println("Output saved to: " + outputPath);

        } catch (IOException e) {
            System.err.println("\nAn error occurred during file processing.");
            System.err.println("Error: " + e.getMessage());
            System.err.println("Please check if the input file path is correct.");
        }
    }
  
    private static String getOutputFileName(String originalPath, String suffix) 
    {
        int dotIndex = originalPath.lastIndexOf('.');
        if (dotIndex == -1) {
     
            return originalPath + suffix;
        }
         else 
         {
         
            return originalPath.substring(0, dotIndex) + suffix + originalPath.substring(dotIndex);
        }
    }
}

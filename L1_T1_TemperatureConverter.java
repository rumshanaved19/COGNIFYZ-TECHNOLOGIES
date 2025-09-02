package COGNIFYZ_TECHNOLOGIES;
import java.util.*;

public class L1_T1_TemperatureConverter
{

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius)
     {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) 
    {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) 
    {
    
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Temperature Converter ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = 0;
        try 
        {
            choice = sc.nextInt();
        } catch (InputMismatchException e)
         {
            System.out.println("Invalid input. Please enter a number.");
            sc.close();
            return; 
        }

        if (choice == 1)
         {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = sc.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%.2f°C is equal to %.2f°F\n", celsius, fahrenheit);

        }
         else if (choice == 2)
         {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = sc.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.printf("%.2f°F is equal to %.2f°C\n", fahrenheit, celsius);

        } else 
        {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

       
        sc.close();
    }
}
package COGNIFYZ_TECHNOLOGIES;
import java.util.Scanner;

class BankAccount
 {
    private int balance;

    public BankAccount(int initialBalance) 
    {
        this.balance = initialBalance;
    }
    public synchronized void withdraw(String user, int amount) 
    {
        System.out.println(user + " is trying to withdraw ₹" + amount);

        if (balance >= amount) {
            System.out.println(user + " is allowed to withdraw.");
            try {
                Thread.sleep(1000); 
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(user + " completed withdrawal. Remaining balance: ₹" + balance);
        } 
        else 
        {
            System.out.println("Insufficient balance for " + user + ". Available: ₹" + balance);
        }
    }

    public int getBalance()
     {
        return balance;
    }
}

class UserThread extends Thread
{
    private BankAccount account;
    private int amount;
    private String userName;

    public UserThread(BankAccount account, int amount, String userName)
     {
        this.account = account;
        this.amount = amount;
        this.userName = userName;
    }

    public void run() 
    {
        account.withdraw(userName, amount);
    }
}

public class UserBasedBankSimulation
 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial bank balance: ₹");
        int initialBalance = scanner.nextInt();
        scanner.nextLine(); 

        BankAccount account = new BankAccount(initialBalance);
        System.out.print("Enter number of users: ");
        int userCount = scanner.nextInt();
        scanner.nextLine(); 

        
        UserThread[] users = new UserThread[userCount];

        for (int i = 0; i < userCount; i++)
         {
            System.out.println("\nUser " + (i + 1) + " details:");
            System.out.print("Enter user name: ");
            String name = scanner.nextLine();
            System.out.print("Enter withdrawal amount for " + name + ": ₹");
            int amount = scanner.nextInt();
            scanner.nextLine(); 

            users[i] = new UserThread(account, amount, name);
        }

       
        for (UserThread user : users)
         {
            user.start();
        }

     
        for (UserThread user : users) {
            try {
                user.join();
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n✅ All transactions complete. Final balance: ₹" + account.getBalance());
        scanner.close();
    }
}

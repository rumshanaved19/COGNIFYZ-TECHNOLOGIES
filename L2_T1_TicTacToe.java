package COGNIFYZ_TECHNOLOGIES;
import java.util.Scanner;

public class L2_T1_TicTacToe
 {
    private static char[][] board = new char[3][3];

    private static char currentPlayer;
    public static void main(String[] args)
     {
        Scanner scanner = new Scanner(System.in);
        String playAgain;
        do
         {
           
            initializeBoard();
            currentPlayer = 'X'; 
            boolean gameIsRunning = true;

            System.out.println("--- Welcome to Tic-Tac-Toe! ---");
            System.out.println("Player X starts. Enter a number (1-9) to make your move.");
            while (gameIsRunning)
             {
                printBoard();
                getPlayerMove();
                if (checkForWin())
                 {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins! Congratulations!");
                    gameIsRunning = false; 
                } 
                else if (isBoardFull()) 
                {
                    printBoard();
                    System.out.println("It's a draw! The game is over.");
                    gameIsRunning = false; 
                } 
                else 
                {
                    switchPlayer();
                }
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } 
        while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void initializeBoard()
     {
        char cellNumber = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cellNumber++;
            }
        }
    }

    private static void printBoard() 
    {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) 
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    private static void getPlayerMove() 
    {
        Scanner scanner = new Scanner(System.in);
        int moveInput;
        boolean isValidMove = false;

        while (!isValidMove) 
        {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            
            if (scanner.hasNextInt()) 
            {
                moveInput = scanner.nextInt();
                if (moveInput >= 1 && moveInput <= 9) 
                {
                    int row = (moveInput - 1) / 3;
                    int col = (moveInput - 1) % 3;
                   
                    if (board[row][col] != 'X' && board[row][col] != 'O')
                     {
                        board[row][col] = currentPlayer;
                        isValidMove = true;
                    }
                     else
                      {
                        System.out.println("This spot is already taken! Please try again.");
                    }
                } 
                else 
                {
                    System.out.println("Invalid move. Please enter a number between 1 and 9.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }

    private static void switchPlayer()
     {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkForWin()
     {
       
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
       
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }
      
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++)
             {
              
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}

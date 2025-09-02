package COGNIFYZ_TECHNOLOGIES;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose mode: [1] Server  [2] Client");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        if (choice == 1) {
            runAsServer();
        } else if (choice == 2) {
            runAsClient();
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    
    private static void runAsServer() {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.println("Client: " + clientMsg);

                System.out.print("You: ");
                serverMsg = console.readLine();
                out.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("You ended the chat.");
                    break;
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Client logic
    private static void runAsClient() {
        String serverAddress = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String userMsg, serverReply;

            while (true) {
                System.out.print("You: ");
                userMsg = console.readLine();
                out.println(userMsg);

                if (userMsg.equalsIgnoreCase("exit")) {
                    System.out.println("You ended the chat.");
                    break;
                }

                serverReply = in.readLine();
                if (serverReply == null || serverReply.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverReply);
            }

        } catch (IOException e) {
            System.out.println("Unable to connect to server.");
        }
    }
}

import java.util.Scanner;

public class GreetingProgram {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their name
        System.out.print("Please enter your name: ");

        // Read the user's input as a string
        String name = scanner.nextLine();

        // Close the Scanner to free up resources (optional)
        scanner.close();

        // Display the greeting
        System.out.println("Hello, " + name + "!");
    }
}

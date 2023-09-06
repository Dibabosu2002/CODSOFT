import java.util.Random;
import java.util.Scanner;
public class task1 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowest = 1;
        int highest = 100;
        int actualNum = random.nextInt(highest - lowest + 1) + lowest;
        int attempts = 0;
        System.out.println("Welcome to the Number Guessing game!");
        System.out.println("System is thinking of a number between " + lowest + " and " + highest);
        boolean playAgain = true;
        while (playAgain) {
            attempts = 0; // Reset the attempts for each new game
            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess < actualNum) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > actualNum) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + actualNum + " in " + attempts + " attempts.");
                    break;
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            } else {
                actualNum = random.nextInt(highest - lowest + 1) + lowest; // Generate a new secret number
                System.out.println("I'm thinking of a new number between " + lowest + " and " + highest);
            }
        }
        System.out.println("You've lost. Game over. Try again for the next time!");
        scanner.close();
    }
}
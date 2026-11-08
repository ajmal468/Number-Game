
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 0;
        int wins = 0;
        int maxAttempts = 7;

        String playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int number = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            boolean correct = false;

            rounds++;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have 7 attempts.");

            while (attempts < maxAttempts && !correct) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next();
                    continue;
                }

                guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    System.out.println("Correct Guess! You Win!");
                    System.out.println("Attempts: " + attempts);

                    wins++;
                    correct = true;

                } else if (guess > number) {
                    System.out.println("Too High!");

                } else {
                    System.out.println("Too Low!");
                }

                System.out.println("Attempts Left: "
                        + (maxAttempts - attempts));
            }

            if (!correct) {
                System.out.println("You Lost!");
                System.out.println("Correct Number was: " + number);
            }

            System.out.print("\nPlay Again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n===== FINAL SCORE =====");
        System.out.println("Total Rounds: " + rounds);
        System.out.println("Rounds Won: " + wins);
        System.out.println("Rounds Lost: " + (rounds - wins));

        System.out.println("Thanks for Playing!");

        sc.close();
    }
}

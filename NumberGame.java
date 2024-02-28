import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int st = 1;
        int ed = 100;
        int maxLife = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int tarNo = random.nextInt(ed - st + 1) + st;
            int guessed = 0;

            System.out.printf("Guess the number between %d and %d.%n", st, ed);

            while (guessed < maxLife) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                guessed++;

                if (userGuess == tarNo) {
                    System.out.printf("Congratulations! You guessed the correct number in %d guessed.%n", guessed);
                    score++;
                    break;
                } else if (userGuess < tarNo) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (guessed == maxLife) {
                System.out.printf("Sorry, you've run out of guessed. The correct number was: %d%n", tarNo);
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (sc.next().equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Your final score is: " + score);
    }
}

import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Number Guessing Game");
        int maxAttempts=10;
        int round=0;
        int win=0;

        do{
            int Randomnumber = rand.nextInt(100)+1;
            int attempts=0;

            System.out.println("This is round number " + (round+1));

            while (attempts<maxAttempts){
                System.out.print("Guess a number between 1 and 100: ");
                int guessNumber = sc.nextInt();
                attempts++;

                if (guessNumber<Randomnumber){
                    System.out.println("Too Low");
                } else if (guessNumber>Randomnumber) {
                    System.out.println("Too High");
                } else if (guessNumber==Randomnumber) {
                    System.out.println("Correct Answer");
                    win++;
                    break;
                }


                if (attempts==maxAttempts){
                    System.out.println("Out of Attempts");
                }

            }

            System.out.print("Do you want to play again? (yes/no): ");
            String input = sc.next().toLowerCase();

            if (input.equals("yes")){
                round+=1;
            }
            else {
                break;
            }
        }while (true);

        System.out.println("The total score is: "+win);
    }
}
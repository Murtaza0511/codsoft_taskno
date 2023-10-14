import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] subjects = {"OOP", "Discrete", "ProgrammingFunds","DS", "Calculus"};
        int totalMarks = 0;
        double averagePercentage;
        char grade;

        for (String iterator : subjects) {
            System.out.print("Enter marks obtained in " + iterator + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        averagePercentage=totalMarks;
        averagePercentage = (averagePercentage*100)/500;

        if (averagePercentage >= 80) {
            grade = 'A';
        } else if (averagePercentage >= 70  && averagePercentage <= 79) {
            grade = 'B';
        } else if (averagePercentage >= 60 && averagePercentage <= 69) {
            grade = 'C';
        } else if (averagePercentage >= 50&& averagePercentage <= 59) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}

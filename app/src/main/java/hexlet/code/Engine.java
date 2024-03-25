package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;

    public static void play(String[][] questionsAndCorrectAnswers, String task) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
        System.out.println(task);

        for (String[] questionAndCorrectAnswer : questionsAndCorrectAnswers) {
            System.out.println("Question: " + questionAndCorrectAnswer[0]);
            System.out.print("Your answer: ");

            String usersAnswer = scanner.next();

            if (usersAnswer.equalsIgnoreCase(questionAndCorrectAnswer[1])) {
                System.out.println("Correct!");

            } else {
                System.out.println("'" + usersAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionAndCorrectAnswer[1] + "'.");
                System.out.println("Let's try again, " + userName + "!");

                scanner.close();
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");

        scanner.close();
    }

    public static int getRoundsCount() {
        return ROUNDS_COUNT;
    }
}

package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;

    public static void play(String[][] questionsAndCorrectAnswers, String task) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
        System.out.println(task);

        boolean isCorrectAllAnswers = true;

        for (String[] questionAndCorrectAnswer : questionsAndCorrectAnswers) {
            String question = questionAndCorrectAnswer[0];
            String correctAnswer = questionAndCorrectAnswer[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            String usersAnswer = scanner.next();

            if (usersAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + usersAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");

                isCorrectAllAnswers = false;
                break;
            }
        }

        if (isCorrectAllAnswers) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }

        scanner.close();
    }

    public static int getRoundsCount() {
        return ROUNDS_COUNT;
    }
}

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

        boolean isCorrectAllAnswers = true;

        for (String[] questionAndCorrectAnswer : questionsAndCorrectAnswers) {
            System.out.println("Question: " + questionAndCorrectAnswer[0]);
            System.out.print("Your answer: ");

            String usersAnswer = scanner.next();

            isCorrectAllAnswers = usersAnswer.equalsIgnoreCase(questionAndCorrectAnswer[1]);
            System.out.println(isCorrectAllAnswers ? "Correct!" : "'" + usersAnswer
                    + "' is wrong answer ;(. Correct answer was '" + questionAndCorrectAnswer[1] + "'.");

            if (!isCorrectAllAnswers) {
                break;
            }
        }

        System.out.println((isCorrectAllAnswers ? "Congratulations, " : "Let's try again, ") + userName + "!");

        scanner.close();
    }

    public static int getRoundsCount() {
        return ROUNDS_COUNT;
    }
}

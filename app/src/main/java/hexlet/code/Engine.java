package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static String inputText() {
        Scanner scanner = App.getScanner();
        return scanner.next();
    }

    public static int inputNumber() {
        Scanner scanner = App.getScanner();

        int number = 0;
        boolean isNumber = false;

        int triesCount = 10;
        int tryCounter = 0;

        do {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                isNumber = true;
            } else {
                scanner.next();
                System.out.print("Please enter a number: ");
            }

            tryCounter++;
        } while (tryCounter < triesCount && !isNumber);

        return number;
    }

    public static String getAnswerOnQuestion(String question, boolean isIntAnswer) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");

        String answer;

        if (isIntAnswer) {
            int intAnswer = inputNumber();
            answer = Integer.toString(intAnswer);

        } else {
            answer = inputText();
        }

        return answer;
    }

    public static boolean checkAnswerAndOutputResult(String usersAnswer, String correctAnswer) {
        boolean isCorrectAnswer = usersAnswer.equalsIgnoreCase(correctAnswer);

        if (isCorrectAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + usersAnswer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.");
        }

        return isCorrectAnswer;
    }

    public static void outputGameResult(boolean isCorrectAllAnswers) {
        if (isCorrectAllAnswers) {
            System.out.println("Congratulations, " + App.getUserName() + "!");
        } else {
            System.out.println("Let's try again, " + App.getUserName() + "!");
        }
    }

    public static int random(int minValue, int maxValue) {
        return (int) (Math.round(Math.random() * (maxValue - minValue)) + minValue);
    }
}

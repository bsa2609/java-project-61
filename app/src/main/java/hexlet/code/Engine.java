package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

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

        final int triesCount = 10;
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

    public static char intToChar(int number) {
        return Integer.toString(number).charAt(0);
    }

    public static void play(int gameNumber, String task, boolean isIntAnswer) {
        System.out.println(task);

        final int roundsCount = App.getRoundscount();
        int roundCounter = 0;
        boolean isCorrectAllAnswers = true;

        do {
            String[] questionAndCorrectAnswer = generateQuestionAndCorrectAnswer(gameNumber);
            String question = questionAndCorrectAnswer[0];
            String correctAnswer = questionAndCorrectAnswer[1];

            String usersAnswer = getAnswerOnQuestion(question, isIntAnswer);

            boolean isCorrectAnswer = checkAnswerAndOutputResult(usersAnswer, correctAnswer);
            if (!isCorrectAnswer) {
                isCorrectAllAnswers = false;
            }

            roundCounter++;
        } while (roundCounter < roundsCount && isCorrectAllAnswers);

        outputGameResult(isCorrectAllAnswers);
    }

    public static String[] generateQuestionAndCorrectAnswer(int gameNumber) {
        String[] questionAndCorrectAnswer = new String[2];

        switch (intToChar(gameNumber)) {
            case '1':
                questionAndCorrectAnswer = Even.generateQuestionAndCorrectAnswer();
                break;
            case '2':
                questionAndCorrectAnswer = Calc.generateQuestionAndCorrectAnswer();
                break;
            case '3':
                questionAndCorrectAnswer = GCD.generateQuestionAndCorrectAnswer();
                break;
            case '4':
                questionAndCorrectAnswer = Progression.generateQuestionAndCorrectAnswer();
                break;
            case '5':
                questionAndCorrectAnswer = Prime.generateQuestionAndCorrectAnswer();
                break;
            default:
                // nothing
        }

        return questionAndCorrectAnswer;
    }
}

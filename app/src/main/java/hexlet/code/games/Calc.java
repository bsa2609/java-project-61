package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String TASK = "What is the result of the expression?";
    private static final char[] MATH_OPERATIONS = new char[]{'+', '-', '*'};
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int firstNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            char mathOperation = MATH_OPERATIONS[Utils.getRandomInt(1, MATH_OPERATIONS.length) - 1];

            questionsAndCorrectAnswers[roundCounter][0] = firstNumber + " " + mathOperation + " " + secondNumber;
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(
                    calculate(firstNumber, secondNumber, mathOperation));
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static int calculate(int firstNumber, int secondNumber, char mathOperation) {
        int result;

        switch (mathOperation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            default:
                throw new RuntimeException("There is no algorithm for processing the mathematical operation: "
                        + mathOperation);
        }

        return result;
    }
}

package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String TASK = "What is the result of the expression?";
    private static final char[] MATH_OPERATIONS = new char[]{'+', '-', '*'};
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_NUMBER_FOR_MULTIPLICATION = 10;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int mathOperationIndex = Utils.getRandomInt(0, MATH_OPERATIONS.length - 1);
            char mathOperation = MATH_OPERATIONS[mathOperationIndex];

            int firstNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Utils.getRandomInt(MIN_NUMBER,
                    mathOperation == '*' ? MAX_NUMBER_FOR_MULTIPLICATION : MAX_NUMBER);

            int correctAnswerNumber;


            switch (mathOperation) {
                case '+':
                    correctAnswerNumber = firstNumber + secondNumber;
                    break;
                case '-':
                    correctAnswerNumber = firstNumber - secondNumber;
                    break;
                case '*':
                    correctAnswerNumber = firstNumber * secondNumber;
                    break;
                default:
                    throw new RuntimeException("There is no algorithm for processing the mathematical operation: "
                            + mathOperation);
            }

            questionsAndCorrectAnswers[roundCounter][0] = firstNumber + " " + mathOperation + " " + secondNumber;
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(correctAnswerNumber);
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }
}

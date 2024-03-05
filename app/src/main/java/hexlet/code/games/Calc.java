package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String TASK = "What is the result of the expression?";
    private static final boolean IS_INT_ANSWER = true;
    private static final int MIN_MATH_OPERATION_NUMBER = 1;
    private static final int MAX_MATH_OPERATION_NUMBER = 3;
    private static final int MULTIPLICATION_OPERATION_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_NUMBER_FOR_MULTIPLICATION = 10;

    public static void play() {
        int roundsCount = App.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int mathOperationNumber = Utils.getRandomInt(MIN_MATH_OPERATION_NUMBER, MAX_MATH_OPERATION_NUMBER);
            int firstNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = generateSecondNumber(mathOperationNumber);

            char mathOperation;
            int correctAnswerNumber;

            switch (Integer.toString(mathOperationNumber)) {
                case "2":
                    mathOperation = '-';
                    correctAnswerNumber = firstNumber - secondNumber;
                    break;
                case "3":
                    mathOperation = '*';
                    correctAnswerNumber = firstNumber * secondNumber;
                    break;
                default:
                    mathOperation = '+';
                    correctAnswerNumber = firstNumber + secondNumber;
            }

            questionsAndCorrectAnswers[roundCounter][0] = firstNumber + " " + mathOperation + " " + secondNumber;
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(correctAnswerNumber);
        }

        Engine.play(questionsAndCorrectAnswers, TASK, IS_INT_ANSWER);
    }

    private static int generateSecondNumber(int mathOperationNumber) {
        final int maximumNumberDependingOnMathOperation = (
                mathOperationNumber == MULTIPLICATION_OPERATION_NUMBER
                ? MAX_NUMBER_FOR_MULTIPLICATION : MAX_NUMBER);
        return Utils.getRandomInt(MIN_NUMBER, maximumNumberDependingOnMathOperation);
    }
}

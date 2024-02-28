package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void play() {
        Engine.play(2,
                "What is the result of the expression?",
                true);
    }

    public static String[] generateQuestionAndCorrectAnswer() {
        int mathOperationNumber = getMathOperationNumber();
        int firstNumber = getFirstNumber();
        int secondNumber = getSecondNumber(mathOperationNumber);

        char mathOperation;
        int correctAnswerNumber;

        switch (Engine.intToChar(mathOperationNumber)) {
            case '2':
                mathOperation = '-';
                correctAnswerNumber = firstNumber - secondNumber;
                break;
            case '3':
                mathOperation = '*';
                correctAnswerNumber = firstNumber * secondNumber;
                break;
            default:
                mathOperation = '+';
                correctAnswerNumber = firstNumber + secondNumber;
        }

        String question = firstNumber + " " + mathOperation + " " + secondNumber;
        String correctAnswer = Integer.toString(correctAnswerNumber);

        return new String[]{question, correctAnswer};
    }

    private static int getMathOperationNumber() {
        final int minMathOperationNumber = 1;
        final int maxMathOperationNumber = 3;
        return Engine.random(minMathOperationNumber, maxMathOperationNumber);
    }

    private static int getFirstNumber() {
        final int minNumber = 1;
        final int maxNumber = 100;
        return Engine.random(minNumber, maxNumber);
    }

    private static int getSecondNumber(int mathOperationNumber) {
        final int minNumber = 1;
        final int maxNumber = (mathOperationNumber == 3 ? 10 : 100);
        return Engine.random(minNumber, maxNumber);
    }
}

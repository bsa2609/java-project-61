package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String TASK = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int firstNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int gcd = calculateGCD(firstNumber, secondNumber);

            questionsAndCorrectAnswers[roundCounter][0] = firstNumber + " " + secondNumber;
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(gcd);
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static int calculateGCD(int firstNumber, int secondNumber) {
        int gcd = 1;

        if (firstNumber == secondNumber) {
            gcd = firstNumber;
        } else if (firstNumber % secondNumber == 0) {
            gcd = secondNumber;
        } else if (secondNumber % firstNumber == 0) {
            gcd = firstNumber;
        } else if (firstNumber > 1 && secondNumber > 1) {
            int minNumber = Math.min(firstNumber, secondNumber);
            int maxNumber = Math.max(firstNumber, secondNumber);
            int halfMaxNumber = maxNumber / 2;
            int maxPossibleGCD = Math.min(minNumber, halfMaxNumber);

            for (int possibleGCD = 1; possibleGCD <= maxPossibleGCD; possibleGCD++) {
                if (firstNumber % possibleGCD == 0 && secondNumber % possibleGCD == 0) {
                    gcd = possibleGCD;
                }
            }
        }

        return gcd;
    }
}

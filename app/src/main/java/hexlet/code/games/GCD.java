package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String TASK = "Find the greatest common divisor of given numbers.";
    private static final boolean IS_INT_ANSWER = true;
    private static final int MIN_MULTIPLIER = 2;
    private static final int MAX_MULTIPLIER = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;

    public static void play() {
        int roundsCount = App.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int multiplier = Utils.getRandomInt(MIN_MULTIPLIER, MAX_MULTIPLIER);
            int firstNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER) * multiplier;
            int secondNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER) * multiplier;

            int gcd = calculateGCD(firstNumber, secondNumber);

            questionsAndCorrectAnswers[roundCounter][0] = firstNumber + " " + secondNumber;
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(gcd);
        }

        Engine.play(questionsAndCorrectAnswers, TASK, IS_INT_ANSWER);
    }

    private static int calculateGCD(int firstNumber, int secondNumber) {
        int gcd = 1;

        if (firstNumber == secondNumber) {
            gcd = firstNumber;
        } else {
            int maxPossibleGCD;

            if (firstNumber < secondNumber) {
                int halfMaxNumber = secondNumber / 2;
                maxPossibleGCD = Math.min(firstNumber, halfMaxNumber);
            } else {
                int halfMaxNumber = firstNumber / 2;
                maxPossibleGCD = Math.min(secondNumber, halfMaxNumber);
            }

            for (int possibleGCD = 1; possibleGCD <= maxPossibleGCD; possibleGCD++) {
                if (firstNumber % possibleGCD == 0 && secondNumber % possibleGCD == 0) {
                    gcd = possibleGCD;
                }
            }
        }

        return gcd;
    }
}

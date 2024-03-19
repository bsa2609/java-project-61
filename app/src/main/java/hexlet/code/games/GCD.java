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

            questionsAndCorrectAnswers[roundCounter][0] = firstNumber + " " + secondNumber;
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(gcd(firstNumber, secondNumber));
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static int gcd(int firstNumber, int secondNumber) {
        int minNumber = Math.min(firstNumber, secondNumber);
        int maxNumber = Math.max(firstNumber, secondNumber);

        return (minNumber == 0) ? maxNumber : gcd(minNumber, maxNumber % minNumber);
    }
}

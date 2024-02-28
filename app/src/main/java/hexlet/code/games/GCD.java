package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final int GAMENUMBER = 3;

    public static void play() {
        Engine.play(GAMENUMBER,
                "Find the greatest common divisor of given numbers.",
                true);
    }

    public static String[] generateQuestionAndCorrectAnswer() {
        int multiplier = getMultiplier();
        int firstNumber = getNumber(multiplier);
        int secondNumber = getNumber(multiplier);

        int gcd = calculateGCD(firstNumber, secondNumber);

        String question = firstNumber + " " + secondNumber;
        String correctAnswer = Integer.toString(gcd);

        return new String[]{question, correctAnswer};
    }

    private static int getMultiplier() {
        final int minMultiplier = 2;
        final int maxMultiplier = 10;
        return Engine.random(minMultiplier, maxMultiplier);
    }

    private static int getNumber(int multiplier) {
        final int minNumber = 1;
        final int maxNumber = 10;
        return Engine.random(minNumber, maxNumber) * multiplier;
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

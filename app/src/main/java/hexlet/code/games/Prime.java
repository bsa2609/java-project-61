package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int number = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);

            questionsAndCorrectAnswers[roundCounter][0] = Integer.toString(number);
            questionsAndCorrectAnswers[roundCounter][1] = isPrimeNumber(number) ? "yes" : "no";
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        } else if (number <= 3) {
            return true;
        }

        int maxDivider = number / 2;

        for (int divider = 2; divider <= maxDivider; divider++) {
            if (number % divider == 0) {
                return false;
            }
        }

        return true;
    }
}

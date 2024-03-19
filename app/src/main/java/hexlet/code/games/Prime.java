package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] primeQuestionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int number = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);

            primeQuestionsAndCorrectAnswers[roundCounter][0] = Integer.toString(number);
            primeQuestionsAndCorrectAnswers[roundCounter][1] = isPrimeNumber(number) ? "yes" : "no";
        }

        Engine.play(primeQuestionsAndCorrectAnswers, TASK);
    }

    private static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int divider = 2; divider <= Math.sqrt(number); divider++) {
            if (number % divider == 0) {
                return false;
            }
        }

        return true;
    }
}

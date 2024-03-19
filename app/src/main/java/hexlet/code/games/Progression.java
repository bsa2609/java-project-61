package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String TASK = "What number is missing in the progression?";
    private static final int MIN_FIRST_NUMBER = 1;
    private static final int MAX_FIRST_NUMBER = 10;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int MIN_NUMBERS_COUNT = 5;
    private static final int MAX_NUMBERS_COUNT = 15;
    private static final int MIN_MISSING_NUMBER = 2;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            String[] progression = createProgression(
                    Utils.getRandomInt(MIN_FIRST_NUMBER, MAX_FIRST_NUMBER),
                    Utils.getRandomInt(MIN_STEP, MAX_STEP),
                    Utils.getRandomInt(MIN_NUMBERS_COUNT, MAX_NUMBERS_COUNT));

            int indexOfMissingNumber = Utils.getRandomInt(MIN_MISSING_NUMBER, progression.length) - 1;
            String missingNumber = progression[indexOfMissingNumber];
            progression[indexOfMissingNumber] = "..";

            questionsAndCorrectAnswers[roundCounter][0] = String.join(" ", progression);
            questionsAndCorrectAnswers[roundCounter][1] = missingNumber;
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static String[] createProgression(int currentNumber, int step, int numbersCount) {
        String[] progression = new String[numbersCount];

        for (int indexOfNumber = 0; indexOfNumber < numbersCount; indexOfNumber++) {
            progression[indexOfNumber] = Integer.toString(currentNumber);
            currentNumber += step;
        }

        return progression;
    }
}

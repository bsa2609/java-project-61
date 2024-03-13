package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.StringJoiner;

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
            int firstNumber = Utils.getRandomInt(MIN_FIRST_NUMBER, MAX_FIRST_NUMBER);
            int step = Utils.getRandomInt(MIN_STEP, MAX_STEP);
            int numbersCount = Utils.getRandomInt(MIN_NUMBERS_COUNT, MAX_NUMBERS_COUNT);

            int[] progression = createProgression(firstNumber, step, numbersCount);

            int indexOfMissingNumber = Utils.getRandomInt(MIN_MISSING_NUMBER, progression.length) - 1;

            questionsAndCorrectAnswers[roundCounter][0] = createProgressionViewWithMissingNumber(
                    progression, indexOfMissingNumber);
            questionsAndCorrectAnswers[roundCounter][1] = Integer.toString(progression[indexOfMissingNumber]);
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static int[] createProgression(int firstNumber, int step, int numbersCount) {
        int[] progression = new int[numbersCount];

        progression[0] = firstNumber;

        for (int indexOfNumber = 1; indexOfNumber < numbersCount; indexOfNumber++) {
            progression[indexOfNumber] = progression[indexOfNumber - 1] + step;
        }

        return progression;
    }

    private static String createProgressionViewWithMissingNumber(int[] progression, int indexOfMissingNumber) {
        StringJoiner progressionViewJoiner = new StringJoiner(" ");

        for (int indexOfNumber = 0; indexOfNumber < progression.length; indexOfNumber++) {
            String elementOfProgressionView = (indexOfNumber == indexOfMissingNumber)
                    ? ".." : Integer.toString(progression[indexOfNumber]);
            progressionViewJoiner.add(elementOfProgressionView);
        }

        return progressionViewJoiner.toString();
    }
}

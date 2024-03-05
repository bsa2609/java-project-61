package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.StringJoiner;

public class Progression {
    private static final String TASK = "What number is missing in the progression?";
    private static final boolean IS_INT_ANSWER = true;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int MIN_NUMBERS_COUNT = 5;
    private static final int MAX_NUMBERS_COUNT = 15;
    private static final int MIN_MISSING_NUMBER = 2;

    public static void play() {
        int roundsCount = App.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int currentNumber = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int step = Utils.getRandomInt(MIN_STEP, MAX_STEP);
            int numbersCount = Utils.getRandomInt(MIN_NUMBERS_COUNT, MAX_NUMBERS_COUNT);
            int missingNumber = Utils.getRandomInt(MIN_MISSING_NUMBER, numbersCount);

            String missingElement = "";

            StringJoiner questionJoiner = new StringJoiner(" ");

            for (int numberCounter = 1; numberCounter <= numbersCount; numberCounter++) {
                if (numberCounter == missingNumber) {
                    missingElement = Integer.toString(currentNumber);
                    questionJoiner.add("..");
                } else {
                    questionJoiner.add(Integer.toString(currentNumber));
                }

                currentNumber += step;
            }

            questionsAndCorrectAnswers[roundCounter][0] = questionJoiner.toString();
            questionsAndCorrectAnswers[roundCounter][1] = missingElement;
        }

        Engine.play(questionsAndCorrectAnswers, TASK, IS_INT_ANSWER);
    }
}

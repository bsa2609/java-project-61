package hexlet.code.games;

import hexlet.code.Engine;

import java.util.StringJoiner;

public class Progression {
    public static void play() {
        Engine.play(4,
                "What number is missing in the progression?",
                true);
    }

    public static String[] generateQuestionAndCorrectAnswer() {
        int currentNumber = getFirstNumber();
        int step = getStep();
        int numbersCount = getNumbersCount();
        int missingNumber = getMissingNumber(numbersCount);

        String missingElement = "";

        StringJoiner questionJoiner = new StringJoiner(" ");

        for (int numberCounter = 1; numberCounter <= numbersCount; numberCounter++) {
            String progressionElement = Integer.toString(currentNumber);

            if (numberCounter == missingNumber) {
                missingElement = progressionElement;
                progressionElement = "..";
            } else {
                progressionElement = Integer.toString(currentNumber);
            }

            questionJoiner.add(progressionElement);

            currentNumber += step;
        }

        String question = questionJoiner.toString();
        String correctAnswer = missingElement;

        return new String[]{question, correctAnswer};
    }

    private static int getFirstNumber() {
        final int minNumber = 1;
        final int maxNumber = 10;
        return Engine.random(minNumber, maxNumber);
    }

    private static int getStep() {
        final int minStep = 1;
        final int maxStep = 10;
        return Engine.random(minStep, maxStep);
    }

    private static int getNumbersCount() {
        final int minNumbersCount = 5;
        final int maxNumbersCount = 15;
        return Engine.random(minNumbersCount, maxNumbersCount);
    }

    private static int getMissingNumber(int maxMissingNumber) {
        final int minMissingNumber = 2;
        return Engine.random(minMissingNumber, maxMissingNumber);
    }
}

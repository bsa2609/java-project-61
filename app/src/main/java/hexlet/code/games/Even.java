package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] evenQuestionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int number = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);

            evenQuestionsAndCorrectAnswers[roundCounter][0] = Integer.toString(number);
            evenQuestionsAndCorrectAnswers[roundCounter][1] = isEvenNumber(number) ? "yes" : "no";
        }

        Engine.play(evenQuestionsAndCorrectAnswers, TASK);
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}

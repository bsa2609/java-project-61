package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final boolean IS_INT_ANSWER = false;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        int roundsCount = App.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int number = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER);
            boolean isEvenNumber = (number % 2 == 0);

            questionsAndCorrectAnswers[roundCounter][0] = Integer.toString(number);
            questionsAndCorrectAnswers[roundCounter][1] = (isEvenNumber ? "yes" : "no");
        }

        Engine.play(questionsAndCorrectAnswers, TASK, IS_INT_ANSWER);
    }
}

package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final int GAMENUMBER = 1;

    public static void play() {
        Engine.play(GAMENUMBER,
                "Answer 'yes' if the number is even, otherwise answer 'no'.",
                false);
    }

    public static String[] generateQuestionAndCorrectAnswer() {
        int number = getNumber();
        boolean isEvenNumber = (number % 2 == 0);

        String question = Integer.toString(number);
        String correctAnswer = (isEvenNumber ? "yes" : "no");

        return new String[]{question, correctAnswer};
    }

    private static int getNumber() {
        final int minNumber = 1;
        final int maxNumber = 100;
        return Engine.random(minNumber, maxNumber);
    }
}

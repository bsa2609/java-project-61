package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

import java.util.StringJoiner;

public class Progression {
    private static String task;
    private static boolean isIntAnswer;
    private static int roundsCount;

    public static void play() {
        initialize();

        System.out.println(task);

        int roundCounter = 0;
        boolean isCorrectAllAnswers = true;

        do {
            String[] questionAndCorrectAnswer = generateQuestionAndCorrectAnswer();
            String question = questionAndCorrectAnswer[0];
            String correctAnswer = questionAndCorrectAnswer[1];

            String usersAnswer = Engine.getAnswerOnQuestion(question, isIntAnswer);

            boolean isCorrectAnswer = Engine.checkAnswerAndOutputResult(usersAnswer, correctAnswer);
            if (!isCorrectAnswer) {
                isCorrectAllAnswers = false;
            }

            roundCounter++;
        } while (roundCounter < roundsCount && isCorrectAllAnswers);

        Engine.outputGameResult(isCorrectAllAnswers);
    }

    private static void initialize() {
        task = "What number is missing in the progression?";
        roundsCount = App.getRoundsCount();
        isIntAnswer = true;
    }

    private static String[] generateQuestionAndCorrectAnswer() {
        int firstNumber = Engine.random(1, 10);
        int step = Engine.random(1, 10);
        int numbersCount = Engine.random(5, 15);
        int missingNumber = Engine.random(2, numbersCount);
        String missingElement = "";

        StringJoiner questionJoiner = new StringJoiner(" ");

        int currentNumber = firstNumber;
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
}

package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

public class Even {
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
        task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        roundsCount = App.getRoundsCount();
        isIntAnswer = false;
    }

    private static String[] generateQuestionAndCorrectAnswer() {
        int number = Engine.random(1, 100);
        boolean isEvenNumber = (number % 2 == 0);

        String question = Integer.toString(number);
        String correctAnswer = (isEvenNumber ? "yes" : "no");

        return new String[]{question, correctAnswer};
    }
}

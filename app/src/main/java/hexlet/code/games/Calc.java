package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

public class Calc {
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
        task = "What is the result of the expression?";
        roundsCount = App.getRoundsCount();
        isIntAnswer = true;
    }

    private static String[] generateQuestionAndCorrectAnswer() {
        int mathOperationNumber = Engine.random(1, 3);
        int maxSecondNumber = (mathOperationNumber == 3 ? 10 : 100);
        int firstNumber = Engine.random(1, 100);
        int secondNumber = Engine.random(1, maxSecondNumber);

        char mathOperation;
        int correctAnswerNumber;

        switch (mathOperationNumber) {
            case 2:
                mathOperation = '-';
                correctAnswerNumber = firstNumber - secondNumber;
                break;
            case 3:
                mathOperation = '*';
                correctAnswerNumber = firstNumber * secondNumber;
                break;
            default:
                mathOperation = '+';
                correctAnswerNumber = firstNumber + secondNumber;
        }

        String question = firstNumber + " " + mathOperation + " " + secondNumber;
        String correctAnswer = Integer.toString(correctAnswerNumber);

        return new String[]{question, correctAnswer};
    }
}

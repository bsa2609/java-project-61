package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

public class GCD {
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
        task = "Find the greatest common divisor of given numbers.";
        roundsCount = App.getRoundsCount();
        isIntAnswer = true;
    }

    private static String[] generateQuestionAndCorrectAnswer() {
        int multiplier = Engine.random(2, 10);
        int firstNumber = Engine.random(1, 10) * multiplier;
        int secondNumber = Engine.random(1, 10) * multiplier;

        int gcd = calculateGCD(firstNumber, secondNumber);

        String question = firstNumber + " " + secondNumber;
        String correctAnswer = Integer.toString(gcd);

        return new String[]{question, correctAnswer};
    }

    private static int calculateGCD(int firstNumber, int secondNumber) {
        int gcd = 1;

        if (firstNumber == secondNumber) {
            gcd = firstNumber;
        } else {
            int minNumber = Math.min(firstNumber, secondNumber);
            int maxNumber = Math.max(firstNumber, secondNumber);
            int halfMaxNumber = maxNumber / 2;
            int maximumPossibleGCD = Math.min(minNumber, halfMaxNumber);

            for (int possibleGCD = 1; possibleGCD <= maximumPossibleGCD; possibleGCD++) {
                if (firstNumber % possibleGCD == 0 && secondNumber % possibleGCD == 0) {
                    gcd = possibleGCD;
                }
            }
        }

        return gcd;
    }
}

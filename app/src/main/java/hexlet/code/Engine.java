package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static Scanner scanner;
    private static String userName;

    public static int greetingsAndInputGameNumber(String[] games) {
        outputListOfActions(games);

        setScanner();

        int actionNumber = inputActionNumber();
        int gameNumber = 0;

        if (actionNumber >= 1 && actionNumber <= (games.length + 1)) {
            greetings();
            gameNumber = actionNumber - 1;
        }

        if (gameNumber < 1 || gameNumber > games.length) {
            closeScanner();
        }

        return gameNumber;
    }

    private static void outputListOfActions(String[] games) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int gameCounter = 0; gameCounter < games.length; gameCounter++) {
            int itemNumber = gameCounter + 2;
            System.out.println(itemNumber + " - " + games[gameCounter]);
        }

        System.out.println("0 - Exit");
    }

    private static void setScanner() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
    }

    private static void closeScanner() {
        scanner.close();
    }

    private static void greetings() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        userName = inputText();

        System.out.println("Hello, " + userName + "!");
    }

    private static int inputActionNumber() {
        System.out.print("Your choice: ");
        return inputNumber();
    }

    public static String inputText() {
        return scanner.next();
    }

    public static int inputNumber() {
        int number = 0;
        boolean isNumber = false;

        final int triesCount = 10;
        int tryCounter = 0;

        do {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                isNumber = true;
            } else {
                scanner.next();
                System.out.print("Please enter a number: ");
            }

            tryCounter++;
        } while (tryCounter < triesCount && !isNumber);

        return number;
    }

    public static String getAnswerOnQuestion(String question, boolean isIntAnswer) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");

        String answer;

        if (isIntAnswer) {
            int intAnswer = inputNumber();
            answer = Integer.toString(intAnswer);

        } else {
            answer = inputText();
        }

        return answer;
    }

    public static boolean checkAnswerAndOutputResult(String usersAnswer, String correctAnswer) {
        boolean isCorrectAnswer = usersAnswer.equalsIgnoreCase(correctAnswer);

        if (isCorrectAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + usersAnswer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.");
        }

        return isCorrectAnswer;
    }

    public static void outputGameResult(boolean isCorrectAllAnswers) {
        if (isCorrectAllAnswers) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    public static void play(String[][] questionsAndCorrectAnswers, String task, boolean isIntAnswer) {
        System.out.println(task);

        int roundsCount = questionsAndCorrectAnswers.length;
        int roundCounter = 0;
        boolean isCorrectAllAnswers = true;

        do {
            String question = questionsAndCorrectAnswers[roundCounter][0];
            String correctAnswer = questionsAndCorrectAnswers[roundCounter][1];

            String usersAnswer = getAnswerOnQuestion(question, isIntAnswer);

            boolean isCorrectAnswer = checkAnswerAndOutputResult(usersAnswer, correctAnswer);
            if (!isCorrectAnswer) {
                isCorrectAllAnswers = false;
            }

            roundCounter++;
        } while (roundCounter < roundsCount && isCorrectAllAnswers);

        outputGameResult(isCorrectAllAnswers);

        closeScanner();
    }
}

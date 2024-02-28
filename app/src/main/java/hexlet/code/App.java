package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static Scanner scanner;
    private static String userName;
    private static int roundsCount;
    private static String[] games;

    public static void main(String[] args) {
        initialize();

        outputListOfGames();

        setScanner();

        int gameNumber = inputGameNumber();

        if (gameNumber >= 0 && gameNumber <= games.length) {
            outputGreetingAndInputUserName();
        }

        switch (gameNumber) {
            case 1:
                Even.play();
                break;
            case 2:
                Calc.play();
                break;
            case 3:
                GCD.play();
                break;
            case 4:
                Progression.play();
                break;
            case 5:
                Prime.play();
                break;
            default:
                // nothing
        }

        closeScanner();
    }

    private static void initialize() {
        games = new String[]{"Even", "Calc", "GCD", "Progression", "Prime"};
        roundsCount = 3;
    }

    private static void outputListOfGames() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int gameCounter = 0; gameCounter < games.length; gameCounter++) {
            System.out.println(Integer.toString(gameCounter + 2) + " - " + games[gameCounter]);
        }

        System.out.println("0 - Exit");
    }

    private static void setScanner() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
    }

    public static Scanner getScanner() {
        return scanner;
    }

    private static void closeScanner() {
        scanner.close();
    }

    private static int inputGameNumber() {
        System.out.print("Your choice: ");
        int itemNumber = Engine.inputNumber();
        return itemNumber - 1;
    }

    private static void outputGreetingAndInputUserName() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        setUserName();

        System.out.println("Hello, " + userName + "!");
    }

    private static void setUserName() {
        userName = Engine.inputText();
    }

    public static String getUserName() {
        return userName;
    }

    public static int getRoundsCount() {
        return roundsCount;
    }
}

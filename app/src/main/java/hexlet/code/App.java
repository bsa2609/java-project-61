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
    private static final int ROUNDSCOUNT = 3;
    private static final String[] GAMES = new String[]{"Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {
        outputListOfActions();

        setScanner();

        int actionNumber = inputActionNumber();

        if (actionNumber >= 1 && actionNumber <= (GAMES.length + 1)) {
            outputGreetingAndInputUserName();
            playSelectedGame(actionNumber - 1);
        }

        closeScanner();
    }

    private static void outputListOfActions() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        for (int gameCounter = 0; gameCounter < GAMES.length; gameCounter++) {
            int itemNumber = gameCounter + 2;
            System.out.println(itemNumber + " - " + GAMES[gameCounter]);
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

    private static int inputActionNumber() {
        System.out.print("Your choice: ");
        return Engine.inputNumber();
    }

    private static void outputGreetingAndInputUserName() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        setUserName();

        System.out.println("Hello, " + userName + "!");
    }

    public static void playSelectedGame(int gameNumber) {
        switch (Engine.intToChar(gameNumber)) {
            case '1':
                Even.play();
                break;
            case '2':
                Calc.play();
                break;
            case '3':
                GCD.play();
                break;
            case '4':
                Progression.play();
                break;
            case '5':
                Prime.play();
                break;
            default:
                // nothing
        }
    }

    private static void setUserName() {
        userName = Engine.inputText();
    }

    public static String getUserName() {
        return userName;
    }

    public static int getRoundscount() {
        return ROUNDSCOUNT;
    }
}

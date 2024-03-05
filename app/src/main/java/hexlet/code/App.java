package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    private static final int ROUNDS_COUNT = 3;
    private static final String[] GAMES = new String[]{"Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {
        int gameNumber = Engine.greetingsAndInputGameNumber(GAMES);

        switch (Integer.toString(gameNumber)) {
            case "1":
                Even.play();
                break;
            case "2":
                Calc.play();
                break;
            case "3":
                GCD.play();
                break;
            case "4":
                Progression.play();
                break;
            case "5":
                Prime.play();
                break;
            default:
                // The game number is not specified or is specified incorrectly.
                // No actions are performed.
        }
    }

    public static int getRoundsCount() {
        return ROUNDS_COUNT;
    }
}

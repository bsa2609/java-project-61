package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greetings() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        scanner.close();
    }
}

package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Prime {
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_PRIME = 2;
    private static final int PRIMES_COUNT = 200;

    public static void play() {
        int roundsCount = Engine.getRoundsCount();

        String[][] questionsAndCorrectAnswers = new String[roundsCount][2];

        int[] primes = createPrimesArray();

        for (int roundCounter = 0; roundCounter < roundsCount; roundCounter++) {
            int number = Utils.getRandomInt(MIN_PRIME, primes[primes.length - 1]);
            boolean isPrimeNumber = (Arrays.binarySearch(primes, number) >= 0);

            questionsAndCorrectAnswers[roundCounter][0] = Integer.toString(number);
            questionsAndCorrectAnswers[roundCounter][1] = (isPrimeNumber ? "yes" : "no");
        }

        Engine.play(questionsAndCorrectAnswers, TASK);
    }

    private static int[] createPrimesArray() {
        int[] primes = new int[PRIMES_COUNT];

        primes[0] = MIN_PRIME;

        for (int primeCounter = 1; primeCounter < PRIMES_COUNT; primeCounter++) {
            primes[primeCounter] = calculateFollowingPrime(primes[primeCounter - 1]);
        }

        return primes;
    }

    private static int calculateFollowingPrime(int previousPrime) {
        int number = previousPrime;
        boolean isNumberPrime;

        do {
            number++;
            isNumberPrime = true;
            int maxDivider = number / 2;

            for (int divider = 2; divider <= maxDivider; divider++) {
                if (number % divider == 0) {
                    isNumberPrime = false;
                    break;
                }
            }
        } while (!isNumberPrime);

        return number;
    }
}

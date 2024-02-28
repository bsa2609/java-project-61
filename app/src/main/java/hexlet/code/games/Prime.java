package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Prime {
    public static void play() {
        Engine.play(5,
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                false);
    }

    public static String[] generateQuestionAndCorrectAnswer() {
        final int primesCount = 200;
        int[] primes = getPrimes(primesCount);

        int number = getNumber(primes[primes.length - 1]);
        boolean isPrimeNumber = (Arrays.binarySearch(primes, number) >= 0);

        String question = Integer.toString(number);
        String correctAnswer = (isPrimeNumber ? "yes" : "no");

        return new String[]{question, correctAnswer};
    }

    private static int getNumber(int maxNumber) {
        final int minNumber = 2;
        return Engine.random(minNumber, maxNumber);
    }

    private static int[] getPrimes(int primesCount) {
        int[] primes = new int[primesCount];

        final int firstPrimeNumber = 2;
        primes[0] = firstPrimeNumber;

        for (int primeCounter = 1; primeCounter < primesCount; primeCounter++) {
            primes[primeCounter] = getNextPrime(primes[primeCounter - 1]);
        }

        return primes;
    }

    private static int getNextPrime(int previousPrime) {
        int number = previousPrime;
        boolean isNumberPrime;

        do {
            number++;
            isNumberPrime = true;
            int divider = 2;

            do {
                if (number % divider == 0) {
                    isNumberPrime = false;
                }
                divider++;
            } while (divider < number && isNumberPrime);
        } while (!isNumberPrime);

        return number;
    }
}

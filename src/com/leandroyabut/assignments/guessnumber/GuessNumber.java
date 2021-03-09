package com.leandroyabut.assignments.guessnumber;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        int answer = generateRandomNumber(1, 100);
        int tries = 1;

        System.out.println("I generated a number between 1 - 100 (inclusive). You have 5 chances. Guess within 10 of the number and you win!");

        boolean correct;
        while(!(correct = guessIsCorrect(answer, promptNumber("Guess the number: "))) && tries < 5) {
            tries++;
            System.out.println("Try again!");
        }

        if(correct) System.out.println("You got it! The number was " + answer);
        else System.out.println("You didn't get it... Sorry! The number was " + answer);

    }

    /**
     *
     * @param min minimum number
     * @param max maximum number
     * @return random number between min and max inclusive
     */
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random(System.currentTimeMillis());
        return min + Math.abs(rand.nextInt()) % (max + 1 - min);
    }

    public static boolean guessIsCorrect(int answer, int guess) {
        return Math.abs(answer - guess) <= 10;
    }

    public static int promptNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

}

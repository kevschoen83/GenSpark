package banking;

import java.util.HashMap;
import java.util.Random;

public class Card {
    static HashMap<Long, Integer> cardMap = new HashMap<>();

    final int BIN = 400000;

    Card() {
        int num = (int) generateRandomDigits(9);
        String temp = String.valueOf(BIN + "" + num);
        int pin = (int) generateRandomDigits(4);
        Long fullNumber = luhnAlgorithm(BIN + "" + num);
        cardMap.put(fullNumber, pin);

        Database.addCard(String.valueOf(fullNumber) , String.valueOf(pin), String.valueOf(0));

        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(fullNumber);
        System.out.println("Your card PIN:");
        System.out.println(pin + "\n");
    }

    // Generate a random number with n digits
    public static long generateRandomDigits(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }

    // Make sure card numbers are valid with the Luhn Algorithm
    public static Long luhnAlgorithm(String number) {
        char[] charArray = number.toCharArray();

        int[] intArray = new int[15];
        int counter = 0;

        for (char c : charArray) {
            intArray[counter] = Integer.parseInt(String.valueOf(c));
            counter++;
        }

        for (int i = 0; i < intArray.length; i++) {
            if ((i + 1) % 2 != 0) {
                intArray[i] *= 2;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 9) {
                intArray[i] -= 9;
            }
        }

        int sum = 0;

        for (int i : intArray) {
            sum += i;
        }

        int checkSum = 0;

        if (sum % 10 != 0) {
            checkSum = (10 - sum % 10) % 10;
        }

        number += checkSum;

        return Long.parseLong(number);
    }

}


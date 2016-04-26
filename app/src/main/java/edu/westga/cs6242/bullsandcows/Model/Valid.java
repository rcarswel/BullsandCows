package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/19/2016. Version 1.
 * Validates data for Bull Cows game play.
 * - Numbers
 */
public final class Valid {
    /**
     * Checks for a valid number, return boolean result
     * @param number to check as valid
     * @return true if valid
     * @throws IndexOutOfBoundsException if not bounded length
     * @throws IllegalArgumentException  if not all unique arguments
     */
    public static boolean Number(String number, int length) {
        boolean valid = false;

        //Checks for correct length
        if (!(number.length() == length)) {
            throw new IllegalArgumentException("The number doesn't have " + length + " digits!");
        }

        //Checks for unique characters
        for (char c : number.toCharArray()) {
            valid = number.indexOf(c) == number.lastIndexOf(c);
        }
        if (!valid) {
            throw new IllegalArgumentException("The number contains non-unique numbers!");
        } else {
            return true;
        }
    }
}
package edu.westga.cs6242.bullsandcows.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * PlayerComputer for Bulls and Cows game.
 */
public class PlayerComputer extends PlayerAbstract implements Player {
    private int turns;
    private ArrayList<String> guessArray;

    /**
     * Creates a new PlayerComputer. This is an automated player for the human
     * to play against.
     */
    public PlayerComputer() {
    }

    /**
     * Build the Play for a computer player
     */
    public void play(String winningGuess) {
        //Create valid number
        this.setNumber(this.number());
        this.buildArray(winningGuess);
        turns = 0;
    }

    /**
     * Gets the guess for the computer
     * [Later Version will use algorithm]
     * Current solves in 5 to 10 moves
     * by design
     */
    public String getGuess() {
        this.turns = this.turns + new Random().nextInt(1);
        if (this.turns > 10) {
            this.turns = 10;
        }
        try {
            return this.guessArray.get(this.turns);
        } catch (IllegalArgumentException iae) {
            return this.guessArray.get(this.turns);
        }
    }

    /********** Private Helpers *********/
    /**
     * Creates a valid number, by random trial
     * [Update later Version, hard coded for 4 digits]
     */
    private String number() {
        String number = "";
        Boolean pass = false;
        while (!pass) {
            int randomNumber = new Random().nextInt(9000) + 1000;
            try {
                number = Integer.toString(randomNumber);
                pass = Valid.Number(number, 4);

            } catch (IllegalArgumentException iae) {
                pass = false;
            }
        }

        return number;
    }

    /**
     * Builds a guessArray from correct
     */
    private void buildArray(String winningGuess) {
        this.guessArray = new ArrayList<>();
        char[] charList = winningGuess.toCharArray();
        this.guessArray.add("1234");
        this.guessArray.add(charList[0] + "234");
        this.guessArray.add(charList[0] + "2" + charList[1] + "4");
        this.guessArray.add(charList[0] + "2" + charList[1] + charList[2]);
        this.guessArray.add(charList[0] + charList[3] + charList[1] + charList[3] + "");
        this.guessArray.add(charList[0] + charList[1] + "34");
        this.guessArray.add(charList[0] + charList[1] + charList[3] + "4");
        this.guessArray.add(charList[0] + charList[1] + charList[3] + charList[2] + "");
        this.guessArray.add(charList[0] + charList[1] + charList[2] + "4");
        this.guessArray.add(charList[0] + charList[1] + charList[2] + charList[3] + "");
    }
}
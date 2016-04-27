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
        String guess = this.guessArray.get(this.turns);
        this.turns = this.turns + 1;
        return guess;
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
        String aLetter = Character.toString(winningGuess.charAt(0));
        String bLetter = Character.toString(winningGuess.charAt(1));
        String cLetter = Character.toString(winningGuess.charAt(2));
        String dLetter = Character.toString(winningGuess.charAt(3));

        this.guessArray.add("1234");
        this.guessArray.add(aLetter + "234");
        this.guessArray.add(aLetter + "2" + bLetter + "4");
        this.guessArray.add(aLetter + "2" + bLetter + cLetter);
        this.guessArray.add(aLetter + dLetter + bLetter + cLetter);
        this.guessArray.add(aLetter + bLetter + "34");
        this.guessArray.add(aLetter + bLetter + dLetter + "4");
        this.guessArray.add(aLetter + bLetter + dLetter + cLetter);
        this.guessArray.add(aLetter + bLetter + cLetter + "4");
        this.guessArray.add(aLetter + bLetter + cLetter + dLetter);
    }
}
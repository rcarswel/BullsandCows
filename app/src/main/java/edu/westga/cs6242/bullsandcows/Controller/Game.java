package edu.westga.cs6242.bullsandcows.Controller;

import edu.westga.cs6242.bullsandcows.Model.PlayerComputer;
import edu.westga.cs6242.bullsandcows.Model.PlayerHuman;
import edu.westga.cs6242.bullsandcows.Model.Rules;
import edu.westga.cs6242.bullsandcows.Model.Valid;

/**
 * Created by rcarswel on 4/19/2016. Version 1.
 * Game interactions between players (2) and rules for Bulls and Cows game.
 * PlayerA is Human
 * PlayerB is Computer
 * [Later Version will update player interaction.]
 * [Current interaction all behind scenes.]
 */
public class Game {
    private Rules rules;
    private PlayerHuman playerA;
    private PlayerComputer playerB;

    /**
     * Constructor
     * Builds rules and two players
     */
    public Game() {
        this.rules = new Rules();
        // Current 1 Human/ 1 Computer
        this.playerA = new PlayerHuman();
        this.playerA.setPosition(1);
        this.playerB = new PlayerComputer();
        this.playerB.setPosition(2);
    }

    /******** Setters and Getters *********/
    /**
     * Get the results for PlayerA
     */
    public String getPlayerAResults() {
        return this.playerA.toString();
    }

    /**
     * Get the status for player A
     */
    public String getPlayerAStatus() {
        if (this.playerB.getWinner()) {
            return "Loser!";
        } else if (this.playerA.getWinner()) {
            return "Winner!";
        } else {
            return "Keep Playing!";
        }
    }

    /**
     * Get the results for playerB
     */
    public String getPlayerBResult() {
        return "Your #: " + this.playerA.getNumber() + "\n" +
                this.playerB.getResult();
    }

    /**
     * Get game ready string
     */
    public String getReady() {
        if (!(this.rules.ready()) || this.rules.getGameOver()) {
            return "Play!";
        } else {
            return "Guess!";
        }
    }

    /********* Public Logic Methods **********/
    /**
     * Plays Game
     */
    public void play(String number) {
        if (!(this.rules.getGameOver())) {
            if (this.rules.ready()) {
                this.guess(number);
            } else {
                this.start(number);
            }
        } else {
            this.reset();
            this.start(number);
        }
    }

    /**
     * Resets the game
     * but only players
     */
    public void reset() {
        this.rules.reset();

        if (this.playerA.getPosition() == 1) {
            this.playerA.reset();
            this.playerB.reset();
            this.playerB.setPosition(1);
            this.playerA.setPosition(2);
        } else {
            this.playerA.reset();
            this.playerB.reset();
            this.playerA.setPosition(1);
            this.playerB.setPosition(2);
        }
    }

    /******** Private Methods *********/
    /**
     * Start the game,
     * player setup
     * Size = 4, and computer player automatically
     * [Later Versions can Update]
     *
     * @param number for human player
     */
    private boolean start(String number) {
        //Validates Number and Sets
        if (Valid.Number(number, this.rules.getLength())) {
            this.playerA.setNumber(number);
            this.rules.setPlayer(number, this.playerA.getPosition());

            //Creates Computer Player
            this.playerB.play(number);
            this.rules.setPlayer(this.playerB.getNumber(), this.playerB.getPosition());
        }

        return this.rules.ready();
    }

    /**
     * Guess for both players
     */
    private void guess(String number) {
        //Set first player
        if (this.playerA.getPosition() == 1) {
            //Player 1 Plays
            this.playerA.guessResults(rules.guess(number, this.playerB.getPosition()));
            this.playerA.setWinner(this.rules.getGameOver());

            //Player 2 Plays
            this.playerB.guessResults(rules.guess(this.playerB.getGuess(), this.playerA.getPosition()));
            this.playerB.setWinner(this.rules.getGameOver());
        } else {
            //Player 1 Plays
            this.playerB.guessResults(rules.guess(this.playerB.getGuess(), this.playerA.getPosition()));
            this.playerB.setWinner(this.rules.getGameOver());

            //Player 2 Plays
            this.playerA.guessResults(rules.guess(number, this.playerB.getPosition()));
            this.playerA.setWinner(this.rules.getGameOver());
        }
    }
}
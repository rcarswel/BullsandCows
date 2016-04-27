package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/19/2016. Version 1.
 * Basic game play for Bulls and Cows game.
 * - Stores/returns number length. Initial creation medium(4 digits) [to add in later version] easy(5) and hard(3)
 * - Stores player numbers. Assume valid, from controller.
 * - Checks guess against actual, returns bulls or cows.
 * - Updates game over, returns true/false.
 */
public class Rules {
    private int numberLength;
    private String player1;
    private String player2;
    private boolean gameOver;

    /**
     * Constructor
     * - Set length to default
     * - Resets rules
     */
    public Rules() {
        this.numberLength = 4;
        this.reset();
    }

    /********** Setters/getters **********/

    /**
     * Returns the length of number
     * @return length of the number (number of characters)
     */
    public int getLength() {
        return this.numberLength;
    }

    /**
     * Sets the length
     * Hard code to default for version 1
     * Level 3,4 or 5 [Add in later Version]
     * @param length of the number (number of characters)
     * @throws IllegalArgumentException if not correct length
     */
    public void setLength(int length) {
        //Checks length to game parameters
        if (length < 3 || length > 5) {
            throw new IllegalArgumentException("Length " + length + " in out of bounds!");
        } else {
            this.numberLength = length;
        }
    }

    /**
     * Sets player number, valid from controller
     * @param number for player one
     * @param player number 1 or 2, checks
     * @throws IllegalArgumentException if not correct players
     */
    public void setPlayer(String number, int player) {
        //Confirms player [1 or 2]
        //Invalid players will throw error
        if (player == 1) {
            this.player1 = number;
        } else if (player == 2) {
            this.player2 = number;
        } else {
            throw new IllegalArgumentException("Only player 1 or 2, there is no player " + player + "!");
        }
    }

    /**
     * Gets if players both have numbers
     */
    public boolean ready() {
        return !(this.player1.length() == 0 || this.player2.length() == 0);
    }

    /**
     * Gets the game status (game over)
     * @return gameOver
     */
    public boolean getGameOver() {
        return this.gameOver;
    }

    /********** Public Logic Methods **********/
    /**
     * Guess results
     * @param guess to compare
     * @param player to determine actual
     * @return current guess results
     */
    public String guess(String guess, int player) {
        int bulls = this.getBulls(guess, player);
        int cows = this.getCows(guess, player);
        return "#: " + guess + "\tB: " + bulls + "\tC: " + cows;
    }

    /**
     * Resets the game to play again
     * - Number to blank
     * - GameOver to false
     */
    public void reset() {
        this.player1 = "";
        this.player2 = "";
        this.gameOver = false;
    }

    /********** Private Methods **********/
    /**
     * Gets player number
     *
     * @param player number 1 or 2, checks
     * @return playerNumber
     * @throws IllegalArgumentException if not correct players
     */
    private String getPlayer(int player) {
        //Confirms player [1 or 2]
        //Invalid players will throw error
        if (player == 1) {
            return this.player1;
        } else if (player == 2) {
            return this.player2;
        } else {
            throw new IllegalArgumentException("Only player 1 or 2, there is no player " + player + "!");
        }
    }

    /**
     * Gets the number of bulls in a guess
     * @param guess to compare
     * @param player to determine actual
     * @return bulls number
     * @throws IllegalArgumentException if player is missing number
     */
    private int getBulls(String guess, int player) {
        int bulls = 0;

        //Throws if both are not ready
        if (!(this.ready())) {
            throw new IllegalArgumentException("Both player are not ready!");
        }

        //Gets number to check
        String actual = this.getPlayer(player);

        //Counts bulls
        char[] actualArray = actual.toCharArray();
        char[] guessArray = guess.toCharArray();
        for (int count = 0; count < this.getLength(); count++) {
            if (actualArray[count] == guessArray[count]) {
                bulls++;
            }
        }

        //Checks win
        if (bulls == this.getLength()) {
            this.gameOver = true;
        }

        return bulls;
    }

    /**
     * Gets the number of cows in a guess
     * @param guess to compare
     * @param player to determine actual
     * @return cows number
     * @throws IllegalArgumentException if player is missing number
     */
    private int getCows(String guess, int player) {
        int cows = 0;

        //Throws if both are not ready
        if (!(this.ready())) {
            throw new IllegalArgumentException("Both player are not ready!");
        }

        //Gets number to check
        String actual = this.getPlayer(player);

        //Counts cows
        char[] actualArray = actual.toCharArray();
        char[] guessArray = guess.toCharArray();
        for (char c : guessArray) {
            for (int count = 0; count < this.getLength(); count++) {
                if (c == actualArray[count]) {
                    cows++;
                }
            }
        }

        //Removes bulls from cows
        cows = cows - this.getBulls(guess, player);

        return cows;
    }
}
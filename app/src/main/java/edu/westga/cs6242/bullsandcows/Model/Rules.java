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
     * - Sets number to blank
     * - Sets game ove to false
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
     * @throws IndexOutOfBoundsException if not bounded length
     */
    public void setLength(int length) {
        //Checks length to game parameters
        if (length < 3 || length > 5) {
            throw new IndexOutOfBoundsException("Length " + length + " in out of bounds!");
        } else {
            this.numberLength = length;
        }
    }

    /**
     * Sets player number
     * @param number for player one
     * @param player number 1 or 2, checks
     * @throws IndexOutOfBoundsException if not bounded players
     */
    public void setPlayer(String number, int player) {
        //Confirms player [1 or 2]
        //Invalid players will throw error
        if (player == 1) {
            this.player1 = number;
        } else if (player == 2) {
            this.player2 = number;
        } else {
            throw new IndexOutOfBoundsException("Only player 1 or 2, there is no player " + player + "!");
        }
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
     * Gets the number of bulls in a guess
     * @param guess to compare
     * @param player to determine actual
     * @return bulls number
     */
    public int getBulls(String guess, int player) {
        int bulls = 0;

        //Throws if both are not ready
        this.ready();

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
     */
    public int getCows(String guess, int player) {
        int cows = 0;

        //Throws if both are not ready
        this.ready();

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

    /**
     * Resets the game to play again
     */
    public void reset() {
        this.player1 = "";
        this.player2 = "";
        this.gameOver = false;
    }

    /********** Private Methods **********/
    /**
     * Checks both players have numbers
     * @return true if ready
     * @throws IllegalArgumentException if player is missing number
     */
    private boolean ready() {
        if (this.player1.length() == 0 || this.player2.length() == 0) {
            throw new IllegalArgumentException("Both player are not ready!");
        }
        return true;
    }

    /**
     * Gets player number
     * @param player number 1 or 2, checks
     * @return playerNumber
     * @throws IndexOutOfBoundsException if not bounded players
     */
    private String getPlayer(int player) {
        //Confirms player [1 or 2]
        //Invalid players will throw error
        if (player == 1) {
            return this.player1;
        } else if (player == 2) {
            return this.player2;
        } else {
            throw new IndexOutOfBoundsException("Only player 1 or 2, there is no player " + player + "!");
        }
    }
}
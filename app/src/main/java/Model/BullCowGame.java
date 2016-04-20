package Model;

/**
 * Created by rcarswel on 4/19/2016. Version 1.
 * Basic game play for Bulls and Cows game.
 * - Stores/returns number length. Initial creation medium(4 digits) [to add] easy(5) and hard(3)
 * - Checks number as valid for current game, Returns true/false.
 * - Stores player numbers.
 * - Checks guess against actual, returns bulls or cows.
 * - Updates game over, returns true/false.
 */
public class BullCowGame {
    //DEFAULTLENGTH will change to easy in later version
    private final int DEFAULTLENGTH = 4;
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
    public void BullCowGame() {
        this.setLength(DEFAULTLENGTH);
        this.player1 = "";
        this.player2 = "";
        this.gameOver = false;
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
     * Level 3,4 or 5
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
     *
     * @param number for player one
     *               validated
     * @param player number 1 or 2
     *               checks
     * @throws IndexOutOfBoundsException if not bounded players
     */
    public void setPlayer(String number, int player) {
        if (validNumber(number)) {
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
    }

    /**
     * Gets the game status (game over)
     *
     * @return gameOver
     */
    public boolean getGameOver() {
        return this.gameOver;
    }

    /********** Public Logic Methods **********/
    /**
     * Gets the number of bulls in a guess
     * @param guess to compare
     *              validated
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
        if (validNumber(guess)) {
            char[] actualArray = actual.toCharArray();
            char[] guessArray = guess.toCharArray();

            for (int count = 0; count < this.getLength(); count++) {
                if (actualArray[count] == guessArray[count]) {
                    bulls++;
                }
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
     *              validated
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
        if (validNumber(guess)) {
            char[] actualArray = actual.toCharArray();
            char[] guessArray = guess.toCharArray();

            for (char c : guessArray) {
                for (int count = 0; count < this.getLength(); count++) {
                    if (c == actualArray[count]) {
                        cows++;
                    }
                }
            }
        }

        //Removes bulls from cows
        cows = cows - this.getBulls(guess, player);

        return cows;
    }

    /********** Private Methods **********/
    /**
     * Checks for a valid number, return boolean result
     * @param number  to check as valid
     * @return true if valid
     * @throws IndexOutOfBoundsException if not bounded length
     * @throws IllegalArgumentException if not all unique arguments
     */
    private boolean validNumber(String number) {
        boolean valid = false;

        //Checks for correct length
        if (!(number.length() == this.getLength())) {
            throw new IllegalArgumentException("The number doesn't have " + this.getLength() + " digits!");
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

    /**
     * Checks both players have numbers
     *
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
     * @param player number 1 or 2
     *               checks
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
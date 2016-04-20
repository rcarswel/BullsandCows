package Model;

/**
 * Created by rcarswel on 4/19/2016. Version 1.
 * Basic game play for Bulls and Cows game.
 * - Stores/returns number length. Initial creation medium(4 digits) [to add] easy(5) and hard(3)
 * - Checks number as valid for current game, Returns true/false.
 * - Checks guess against actual, returns bulls or cows.
 * - Updates game over, returns true/false.
 */
public class BullCowGame {
    //DEFAULTLENGTH will change to easy in later version
    private final int DEFAULTLENGTH = 4;
    private int bulls;
    private int cows;
    private boolean gameOver;
    private int numberLength;

    public void BullCowGame() {
        this.setLength(DEFAULTLENGTH);
        this.bulls = 0;
        this.cows = 0;
        this.gameOver = false;
    }

    /********** Getters/Setters **********/

    /**
     * Returns the length of number
     */
    public int getLength() {
        return this.numberLength;
    }

    /**
     * Sets the length
     * Hard code to default for version 1
     * Level 3,4 or 5
     */
    public void setLength(int length) {
        if (length < 3 || length > 5) {
            throw new IndexOutOfBoundsException("Length " + length + " in out of bounds!");
        } else {
            this.numberLength = length;
        }
    }

    /**
     * Gets the number of bulls in a guess
     */
    public int getBulls() {
        return this.bulls;
    }

    /**
     * Gets the number of bulls in a guess
     */
    public int getCows() {
        return this.cows;
    }

    /********** Public Methods **********/
    /**
     * Checks for a valid number, return boolean result
     */
    public boolean validNumber(String number) {
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
     * Compares numbers, returns Bull Cow string
     */
    public void compare(String actual, String guess) {
        this.bulls = 0;
        this.cows = 0;
        //Checks for Win
        if (guess.equals(actual)) {
            this.gameOver = true;
            bulls = this.getLength();
            return this.results(bulls, cows);
        }


    }

    /********** Private Helpers **********/
}
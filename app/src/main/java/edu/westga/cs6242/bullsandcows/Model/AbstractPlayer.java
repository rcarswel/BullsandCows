package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * AbstractPlayer for Bulls and Cows game.
 */
public abstract class AbstractPlayer implements Player {
    private boolean isMyTurn;
    private String number;
    private String results;

    /**
     * Creates a new player's
     */
    public AbstractPlayer() {
        this.isMyTurn = false;
        this.number = "";
        this.results = "";
    }

    @Override
    /**
     * @See Player#getIsMyTurn()
     */
    public boolean getIsMyTurn() {
        return this.isMyTurn;
    }

    /**********
     * Setters/getters
     **********/
    @Override
    /**
     * @See Player#setIsMyTurn(boolean isMyTurn)
     */
    public void setIsMyTurn(boolean isMyTurn) {
        this.isMyTurn = isMyTurn;
    }

    @Override
    /**
     * @See Player#getNumber()
     */
    public String getNumber() {
        return this.number;
    }

    @Override
    /**
     * @See Player#setNumber(String number);
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**********
     * Public Logic Methods
     **********/
    @Override
    /**
     * @See Player#takeTurn()
     */
    public void takeTurn() {
        //Work on
    }

    @Override
    /**
     * @See Player#guess(String guess);
     */
    public void guessResults(String guessResults) {
        this.results = this.results + guessResults + "\n";
    }

    @Override
    /**
     * @See Player#toString()
     */
    public String toString() {
        return " ~ Guess Results ~ " +
                "Number\tBulls\tCows" +
                this.results;
    }

    @Override
    /**
     * @See Player#reset();
     */
    public void reset() {
        this.isMyTurn = false;
        this.number = "";
    }
}

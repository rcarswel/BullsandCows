package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * AbstractPlayer for Bulls and Cows game.
 */
public abstract class AbstractPlayer implements Player {
    private boolean isMyTurn;
    private String number;
    private int bulls;
    private int cows;

    /**
     * Creates a new player's
     */
    public AbstractPlayer() {
        this.isMyTurn = false;
        this.number = "";
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

    @Override
    /**
     * @See Player#setBulls(int bulls)
     */
    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    @Override
    /**
     * @See Player#setCows(int cows)
     */
    public void setCows(int cows) {
        this.cows = cows;
    }

    @Override
    /**
     * @See Player#getResults();
     */
    public String getResults() {
        return this.getNumber() + ":\tBulls: " + this.bulls + "\tCows: " + this.cows;
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
     * @See Player#reset();
     */
    public void reset() {
        this.isMyTurn = false;
        this.number = "";
    }
}

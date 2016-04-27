package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * PlayerAbstract for Bulls and Cows game.
 */
public abstract class PlayerAbstract implements Player {
    private String number;
    private int position;
    private String currentResults;
    private Boolean winner;
    private String results;

    /**
     * Creates a new player's
     */
    public PlayerAbstract() {
        this.number = "";
        this.position = 1;
        this.currentResults = "";
        this.winner = false;
        this.results = "";
    }

    @Override
    /**
     * @See Player#getNumber()
     */
    public String getNumber() {
        return this.number;
    }

    /***********
     * Setters/getters
     **********/
    @Override
    /**
     * @See Player#setNumber(String number);
     */
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    /**
     * @See Player#getPosition
     */
    public int getPosition() {
        return this.position;
    }

    @Override
    /**
     * @See Player#setPostion
     */
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    /**
     * @See Player#getResult
     */
    public String getResult() {
        if (this.currentResults.length() == 0) {
            return "No Guess, Yet!";
        } else {
            return this.currentResults;
        }
    }

    @Override
    /**
     * @See Player#getWinner
     */
    public Boolean getWinner() {
        return this.winner;
    }

    @Override
    /**
     * @See Player#setWinner(Boolean)
     */
    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    /**********
     * Public Logic Methods
     **********/

    @Override
    /**
     * @See Player#guess(String guess);
     */
    public void guessResults(String guessResults) {
        this.currentResults = guessResults;
        this.results = this.results + guessResults + "\n";
    }

    @Override
    /**
     * @See Player#toString()
     */
    public String toString() {
        return " ~ Guess Results ~ \n" +
                this.results;
    }

    @Override
    /**
     * @See Player#reset();
     * @Throws IllegalArgumentException if not correct positions
     */
    public void reset() {
        this.number = "";
        if (this.position == 1) {
            this.position = 2;
        } else if (this.position == 2) {
            this.position = 1;
        } else {
            throw new IllegalArgumentException("Position Error!");
            //Error is for coding check, [Later Version May increase players]
        }
        this.currentResults = "";
        this.winner = false;
        this.results = "";
    }
}
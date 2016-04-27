package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * PlayerAbstract for Bulls and Cows game.
 */
public abstract class PlayerAbstract implements Player {
    private boolean isMyTurn;
    private int position;
    private String number;
    private String currentResults;
    private String results;
    private Boolean winner;

    /**
     * Creates a new player's
     */
    public PlayerAbstract() {
        this.isMyTurn = false;
        this.position = 1;
        this.number = "";
        this.currentResults = "";
        this.results = "";
        this.winner = false;
    }

    /***********
     * Setters/getters
     **********/
    @Override
    /**
     * @See Player#getIsMyTurn()
     */
    public boolean getIsMyTurn() {
        return this.isMyTurn;
    }

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
        if (this.currentResults == "") {
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
                "Number\tBulls\tCows\n" +
                this.results;
    }

    @Override
    /**
     * @See Player#reset();
     */
    public void reset() {
        this.isMyTurn = false;
        this.number = "";
        this.results = "";
        if (this.position == 1) {
            this.position = 2;
        } else if (this.position == 2) {
            this.position = 1;
        } else {
            throw new IndexOutOfBoundsException("Position Error!");
            //Error is for coding check, [Later Version May increase players]
        }
    }
}

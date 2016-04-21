package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * Player interface for Bulls and Cows game.
 */
public interface Player {

    /********** Setters/getters **********/
    /**
     * Gets if its player's turn, return boolean result
     *
     * @return true if player's turn
     */
    boolean getIsMyTurn();

    /**
     * Sets if its player's turn
     *
     * @param isMyTurn to check turn
     */
    void setIsMyTurn(boolean isMyTurn);

    /**
     * Sets player's number
     *
     * @param number player's
     */
    int setNumber(String number);

    /**
     * Gets player's number
     *
     * @return number player's
     */
    int getNumber();

    /**
     * Gets Bulls and Cows results string
     *
     * @param guess player's
     * @return String results
     */
    String getResults(String guess);

    /********** Public Logic Methods **********/
    /**
     * Allows player to take turn
     */
    void takeTurn();

    /**
     * Resets Player status and data
     */
    void reset();


}

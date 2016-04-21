package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * Player interface for Bulls and Cows game.
 * - Sets/Gets player's turn
 * - Sets/Gets player's number
 * - Gets results of guess
 * - Takes turn
 * - Resets player
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
     * @param isMyTurn to check turn
     */
    void setIsMyTurn(boolean isMyTurn);

    /**
     * Gets player's number
     * @return number player's
     */
    String getNumber();

    /**
     * Sets player's number
     * @param number player's
     */
    void setNumber(String number);

    /**
     * Sets Bulls
     *
     * @param bulls
     */
    void setBulls(int bulls);

    /**
     * Sets Cows
     *
     * @param cows
     */
    void setCows(int cows);

    /**
     * Gets Bulls and Cows results string
     * @return String results
     */
    String getResults();

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

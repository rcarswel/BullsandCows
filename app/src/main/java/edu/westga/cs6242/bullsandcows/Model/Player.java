package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * Player interface for Bulls and Cows game.
 * - Sets/Gets player's turn
 * - Sets/Gets player's number
 * - Sets/Gets player's position
 * - Gets results of guess
 * - Takes turn
 * - Updates record
 * - toString (Record)
 * - Resets player
 */
public interface Player {

    /********** Setters/getters **********/
    /**
     * Gets if its player's turn, return boolean result
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
     * Validate in controller
     * @param number player's
     */
    void setNumber(String number);


    /**
     * Gets player's position
     *
     * @return position player's
     */
    int getPosition();

    /**
     * Sets player's position
     * Validate in controller
     *
     * @param position player's
     */
    void setPosition(int position);

    /********** Public Logic Methods **********/
    /**
     * Allows player to take turn
     */
    //void takeTurn();

    /**
     * Returns the guess results
     * @param guessResults string of bulls and cows
     */
    void guessResults(String guessResults);

    /**
     * String of results for game
     * @return Game results
     */
    String toString();

    /**
     * Resets Player status and data
     */
    void reset();
}
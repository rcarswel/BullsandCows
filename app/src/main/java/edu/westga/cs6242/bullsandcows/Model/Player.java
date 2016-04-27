package edu.westga.cs6242.bullsandcows.Model;

/**
 * Created by rcarswel on 4/21/2016. Version 1.
 * Player interface for Bulls and Cows game.
 * - Sets/Gets player's number
 * - Sets/Gets player's position
 * - Gets results of guess
 * - Sets/Gets if winner
 * - Updates record
 * - toString (Record)
 * - Resets player
 */
public interface Player {

    /********** Setters/getters **********/
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

    /**
     * Gets the current guess result
     *
     * @return result of last guess
     */
    String getResult();

    /**
     * Gets winner
     */
    Boolean getWinner();

    /**
     * Sets winner
     *
     * @param winner of game
     */
    void setWinner(Boolean winner);

    /********** Public Logic Methods **********/

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
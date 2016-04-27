package edu.westga.cs6242.bullsandcows;

import org.junit.Test;

import edu.westga.cs6242.bullsandcows.Model.Rules;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class RulesTest {

    /**
     * Test for initial creation
     * getLength(), should be 4
     * @throws Exception
     */
    @Test
    public void testAtCreationGetLength() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //Length should be default
        int length = rules.getLength();
        assertEquals("Length is " + length + " instead of 4.", 4, length, 0);
    }

    /**
     * Test for initial creation
     * Ready(), should be false
     * @throws Exception
     */
    @Test
    public void testAtCreationReady() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //Length should be default
        Boolean ready = rules.ready();
        assertEquals("Ready is " + ready + " instead of false.", false, ready);
    }

    /**
     * Test for initial creation
     * getGameOver, should be false
     * @throws Exception
     */
    @Test
    public void testAtCreationGetGameOver() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //GameOver should be false
        boolean gameOver = rules.getGameOver();
        assertEquals("GameOver is " + gameOver + " instead of false.", false, gameOver);
    }

    /**
     * Test for set length of 5 or 3
     * setLength, no error and getLength should return 5 or 3
     * @throws Exception
     */
    @Test
    public void testSetLengthGood() throws Exception {
        //Create new game
        Rules rules = new Rules();
        int length;

        //Length should be 3
        rules.setLength(3);
        length = rules.getLength();
        assertEquals("Length is " + length + " instead of 3.", 3, length, 0);

        //Length should be 5
        rules.setLength(5);
        length = rules.getLength();
        assertEquals("Length is " + length + " instead of 5.", 5, length, 0);

        //Length should be 4
        rules = new Rules();
        length = rules.getLength();
        assertEquals("Length is " + length + " instead of 4.", 4, length, 0);
    }

    /**
     * Test for set length of 5 or 3
     * setLength, no errors
     * @throws Exception
     */
    @Test
    public void testSetLengthBad() throws Exception {
        //Create new game
        Rules rules = new Rules();
        int length;

        //Length should not be 2
        try {
            rules.setLength(2);
            length = rules.getLength();
            assertEquals("Length is " + length + " instead of 2.", 2, length, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Length 2 in out of bounds!", iae.getMessage());
        }

        //Length should not be 6
        try {
            rules.setLength(6);
            length = rules.getLength();
            assertEquals("Length is " + length + " instead of 6.", 6, length, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Length 6 in out of bounds!", iae.getMessage());
        }
    }

    /**
     * Test for set player
     * setPlayer, no error getGameOver and getLength return correct
     * @throws Exception
     */
    @Test
    public void testSetPlayerGood() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //Player 1, 4 digit number
        rules.setPlayer("1234", 1);
        assertEquals("GameOver is " + rules.getGameOver() + " instead of false.", false, rules.getGameOver());
        assertEquals("Length is " + rules.getLength() + " instead of 4.", 4, rules.getLength(), 0);

        //Player 2, 4 digit number
        rules.setPlayer("1234", 2);
        assertEquals("GameOver is " + rules.getGameOver() + " instead of false.", false, rules.getGameOver());
        assertEquals("Length is " + rules.getLength() + " instead of 4.", 4, rules.getLength(), 0);

        //Player 1, 3 digit number
        rules.setLength(3);
        rules.setPlayer("123", 1);
        assertEquals("GameOver is " + rules.getGameOver() + " instead of false.", false, rules.getGameOver());
        assertEquals("Length is " + rules.getLength() + " instead of 3.", 3, rules.getLength(), 0);

        //Player 1, 5 digit number
        rules.setLength(5);
        rules.setPlayer("12345", 1);
        assertEquals("GameOver is " + rules.getGameOver() + " instead of false.", false, rules.getGameOver());
        assertEquals("Length is " + rules.getLength() + " instead of 5.", 5, rules.getLength(), 0);
    }

    /**
     * Test for set player
     * setPlayer, errors
     * @throws Exception
     */
    @Test
    public void testSetPlayerBad() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //Player 0, 4 digit number
        try {
            rules.setPlayer("1234", 0);
            assertEquals("GameOver is " + rules.getGameOver() + " instead of false.", false, rules.getGameOver());
            assertEquals("Length is " + rules.getLength() + " instead of 4.", 4, rules.getLength(), 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Only player 1 or 2, there is no player 0!", iae.getMessage());
        }

        //Player 4, 4 digit number
        try {
            rules.setPlayer("1234", 4);
            assertEquals("GameOver is " + rules.getGameOver() + " instead of false.", false, rules.getGameOver());
            assertEquals("Length is " + rules.getLength() + " instead of 4.", 4, rules.getLength(), 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Only player 1 or 2, there is no player 4!", iae.getMessage());
        }
    }

    /**
     * Test guess
     * @throws Exception
     */
    @Test
    public void testGuess1() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //Set Players
        rules.setPlayer("1234", 1);
        rules.setPlayer("9876", 2);

        //Guess 2 and 2, false
        String guess = rules.guess("1324", 1);
        boolean gameOver = rules.getGameOver();
        assertEquals("Guess is " + guess + " instead of false.", "#: 1324\tB: 2\tC: 2", guess);
        assertEquals("GameOver is " + gameOver + " instead of false.", false, gameOver);
    }

    /**
     * Test guess
     * @throws Exception
     */
    @Test
    public void testGuess2() throws Exception {
        //Create new game
        Rules rules = new Rules();

        //Set Players
        rules.setPlayer("1234", 1);
        rules.setPlayer("9876", 2);

        //Guess 2 and 2, false
        String guess = rules.guess("9876", 2);
        boolean gameOver = rules.getGameOver();
        assertEquals("Guess is " + guess + " instead of false.", "#: 9876\tB: 4\tC: 0", guess);
        assertEquals("GameOver is " + gameOver + " instead of false.", true, gameOver);
    }
}
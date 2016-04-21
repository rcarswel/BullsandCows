package edu.westga.cs6242.bullsandcows;

import org.junit.Test;

import edu.westga.cs6242.bullsandcows.Model.BullCowGame;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class BullCowGameUnitTest {

    /**
     * Test for initial creation
     * getLength(), should be 4
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetLength() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();

        //Length should be default
        int length = bullCowGame.getLength();
        assertEquals("Length is " + length + " instead of 4.", 4, length, 0);
    }

    /**
     * Test for initial creation
     * getGameOver, should be false
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetGameOver() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();

        //GameOver should be false
        boolean gameOver = bullCowGame.getGameOver();
        assertEquals("GameOver is " + gameOver + " instead of false.", false, gameOver);
    }

    /**
     * Test for initial creation
     * getBulls, no player ready
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetBulls() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();

        //Should throw error
        try {
            int bulls = bullCowGame.getBulls("1234", 1);
            assertEquals("Bulls is " + bulls + " instead of 0.", 0, bulls, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Both player are not ready!", iae.getMessage());
        }
    }

    /**
     * Test for initial creation
     * getCows, no player ready
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetCows() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();

        //Should throw error
        try {
            int cows = bullCowGame.getCows("1234", 1);
            assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Both player are not ready!", iae.getMessage());
        }
    }

    /**
     * Test for set length of 5 or 3
     * setLength, no error and getLength should return 5 or 3
     *
     * @throws Exception
     */
    @Test
    public void testSetLengthGood() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();
        int length;

        //Length should be 3
        bullCowGame.setLength(3);
        length = bullCowGame.getLength();
        assertEquals("Length is " + length + " instead of 3.", 3, length, 0);

        //Length should be 5
        bullCowGame.setLength(5);
        length = bullCowGame.getLength();
        assertEquals("Length is " + length + " instead of 5.", 5, length, 0);

        //Length should be 4
        bullCowGame = new BullCowGame();
        length = bullCowGame.getLength();
        assertEquals("Length is " + length + " instead of 4.", 4, length, 0);
    }

    /**
     * Test for set length of 5 or 3
     * setLength, no errors
     *
     * @throws Exception
     */
    @Test
    public void testSetLengthBad() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();
        int length;

        //Length should not be 2
        try {
            bullCowGame.setLength(2);
            length = bullCowGame.getLength();
            assertEquals("Length is " + length + " instead of 2.", 2, length, 0);
        } catch (IndexOutOfBoundsException iobe) {
            assertEquals("Error message doesn't match.", "Length 2 in out of bounds!", iobe.getMessage());
        }

        //Length should not be 6
        try {
            bullCowGame.setLength(6);
            length = bullCowGame.getLength();
            assertEquals("Length is " + length + " instead of 6.", 6, length, 0);
        } catch (IndexOutOfBoundsException iobe) {
            assertEquals("Error message doesn't match.", "Length 6 in out of bounds!", iobe.getMessage());
        }
    }

    /**
     * Test for set player
     * setPlayer, no error getGameOver and getLength return correct
     *
     * @throws Exception
     */
    @Test
    public void testSetPlayerGood() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();

        //Player 1, 4 digit number
        bullCowGame.setPlayer("1234", 1);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
        assertEquals("Length is " + bullCowGame.getLength() + " instead of 4.", 4, bullCowGame.getLength(), 0);

        //Player 2, 4 digit number
        bullCowGame.setPlayer("1234", 2);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
        assertEquals("Length is " + bullCowGame.getLength() + " instead of 4.", 4, bullCowGame.getLength(), 0);

        //Player 1, 3 digit number
        bullCowGame.setLength(3);
        bullCowGame.setPlayer("123", 1);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
        assertEquals("Length is " + bullCowGame.getLength() + " instead of 3.", 3, bullCowGame.getLength(), 0);

        //Player 1, 5 digit number
        bullCowGame.setLength(5);
        bullCowGame.setPlayer("12345", 1);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
        assertEquals("Length is " + bullCowGame.getLength() + " instead of 5.", 5, bullCowGame.getLength(), 0);
    }

    /**
     * Test for set player
     * setPlayer, errors
     *
     * @throws Exception
     */
    @Test
    public void testSetPlayerBad() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();

        //Player 0, 4 digit number
        try {
            bullCowGame.setPlayer("1234", 0);
            assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
            assertEquals("Length is " + bullCowGame.getLength() + " instead of 4.", 4, bullCowGame.getLength(), 0);
        } catch (IndexOutOfBoundsException iobe) {
            assertEquals("Error message doesn't match.", "Only player 1 or 2, there is no player 0!", iobe.getMessage());
        }

        //Player 4, 4 digit number
        try {
            bullCowGame.setPlayer("1234", 4);
            assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
            assertEquals("Length is " + bullCowGame.getLength() + " instead of 4.", 4, bullCowGame.getLength(), 0);
        } catch (IndexOutOfBoundsException iobe) {
            assertEquals("Error message doesn't match.", "Only player 1 or 2, there is no player 4!", iobe.getMessage());
        }

        //Player 1, 5 digit number
        try {
            bullCowGame.setPlayer("12345", 1);
            assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
            assertEquals("Length is " + bullCowGame.getLength() + " instead of 5.", 5, bullCowGame.getLength(), 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "The number doesn't have " + bullCowGame.getLength() + " digits!", iae.getMessage());
        }

        //Player 1, 4 same digit number
        try {
            bullCowGame.setPlayer("4444", 1);
            assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());
            assertEquals("Length is " + bullCowGame.getLength() + " instead of 5.", 5, bullCowGame.getLength(), 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "The number contains non-unique numbers!", iae.getMessage());
        }
    }

    /**
     * Test for get bulls and cows
     * getBulls/Cows, no error
     *
     * @throws Exception
     */
    @Test
    public void testGetResultsGood() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();
        bullCowGame.setPlayer("1234", 1);
        bullCowGame.setPlayer("9876", 2);
        int bulls;
        int cows;

        //0 Bulls & 0 Cows
        bulls = bullCowGame.getBulls("9876", 1);
        cows = bullCowGame.getCows("9876", 1);
        assertEquals("Bulls is " + bulls + " instead of 0.", 0, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());

        //0 Bulls & 1 Cows
        bulls = bullCowGame.getBulls("1239", 2);
        cows = bullCowGame.getCows("1239", 2);
        assertEquals("Bulls is " + bulls + " instead of 0.", 0, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 1.", 1, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());

        //0 Bulls & 4 Cows
        bulls = bullCowGame.getBulls("4321", 1);
        cows = bullCowGame.getCows("4321", 1);
        assertEquals("Bulls is " + bulls + " instead of 0.", 0, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 4.", 4, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());

        //1 Bulls & 3 Cows
        bulls = bullCowGame.getBulls("9687", 2);
        cows = bullCowGame.getCows("9687", 2);
        assertEquals("Bulls is " + bulls + " instead of 1.", 1, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 3.", 3, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());

        //2 Bulls & 2 Cows
        bulls = bullCowGame.getBulls("1243", 1);
        cows = bullCowGame.getCows("1243", 1);
        assertEquals("Bulls is " + bulls + " instead of 2.", 2, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 2.", 2, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());

        //3 Bulls & 0 Cows
        bulls = bullCowGame.getBulls("9875", 2);
        cows = bullCowGame.getCows("9875", 2);
        assertEquals("Bulls is " + bulls + " instead of 3.", 3, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of false.", false, bullCowGame.getGameOver());

        //4 Bulls & 0 Cows
        bulls = bullCowGame.getBulls("1234", 1);
        cows = bullCowGame.getCows("1234", 1);
        assertEquals("Bulls is " + bulls + " instead of 4.", 4, bulls, 0);
        assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        assertEquals("GameOver is " + bullCowGame.getGameOver() + " instead of true.", true, bullCowGame.getGameOver());
    }

    /**
     * Test for get bulls and cows
     * getBulls/Cows, errors
     *
     * @throws Exception
     */
    @Test
    public void testGetResultsBad() throws Exception {
        //Create new game
        BullCowGame bullCowGame = new BullCowGame();
        bullCowGame.setPlayer("1234", 1);
        int bulls;
        int cows;

        //Should throw error no 2 player
        try {
            cows = bullCowGame.getCows("1234", 2);
            assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "Both player are not ready!", iae.getMessage());
        }

        bullCowGame.setPlayer("9876", 2);
        //Should throw error no 3 player
        try {
            cows = bullCowGame.getCows("1234", 3);
            assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        } catch (IndexOutOfBoundsException iobe) {
            assertEquals("Error message doesn't match.", "Only player 1 or 2, there is no player 3!", iobe.getMessage());
        }

        //Should throw error wrong digits
        try {
            cows = bullCowGame.getCows("12345", 2);
            assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "The number doesn't have 4 digits!", iae.getMessage());
        }

        //Should throw error same digits
        try {
            cows = bullCowGame.getCows("4444", 2);
            assertEquals("Cows is " + cows + " instead of 0.", 0, cows, 0);
        } catch (IllegalArgumentException iae) {
            assertEquals("Error message doesn't match.", "The number contains non-unique numbers!", iae.getMessage());
        }
    }
}
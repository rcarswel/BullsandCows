package edu.westga.cs6242.bullsandcows;

import org.junit.Test;

import edu.westga.cs6242.bullsandcows.Controller.Game;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class GameTest {

    /**
     * Test for initial creation
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetPlayerAResults() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        String results = game.getPlayerAResults();
        assertEquals("Results is " + results + " instead of correct.", " ~ Guess Results ~ \n", results);
    }

    /**
     * Test for initial creation
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetPlayerAStatus() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        String results = game.getPlayerAStatus();
        assertEquals("Results is " + results + " instead of correct.", "Keep Playing!", results);
    }

    /**
     * Test for initial creation
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetPlayerBResult() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        String results = game.getPlayerBResult();
        assertEquals("Results is " + results + " instead of correct.", "Your #: \nNo Guess, Yet!", results);
    }

    /**
     * Test for initial creation
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetReady() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        String results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Play!", results);
    }

    /**
     * Test for play
     *
     * @throws Exception
     */
    @Test
    public void testPlay() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        game.play("1234");
        String results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);
    }

    /**
     * Test for guess
     *
     * @throws Exception
     */
    @Test
    public void testGuess1() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        game.play("1234");
        String results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);

        game.play("9876");
        results = game.getPlayerAStatus();
        assertEquals("Results is " + results + " instead of correct.", "Loser!", results);
    }

    /**
     * Test for guess
     *
     * @throws Exception
     */
    @Test
    public void testGuess2() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        game.play("9876");
        String results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);

        game.play("1234");
        results = game.getPlayerAStatus();
        assertEquals("Results is " + results + " instead of correct.", "Keep Playing!", results);
    }

    /**
     * Test for guess
     *
     * @throws Exception
     */
    @Test
    public void testGuess3() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        game.play("1234");
        String results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);

        game.reset();
        results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Play!", results);

        //Should be default
        game.play("9876");
        results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);

        game.play("1234");
        results = game.getPlayerAStatus();
        assertEquals("Results is " + results + " instead of correct.", "Keep Playing!", results);
    }

    /**
     * Test for reset
     *
     * @throws Exception
     */
    @Test
    public void testReset() throws Exception {
        //Create new game
        Game game = new Game();

        //Should be default
        game.play("1234");
        String results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);

        game.reset();
        results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Play!", results);

        game.play("1234");
        results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Guess!", results);

        game.reset();
        results = game.getReady();
        assertEquals("Results is " + results + " instead of correct.", "Play!", results);
    }
}

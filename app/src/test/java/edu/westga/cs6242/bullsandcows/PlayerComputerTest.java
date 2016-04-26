package edu.westga.cs6242.bullsandcows;

import org.junit.Test;

import edu.westga.cs6242.bullsandcows.Model.PlayerComputer;
import edu.westga.cs6242.bullsandcows.Model.Valid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PlayerComputerTest {
    /**
     * Test for initial creation
     * getPosition(), should be 1
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetPosition() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Position should be default
        int position = computer.getPosition();
        assertEquals("Position is " + position + " instead of 1.", 1, position, 0);
    }

    /**
     * Test for initial creation
     * getMyTurn(), should be false
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetMyTurn() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //MyTurn should be default
        boolean turn = computer.getIsMyTurn();
        assertFalse("My turn is " + turn + " instead of false.", turn);
    }

    /**
     * Test for initial creation
     * getNumber(), should be ""
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetNumber() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Number should be default
        String number = computer.getNumber();
        assertEquals("Number is " + number + " instead of blank.", "", number);
    }

    /**
     * setPosition(), should be 2
     *
     * @throws Exception
     */
    @Test
    public void testSetPosition() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Position should change to 2
        computer.setPosition(2);
        int position = computer.getPosition();
        assertEquals("Position is " + position + " instead of 2.", 2, position, 0);
    }

    /**
     * setMyTurn(), should be true
     *
     * @throws Exception
     */
    @Test
    public void testSetMyTurn() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //MyTurn should change to True
        computer.setIsMyTurn(true);
        boolean turn = computer.getIsMyTurn();
        assertTrue("My turn is " + turn + " instead of true.", turn);
    }

    /**
     * getNumber(), should be "1234"
     *
     * @throws Exception
     */
    @Test
    public void testSetNumber() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Number should change to 1234
        computer.setNumber("1234");
        String number = computer.getNumber();
        assertEquals("Number is " + number + " instead of 1234.", "1234", number);
    }

    /**
     * guessResults(String) and toString()
     * should be,
     * ~ Guess Results ~
     * Number  Bulls   Cows
     * 1234    4       4;
     *
     * @throws Exception
     */
    @Test
    public void testResults() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Correct Results
        String correct = " ~ Guess Results ~ " +
                "Number\tBulls\tCows" +
                "1234\t4\t\t4\n";

        //
        computer.guessResults("1234\t4\t\t4");
        String results = computer.toString();
        assertEquals("Results are not correct", correct, results);
    }

    /**
     * Test for reset
     *
     * @throws Exception
     */
    @Test
    public void testRest1() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Set Player
        computer.setNumber("1234");
        computer.setIsMyTurn(true);

        //Reset
        computer.reset();

        //Position should 2
        int position = computer.getPosition();
        assertEquals("Position is " + position + " instead of 2.", 2, position, 0);

        //MyTurn should be default
        boolean turn = computer.getIsMyTurn();
        assertFalse("My turn is " + turn + " instead of false.", turn);

        //Number should be default
        String number = computer.getNumber();
        assertEquals("Number is " + number + " instead of blank.", "", number);
    }

    /**
     * Test for reset
     *
     * @throws Exception
     */
    @Test
    public void testRest2() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Set Player
        computer.setNumber("1234");
        computer.setIsMyTurn(true);
        computer.setPosition(2);

        //Reset
        computer.reset();

        //Position should 1
        int position = computer.getPosition();
        assertEquals("Position is " + position + " instead of 1.", 1, position, 0);

        //MyTurn should be default
        boolean turn = computer.getIsMyTurn();
        assertFalse("My turn is " + turn + " instead of false.", turn);

        //Number should be default
        String number = computer.getNumber();
        assertEquals("Number is " + number + " instead of blank.", "", number);
    }

    /**
     * Test for play
     *
     * @throws Exception
     */
    @Test
    public void testPlay() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Builds Play
        computer.play("1234");

        //Number should not be default
        String number = computer.getNumber();
        assertNotEquals("Number is " + number + " instead of not blank.", "", number);
    }

    /**
     * Test for guess
     *
     * @throws Exception
     */
    @Test
    public void testGuess() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Builds Play then guess
        computer.play("1234");
        String guess = computer.getGuess();

        //Guess should be valid
        Boolean valid = Valid.Number(guess, 4);
        assertTrue("Number is not valid", valid);
    }
}
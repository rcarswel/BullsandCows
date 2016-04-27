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
     * getResult(), should be No Guess, Yet!
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetResult() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Result should be default
        String result = computer.getResult();
        assertEquals("Result is " + result + " instead of No Guess, Yet!.", "No Guess, Yet!", result);
    }

    /**
     * Test for initial creation
     * getWinner(), should be false
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetWinner() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Result should be default
        Boolean winner = computer.getWinner();
        assertFalse("Winner is " + winner + " instead of false.", winner);
    }

    /**
     * Test for initial creation
     * toString(), should be " ~ Guess Results ~ \n"
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationToString() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Result should be default
        String result = computer.toString();
        assertEquals("Result is " + result + " instead of  ~ Guess Results ~ .", " ~ Guess Results ~ \n", result);
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
     * setWinner(), should be true
     *
     * @throws Exception
     */
    @Test
    public void testSetWinner() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Winner should change to true
        computer.setWinner(true);
        Boolean winner = computer.getWinner();
        assertTrue("Winner is " + winner + " instead of true.", winner);
    }

    /**
     * guessResults(String) and getResult()
     * should be,
     * ~ Guess Results ~
     * 1234    2       2;
     *
     * @throws Exception
     */
    @Test
    public void testResult() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Correct Results
        String correct = "#: 1234\tB: 2\tC: 2";

        //Test
        computer.guessResults("#: 1234\tB: 2\tC: 2");
        String results = computer.getResult();
        assertEquals("Results are not correct", correct, results);
    }


    /**
     * guessResults(String) and toString()
     * should be,
     * ~ Guess Results ~
     * Number  Bulls   Cows
     * 1234    2       2;
     *
     * @throws Exception
     */
    @Test
    public void testResults() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Correct Results
        String correct = " ~ Guess Results ~ \n" +
                "#: 1234\tB: 2\tC: 2\n";

        //Test
        computer.guessResults("#: 1234\tB: 2\tC: 2");
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

        //Reset
        computer.reset();

        //Position should 2
        int position = computer.getPosition();
        assertEquals("Position is " + position + " instead of 2.", 2, position, 0);

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
        computer.setPosition(2);

        //Reset
        computer.reset();

        //Position should 1
        int position = computer.getPosition();
        assertEquals("Position is " + position + " instead of 1.", 1, position, 0);

        //Number should be default
        String number = computer.getNumber();
        assertEquals("Number is " + number + " instead of blank.", "", number);
    }

    /******** Computer Only Test **********/
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

    /**
     * Test for guess again
     *
     * @throws Exception
     */
    @Test
    public void testGuess2() throws Exception {
        //Create new game
        PlayerComputer computer = new PlayerComputer();

        //Builds Play then guess
        computer.play("5432");
        String guessA = computer.getGuess();
        String guessB = computer.getGuess();

        //Guess should be valid "Guess are both " + guessA + "."
        assertNotEquals(guessA, guessB);
    }
}
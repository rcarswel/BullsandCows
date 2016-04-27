package edu.westga.cs6242.bullsandcows;

import org.junit.Test;

import edu.westga.cs6242.bullsandcows.Model.PlayerHuman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PlayerHumanTest {

    /**
     * Test for initial creation
     * getNumber(), should be ""
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetNumber() throws Exception {
        //Create new game
        PlayerHuman human = new PlayerHuman();

        //Number should be default
        String number = human.getNumber();
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
        PlayerHuman human = new PlayerHuman();

        //Position should be default
        int position = human.getPosition();
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
        PlayerHuman human = new PlayerHuman();

        //Result should be default
        String result = human.getResult();
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
        PlayerHuman human = new PlayerHuman();

        //Result should be default
        Boolean winner = human.getWinner();
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
        PlayerHuman human = new PlayerHuman();

        //Result should be default
        String result = human.toString();
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
        PlayerHuman human = new PlayerHuman();

        //Number should change to 1234
        human.setNumber("1234");
        String number = human.getNumber();
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
        PlayerHuman human = new PlayerHuman();

        //Position should change to 2
        human.setPosition(2);
        int position = human.getPosition();
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
        PlayerHuman human = new PlayerHuman();

        //Winner should change to true
        human.setWinner(true);
        Boolean winner = human.getWinner();
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
        PlayerHuman human = new PlayerHuman();

        //Correct Results
        String correct = "#: 1234\tB: 2\tC: 2";

        //Test
        human.guessResults("#: 1234\tB: 2\tC: 2");
        String results = human.getResult();
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
        PlayerHuman human = new PlayerHuman();

        //Correct Results
        String correct = " ~ Guess Results ~ \n" +
                "#: 1234\tB: 2\tC: 2\n";

        //Test
        human.guessResults("#: 1234\tB: 2\tC: 2");
        String results = human.toString();
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
        PlayerHuman human = new PlayerHuman();

        //Set Player
        human.setNumber("1234");

        //Reset
        human.reset();

        //Position should 2
        int position = human.getPosition();
        assertEquals("Position is " + position + " instead of 2.", 2, position, 0);

        //Number should be default
        String number = human.getNumber();
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
        PlayerHuman human = new PlayerHuman();

        //Set Player
        human.setNumber("1234");
        human.setPosition(2);

        //Reset
        human.reset();

        //Position should 1
        int position = human.getPosition();
        assertEquals("Position is " + position + " instead of 1.", 1, position, 0);

        //Number should be default
        String number = human.getNumber();
        assertEquals("Number is " + number + " instead of blank.", "", number);
    }
}
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
     * getMyTurn(), should be false
     *
     * @throws Exception
     */
    @Test
    public void testAtCreationGetMyTurn() throws Exception {
        //Create new game
        PlayerHuman human = new PlayerHuman();

        //MyTurn should be default
        boolean turn = human.getIsMyTurn();
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
        PlayerHuman human = new PlayerHuman();

        //Number should be default
        String number = human.getNumber();
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
        PlayerHuman human = new PlayerHuman();

        //Position should change to 2
        human.setPosition(2);
        int position = human.getPosition();
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
        PlayerHuman human = new PlayerHuman();

        //MyTurn should change to True
        human.setIsMyTurn(true);
        boolean turn = human.getIsMyTurn();
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
        PlayerHuman human = new PlayerHuman();

        //Number should change to 1234
        human.setNumber("1234");
        String number = human.getNumber();
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
        PlayerHuman human = new PlayerHuman();

        //Correct Results
        String correct = " ~ Guess Results ~ " +
                "Number\tBulls\tCows" +
                "1234\t4\t\t4\n";

        //
        human.guessResults("1234\t4\t\t4");
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
        human.setIsMyTurn(true);

        //Reset
        human.reset();

        //Position should 2
        int position = human.getPosition();
        assertEquals("Position is " + position + " instead of 2.", 2, position, 0);

        //MyTurn should be default
        boolean turn = human.getIsMyTurn();
        assertFalse("My turn is " + turn + " instead of false.", turn);

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
        human.setIsMyTurn(true);
        human.setPosition(2);

        //Reset
        human.reset();

        //Position should 1
        int position = human.getPosition();
        assertEquals("Position is " + position + " instead of 1.", 1, position, 0);

        //MyTurn should be default
        boolean turn = human.getIsMyTurn();
        assertFalse("My turn is " + turn + " instead of false.", turn);

        //Number should be default
        String number = human.getNumber();
        assertEquals("Number is " + number + " instead of blank.", "", number);
    }
}
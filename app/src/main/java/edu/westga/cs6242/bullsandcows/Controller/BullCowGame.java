package edu.westga.cs6242.bullsandcows.Controller;

import edu.westga.cs6242.bullsandcows.Model.BullCowRules;
import edu.westga.cs6242.bullsandcows.Model.ComputerPlayer;
import edu.westga.cs6242.bullsandcows.Model.HumanPlayer;
import edu.westga.cs6242.bullsandcows.Model.Player;

/**
 * Created by rcarswel on 4/19/2016. Version 1.
 * Game interactions between players (2) and rules for Bulls and Cows game.
 */
public class BullCowGame {
    private BullCowRules rules;
    private Player playerA;
    private Player playerB;

    /**
     * Constructor
     * Builds rules and two players
     */
    public BullCowGame() {
        this.rules = new BullCowRules();
        // Current 1 Human/ 1 Computer (may update)
        this.playerA = new HumanPlayer();
        this.playerB = new ComputerPlayer();
    }
}

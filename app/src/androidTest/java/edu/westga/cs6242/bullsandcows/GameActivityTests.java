package edu.westga.cs6242.bullsandcows;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class GameActivityTests extends ActivityInstrumentationTestCase2<GameActivity> {
    public GameActivityTests() {
        super(GameActivity.class);
    }

    /**
     * Verifies Existence
     */
    public void testActivityExists() {
        GameActivity activity = getActivity();
        assertNotNull(activity);
    }

    /**
     * Checks initial state
     */
    public void testInitialState() {
        GameActivity activity = getActivity();
        final TextView tvOtherGuess = (TextView) activity.findViewById(R.id.tvOtherGuess);
        final TextView tvPlayerGuess = (TextView) activity.findViewById(R.id.tvPlayerGuess);
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLosser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        //Tap Buttons

    }
}
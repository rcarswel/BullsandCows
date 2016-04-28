package edu.westga.cs6242.bullsandcows;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
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
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLoser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: \nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Play!", btnGuessPlay.getText().toString());

        //Click Reset
        this.buttonClickReset();
        assertEquals("Your #: \nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Play!", btnGuessPlay.getText().toString());
    }

    public void testPlay1234() {
        GameActivity activity = getActivity();
        final TextView tvOtherGuess = (TextView) activity.findViewById(R.id.tvOtherGuess);
        final TextView tvPlayerGuess = (TextView) activity.findViewById(R.id.tvPlayerGuess);
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLoser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("1234");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: 1234\nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Guess!", btnGuessPlay.getText().toString());
    }

    public void testPlay4444() {
        GameActivity activity = getActivity();
        final TextView tvOtherGuess = (TextView) activity.findViewById(R.id.tvOtherGuess);
        final TextView tvPlayerGuess = (TextView) activity.findViewById(R.id.tvPlayerGuess);
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLoser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("4444");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: \nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Play!", btnGuessPlay.getText().toString());
    }

    public void testPlay1234Guess5678() {
        GameActivity activity = getActivity();
        final TextView tvOtherGuess = (TextView) activity.findViewById(R.id.tvOtherGuess);
        final TextView tvPlayerGuess = (TextView) activity.findViewById(R.id.tvPlayerGuess);
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLoser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("1234");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: 1234\nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Guess!", btnGuessPlay.getText().toString());

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("5678");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: 1234\n#: 1234\tB: 4\tC: 0", tvOtherGuess.getText().toString());
        assertNotSame(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Loser!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Play!", btnGuessPlay.getText().toString());
    }

    public void testPlay5678Guess1234() {
        GameActivity activity = getActivity();
        final TextView tvOtherGuess = (TextView) activity.findViewById(R.id.tvOtherGuess);
        final TextView tvPlayerGuess = (TextView) activity.findViewById(R.id.tvPlayerGuess);
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLoser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("5678");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: 5678\nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Guess!", btnGuessPlay.getText().toString());

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("1234");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertNotSame("Your #: 5678\n#: 1234\tB: 4\tC: 0", tvOtherGuess.getText().toString());
        assertNotSame(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Guess!", btnGuessPlay.getText().toString());
    }

    public void testPlay1234Reset() {
        GameActivity activity = getActivity();
        final TextView tvOtherGuess = (TextView) activity.findViewById(R.id.tvOtherGuess);
        final TextView tvPlayerGuess = (TextView) activity.findViewById(R.id.tvPlayerGuess);
        final TextView tvWinnerLoser = (TextView) activity.findViewById(R.id.tvWinnerLoser);
        final EditText etGuessPlay = (EditText) activity.findViewById(R.id.etGuessPlay);
        final Button btnGuessPlay = (Button) activity.findViewById(R.id.btnGuessPlay);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("1234");
            }
        });

        //Click Play
        this.buttonClickPlay();
        assertEquals("Your #: 1234\nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertEquals(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Guess!", btnGuessPlay.getText().toString());

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                etGuessPlay.requestFocus();
                //To increase reliability due to ide delay
                etGuessPlay.setText("1234");
            }
        });

        //Click Play
        this.buttonClickReset();
        assertNotSame("Your #: \nNo Guess, Yet!", tvOtherGuess.getText().toString());
        assertNotSame(" ~ Guess Results ~ \n", tvPlayerGuess.getText().toString());
        assertEquals("Keep Playing!", tvWinnerLoser.getText().toString());
        assertEquals("", etGuessPlay.getText().toString());
        assertEquals("Play!", btnGuessPlay.getText().toString());
    }

    /**********
     * Private
     **********/
    private void buttonClickPlay() {
        GameActivity activity = getActivity();

        Button playButton =
                (Button) activity.findViewById(R.id.btnGuessPlay);
        TouchUtils.clickView(this, playButton);
    }

    private void buttonClickReset() {
        GameActivity activity = getActivity();

        Button resetButton =
                (Button) activity.findViewById(R.id.btnReset);
        TouchUtils.clickView(this, resetButton);
    }

    private void buttonClickQuit() {
        GameActivity activity = getActivity();

        Button quitButton =
                (Button) activity.findViewById(R.id.btnQuit);
        TouchUtils.clickView(this, quitButton);
    }
}
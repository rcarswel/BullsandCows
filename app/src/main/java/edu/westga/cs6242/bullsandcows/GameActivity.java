package edu.westga.cs6242.bullsandcows;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.westga.cs6242.bullsandcows.Controller.Game;

public class GameActivity extends AppCompatActivity {
    private Game game;
    private TextView tvOtherGuess;
    private TextView tvPlayerGuess;
    private TextView tvWinnerLoser;
    private EditText etGuessPlay;
    private Button btnGuessPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Populates Display
        this.game = new Game();
        this.tvOtherGuess = (TextView) findViewById(R.id.tvOtherGuess);
        this.tvPlayerGuess = (TextView) findViewById(R.id.tvPlayerGuess);
        this.tvWinnerLoser = (TextView) findViewById(R.id.tvWinnerLosser);
        this.etGuessPlay = (EditText) findViewById(R.id.etGuessPlay);
        this.btnGuessPlay = (Button) findViewById(R.id.btnGuessPlay);

        //Loads Content
        this.loadContent();
    }

    /**
     * Plays game
     */
    public void click_GuessPlay(View view) {
        String number = this.etGuessPlay.getText().toString();
        try {
            this.game.play(number);
        } catch (IllegalArgumentException iae) {
            makeToast(iae.getMessage());
        }
        this.loadContent();
    }

    /**
     * Resets game
     */
    public void click_Reset(View view) {
        this.game.reset();
        this.loadContent();
    }

    /**
     * Quit game
     */
    public void click_Quit(View view) {
        this.onBackPressed();
    }

    /********* Private Methods **********/
    /**
     * Loads Content to display
     */
    private void loadContent() {
        this.tvOtherGuess.setText(this.game.getPlayerBResult());
        this.tvPlayerGuess.setText(this.game.getPlayerAResults());
        this.tvWinnerLoser.setText(this.game.getPlayerAStatus());
        this.etGuessPlay.setText("");
        this.btnGuessPlay.setText(this.game.getReady());
    }

    /**
     * Making Toast
     */
    private void makeToast(String message) {
        //get custom_toast.xml layout
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        //set message
        TextView text = (TextView) layout.findViewById(R.id.tvToast);
        text.setText(message);

        //create toast
        Toast toast = new Toast(getApplicationContext()); //Creates toast for this activity
        toast.setDuration(Toast.LENGTH_LONG); //Sets the length of time to display
        toast.setGravity(Gravity.CENTER, 0, 0); //Sets display location
        toast.setView(layout);
        toast.show();
    }
}

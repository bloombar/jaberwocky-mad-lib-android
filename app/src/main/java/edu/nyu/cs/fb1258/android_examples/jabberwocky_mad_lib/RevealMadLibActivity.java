package edu.nyu.cs.fb1258.android_examples.jabberwocky_mad_lib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Each activity class represents a single screen in the app.  This activity represents the Controller code for the second screen that appears in this app.  It loads the second screen's View and displays the Mad Lib that the user created in the first screen.  The user can click a button to go back to the first screen and start again.
 * @author Foo Barstein
 * @version 1
 */
public class RevealMadLibActivity extends AppCompatActivity {

    /**
     * This method is automatically called when this screen is loaded.  It gets the Mad Lib text that the user generated on the first screen, and places it into the View for this screen.
     * @param savedInstanceState Any saved state of this screen (we are not using this here)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // do basic activity setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);

        // Get the Intent (transition object) that started this activity
        Intent intent = getIntent();

        // get the completed Mad Lib from this Intent object
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // get access to the TextView where we will display the complete Jabberwocky Mad Lib
        TextView textView = findViewById(R.id.reveal_jabberwocky);
        // put the completed mad lib into this Text View
        textView.setText(message);
    }

    /**
     * This method is automatically called when the user clicks the button on this second screen.  It transitions to the first screen so the user can start the Mad Lib again.
     * @param view The button (Button object) that was clicked. This parameter is not used in this method.
     */
    public void startAgain(View view) {
        // create the transition between screens, called an Intent
        // this will transition between this RevealMadLibActivity, and a new MainActivity
        Intent intent = new Intent(this, MainActivity.class);

        // switch to the next screen, MainActivity
        startActivity(intent);
    }
}

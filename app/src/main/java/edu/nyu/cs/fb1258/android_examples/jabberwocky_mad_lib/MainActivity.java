package edu.nyu.cs.fb1258.android_examples.jabberwocky_mad_lib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Each activity class represents a single screen in the app.  This activity represents the Controller code for the first screen that appears in this app.  It loads the first screen's View, which asks the user to enter a bunch of text inputs, and transitions to a second screen when the user clicks the button in the View.
 * @author Foo Barstein
 * @version 1
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The text of the Mad Lib will be stored as a key/value pair as it is passed from this Activity to the next.  This is the key that will be used.  The value will be the complete Mad Lib text, once we generate that.
     */
    public static final String MESSAGE_KEY = "MAD_LIB";

    /**
     * This method is automatically called when this screen is loaded.
     * @param savedInstanceState Any saved state of this screen (we are not using this here)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // do basic activity setup
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    /**
     * This method is called automatically whenever the user taps into one of the text fields in the View.  This method deletes the default text in that text field.
     * @param view The text field (EditText object) that was clicked.  The EditText class, like all user interface component classes inherits from the View class, so this parameter's type is an example of polymorphism.
     */
    public void clearEditText(View view) {
        // clear the text in whichever EditText user interface component was clicked
        ((EditText) view).setText("");
    }

    /**
     * This method is called automatically whenever the user clicks the button on the View.  This method loads up the text the user has entered into each of the text fields (EditText objects) and generates the Mad Lib.  This Mad Lib is then passed to the second activity which apperas.
     * @param view The button (Button object) that was clicked.. This parameter is not used in this method.
     */
    public void submitText(View view) {
        // get access to each of the EditText input fields by their IDs
        EditText nounSingular1 = (EditText) findViewById(R.id.main_n1_input);
        EditText nounPlural1 = (EditText) findViewById(R.id.main_np1_input);
        EditText nounPlural2 = (EditText) findViewById(R.id.main_np2_input);
        EditText adjective1 = (EditText) findViewById(R.id.main_a1_input);
        EditText verb1 = (EditText) findViewById(R.id.main_v1_input);

        // get all the text the user typed into these inputs
        String n1 = nounSingular1.getText().toString();
        String np1 = nounPlural1.getText().toString();
        String np2 = nounPlural2.getText().toString();
        String a1 = adjective1.getText().toString();
        String v1 = verb1.getText().toString();

        // put together the completed jabberwocky mad lib
        String message = getString(R.string.reveal_jabberwocky_text); // get the Jabberwocky template from the strings.xml file
        message = message.replace("{n1}", n1);
        message = message.replace("{np1}", np1);
        message = message.replace("{np2}", np2);
        message = message.replace("{a1}", a1);
        message = message.replace("{v1}", v1);

        // debugging
        System.out.println(message);

        // create the Intent (a transition object) between screens.
        // this will transition between this MainActivity, and a new RevealMessageActivity
        Intent intent = new Intent(this, RevealMadLibActivity.class);

        // make the compelted mad lib text is available to the next screen by storing it as a message
        intent.putExtra(MESSAGE_KEY, message);

        // switch to the next screen, RevealMadLibActivity
        startActivity(intent);

    }
}

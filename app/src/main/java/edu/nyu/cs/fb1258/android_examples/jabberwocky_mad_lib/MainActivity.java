package edu.nyu.cs.fb1258.android_examples.jabberwocky_mad_lib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "edu.nyu.cs.fb1258.android_examples.jabberwocky_mad_lib.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // do basic activity setup
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    public void clearEditText(View view) {
        // clear the text in whichever component was clicked
        ((EditText) view).setText("");
    }

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

        // create the transition between screens, called an Intent
        // this will transition between this MainActivity, and a new RevealMessageActivity
        Intent intent = new Intent(this, RevealMadLibActivity.class);

        // make the compelted mad lib text is available to the next screen by storing it as a message
        intent.putExtra(EXTRA_MESSAGE, message);

        // switch to the next screen, RevealMadLibActivity
        startActivity(intent);

    }
}

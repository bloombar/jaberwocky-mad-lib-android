package edu.nyu.cs.fb1258.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RevealMadLibActivity extends AppCompatActivity {

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

    public void startAgain(View view) {
        // create the transition between screens, called an Intent
        // this will transition between this RevealMadLibActivity, and a new MainActivity
        Intent intent = new Intent(this, MainActivity.class);

        // switch to the next screen, MainActivity
        startActivity(intent);
    }
}

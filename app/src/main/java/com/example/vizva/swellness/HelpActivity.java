package com.example.vizva.swellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView menuPageTextView = (TextView) findViewById(R.id.helpTextView);
        menuPageTextView.setText("You are on the help page which is under construction");
    }
}

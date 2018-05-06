package com.example.vizva.swellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView menuPageTextView = (TextView) findViewById(R.id.profTextView);
        menuPageTextView.setText("You are on the profile page which is under construction");
    }


}

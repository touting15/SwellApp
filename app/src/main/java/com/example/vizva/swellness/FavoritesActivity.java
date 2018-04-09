package com.example.vizva.swellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        TextView menuPageTextView = (TextView) findViewById(R.id.favTextView);
        menuPageTextView.setText("You are on the favorites page which is under construction");
    }
}

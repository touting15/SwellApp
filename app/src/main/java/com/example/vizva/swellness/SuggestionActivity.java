package com.example.vizva.swellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class SuggestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        TextView textView = (TextView) findViewById(R.id.suggestion_page_title);

        getIncomingIntent();
    }
    //Clickable cards.  Corresponds to RVAdapter
    private void getIncomingIntent(){
        if(getIntent().hasExtra("title") && getIntent().hasExtra("image")){

            String suggestion_title = getIntent().getStringExtra("title");
            TextView t = findViewById(R.id.suggestion_page_title);
            t.setText(suggestion_title);

            int suggestion_image = getIntent().getIntExtra("image", 0); //don't know what default value is
           // String suggestion_image = getIntent().getStringExtra("image");
            ImageView i = findViewById(R.id.suggestion_page_image);
            i.setImageResource(suggestion_image);

        }
    }
}

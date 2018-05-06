package com.example.vizva.swellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class SuggestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItem:
                Intent intent=new Intent(SuggestionActivity.this, MenuActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

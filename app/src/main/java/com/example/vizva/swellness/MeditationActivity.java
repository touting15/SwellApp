package com.example.vizva.swellness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MeditationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        //Simple text
        TextView textView = (TextView) findViewById(R.id.meditation_title);
        textView.setText("Meditation Page");

        //input screenshot of diet page
         ImageView imageView = (ImageView) findViewById(R.id.meditation_image);
         imageView.setImageResource(R.drawable.ic_swellness);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //this shows the meditation icon correctly
        bottomNavigationView.setItemIconTintList(null);
//sets the meditation icon
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.fitness:
                        Intent intent = new Intent(MeditationActivity.this, FitnessActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.meditation:

                        break;

                    case R.id.menu_home:
                        Intent intent1 = new Intent(MeditationActivity.this, MainpageActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.diet:
                        Intent intent2 = new Intent(MeditationActivity.this, DietActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.sleep:
                        Intent intent3 = new Intent(MeditationActivity.this, SleepActivity.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });
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
                Intent intent=new Intent(MeditationActivity.this, MenuActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.vizva.swellness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SleepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        //Simple text
        TextView title = (TextView) findViewById(R.id.sleep_title);
        title.setText("Sleep Page");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//Sets sleep icon to selected
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.fitness:
                        Intent intent = new Intent(SleepActivity.this, FitnessActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.meditation:
                        Intent intent1 = new Intent(SleepActivity.this, MeditationActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.menu_home:
                        Intent intent3 = new Intent(SleepActivity.this, MainpageActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.diet:
                        Intent intent2 = new Intent(SleepActivity.this, DietActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.sleep:

                        break;

                }
                return false;
            }
        });
    }
}

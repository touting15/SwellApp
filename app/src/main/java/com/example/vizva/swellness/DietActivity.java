package com.example.vizva.swellness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
//simple text
        TextView textView = (TextView) findViewById(R.id.diet_title);
        textView.setText("Diet Page");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//Sets the diet icon to selected
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.fitness:
                        Intent intent = new Intent(DietActivity.this, FitnessActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.meditation:
                        Intent intent1 = new Intent(DietActivity.this, MeditationActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.menu_home:
                        Intent intent2 = new Intent(DietActivity.this, MainpageActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.diet:

                        break;
                    case R.id.sleep:
                        Intent intent3 = new Intent(DietActivity.this, SleepActivity.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });
    }
}

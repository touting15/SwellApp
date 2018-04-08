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

public class FitnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        TextView textView = (TextView) findViewById(R.id.fitness_title);
        textView.setText("Fitness Page");
//insert fitness page here
        ImageView imageView = (ImageView) findViewById(R.id.fitness_image);
        imageView.setImageResource(R.drawable.ic_swellness);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//sets the fitness icon to selected
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.fitness:
                        break;
                    case R.id.meditation:
                        Intent intent1 = new Intent(FitnessActivity.this, MeditationActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.menu_home:
                        Intent intent = new Intent(FitnessActivity.this, MainpageActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.diet:
                        Intent intent2 = new Intent(FitnessActivity.this, DietActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.sleep:
                        Intent intent3 = new Intent(FitnessActivity.this, SleepActivity.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });
    }
}

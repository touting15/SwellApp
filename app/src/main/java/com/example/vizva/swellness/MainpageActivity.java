package com.example.vizva.swellness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
//Creates the suggestions to be made into cards.  Change the dumbbell images
        List<Suggestion> suggestions = new ArrayList<>();
        suggestions.add(new Suggestion("It's Beautiful... Let's Go For a Run", "Learn more about the benefits of cardio", R.drawable.ic_lock));
        suggestions.add(new Suggestion("Stay Hydrated", "It's easy to forget to drink enough water", R.drawable.ic_lock));
        suggestions.add(new Suggestion("Let's Check out the Carnival Today", "This event is happening near you. Hooray!", R.drawable.ic_lock));
        suggestions.add(new Suggestion("You Miss 100% of the Shots You Don't Take", "Some insipration", R.drawable.ic_lock));
        suggestions.add(new Suggestion("Here's a Playlist to Help you Chill Out", "Stress affects your mood, sleep, and overall well-being.  Listening to music can help reduce stress.", R.drawable.ic_lock));
        suggestions.add(new Suggestion("How are you sleeping?", "Losing even a little bit of sleep can be detrimental to your health.  Check out these relaxing tips to help you snooze.", R.drawable.ic_lock));

        RVAdapter adapter = new RVAdapter(this, suggestions);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //sets the home icon to selected
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.fitness:
                        Intent intent = new Intent(MainpageActivity.this, FitnessActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.meditation:
                        Intent intent1 = new Intent(MainpageActivity.this, MeditationActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.menu_home:

                        break;
                    case R.id.diet:
                        Intent intent2 = new Intent(MainpageActivity.this, DietActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.sleep:
                        Intent intent3 = new Intent(MainpageActivity.this, SleepActivity.class);
                        startActivity(intent3);
                        break;

                }
                return false;
            }
        });
//make cards clickables
        getIncomingIntent();

    }

    //Clickable cards, corresponds to RVAdapter intentExtra
    private void getIncomingIntent(){
        if(getIntent().hasExtra("suggestion")){
            String suggestion_title = getIntent().getStringExtra("suggestion");
            // TextView textview = findViewById(R.id.suggestion_page);
            // textView.setText(suggestion_title)
            //
            //
        }
    }
}

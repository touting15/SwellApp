package com.example.vizva.swellness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
//Creates the suggestions to be made into cards.  Change the dumbbell images
        List<Suggestion> suggestions = new ArrayList<>();
        suggestions.add(new Suggestion("It's Beautiful... Let's Go For a Run", "Learn more about the benefits of cardio", R.drawable.sun, "10"));
        suggestions.add(new Suggestion("Stay Hydrated", "It's easy to forget to drink enough water", R.drawable.waterbottle, "2"));
        suggestions.add(new Suggestion("Check out the Carnival Today", "It's happening near you. Hooray!", R.drawable.upcoming_event, "5"));
        suggestions.add(new Suggestion("You Miss 100% of the Shots You Don't Take", "Some insipration", R.drawable.basketball, "You do you"));
        suggestions.add(new Suggestion("Here's a Chill playlist", "Listening to music can help reduce stress.", R.drawable.play, "2"));
        suggestions.add(new Suggestion("How are you sleeping?", "Check out these relaxing tips to help you snooze.", R.drawable.snooze, "5"));
        suggestions.add(new Suggestion("Are you feeling pumped?", "Try taking the stairs today. Take little steps to reach your goal", R.drawable.stairs, "5"));
        suggestions.add(new Suggestion("5K this weekend?", "You can be active, be social, and help a cause.", R.drawable.shoes, "20"));
        suggestions.add(new Suggestion("New Exercise Alert!", "No equipment or weight needed. See for yourself. ", R.drawable.arm, "5"));
        suggestions.add(new Suggestion("Tried yoga? It's pretty cool.", "Awesome for your muscles and mind.", R.drawable.yoga, "5"));
       // suggestions.add(new Suggestion("You have been sitting for a long while.", "Take some breaks and stretch your legs", R.drawable.walk, "5"));

        RVAdapter adapter = new RVAdapter(this, suggestions);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //this shows the meditation icon correctly
        bottomNavigationView.setItemIconTintList(null);

        //sets the home icon to selected
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
                Intent intent=new Intent(MainpageActivity.this, MenuActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

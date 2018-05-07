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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        List<Suggestion> suggestions = new ArrayList<>();
        suggestions.add(new Suggestion("Get energized with some protein!", "Have some protein-packed snacks.", R.drawable.shoes, "10"));
        suggestions.add(new Suggestion("Stay Hydrated", "It's easy to forget to drink enough water", R.drawable.waterbottle, "2"));
        suggestions.add(new Suggestion("Farmer's Market Today", "There will be some yummy local food", R.drawable.upcoming_event, "5"));
        suggestions.add(new Suggestion("An apple a day keeps the doctor away", "Some insipration", R.drawable.basketball, "You do you"));
        suggestions.add(new Suggestion("Swap in some healthy foods", "Fruit for dessert", R.drawable.play, "2"));
        suggestions.add(new Suggestion("Under the weather?", "Try some vitamin C", R.drawable.snooze, "5"));

        RVAdapter adapter = new RVAdapter(this, suggestions);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //this shows the meditation icon correctly
        bottomNavigationView.setItemIconTintList(null);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItem:
                Intent intent=new Intent(DietActivity.this, MenuActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

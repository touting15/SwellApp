package com.example.vizva.swellness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        RVAdapter adapter = new RVAdapter(suggestions);
        recyclerView.setAdapter(adapter);

    }
}

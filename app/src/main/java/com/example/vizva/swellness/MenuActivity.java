package com.example.vizva.swellness;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    protected Button menuProfButton;
    protected Button menuFavButton;
    protected Button menuSettingsButton;
    protected Button menuHelpButton;
    protected Button menuContactUsButton;
    protected Button menuLogoutButton;

    //To create button and corresponding activity
    protected void initButtons() {
        menuProfButton = (Button) findViewById(R.id.menuProfButItem);
        menuProfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profIntent = new Intent(MenuActivity.this,ProfileActivity.class);
                startActivity(profIntent);
            }
        });

        menuFavButton = (Button) findViewById(R.id.menuFavButItem);
        menuFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favIntent = new Intent(MenuActivity.this,FavoritesActivity.class);
                startActivity(favIntent);
            }
        });

        menuSettingsButton = (Button) findViewById(R.id.menuSetButItem);
        menuSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setIntent = new Intent(MenuActivity.this,SettingActivity.class);
                startActivity(setIntent);
            }
        });

        menuHelpButton = (Button) findViewById(R.id.menuHelpButItem);
        menuHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent = new Intent(MenuActivity.this,HelpActivity.class);
                startActivity(helpIntent);
            }
        });

        menuContactUsButton = (Button) findViewById(R.id.menuContButItem);
        menuContactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactIntent = new Intent(MenuActivity.this,ContactActivity.class);
                startActivity(contactIntent);
            }
        });

        menuLogoutButton = (Button) findViewById(R.id.menuLogButItem);
        menuLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(logoutIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Calls above function
        initButtons();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

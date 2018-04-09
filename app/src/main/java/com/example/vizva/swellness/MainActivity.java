package com.example.vizva.swellness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected AutoCompleteTextView userTextView;
    protected AutoCompleteTextView passwordTextView;
    protected Button loginBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userTextView = (AutoCompleteTextView) findViewById(R.id.userName);
        passwordTextView = (AutoCompleteTextView) findViewById(R.id.userPassword);
        loginBut = (Button) findViewById(R.id.reg);

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validatePassword(userTextView.getText().toString(), passwordTextView.getText().toString());
            }
        });

    }

    private void validatePassword(String username, String password) {
        if((username.equals("cmsc434")) && (password.equals("test"))) {
            Intent intent = new Intent(MainActivity.this, MainpageActivity.class);
            startActivity(intent);
        }

    }
}

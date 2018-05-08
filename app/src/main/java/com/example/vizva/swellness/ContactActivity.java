package com.example.vizva.swellness;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class ContactActivity extends AppCompatActivity {

    protected EditText nameTextView;
    protected EditText emailTextView;
    protected EditText fbTextView;
    protected Button submitBut;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        nameTextView = (EditText) findViewById(R.id.contNameTextView);
        emailTextView = (EditText) findViewById(R.id.contMailTextView);
        fbTextView = (EditText) findViewById(R.id.contFbTextView);
        submitBut = (Button) findViewById(R.id.contSubmitBut);
        context = this;

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((nameTextView.getText().toString().trim().length() == 0) ||
                        (emailTextView.getText().toString().trim().length() == 0) ||
                        (fbTextView.getText().toString().trim().length() == 0)) {

                    Toast.makeText(context,"One of the fields is missing!", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    alertDialogBuilder.setTitle("Confirm");
                    alertDialogBuilder.setMessage("To send the feedback tap send otherwise cancel");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("Send",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    nameTextView.setText("");
                                    emailTextView.setText("");
                                    fbTextView.setText("");
                                    Toast.makeText(getApplicationContext(),"Your feedback was sent. Thank you!", Toast.LENGTH_SHORT).show();
                                }
                            });
                    alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });

    }
}

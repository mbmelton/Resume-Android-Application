package com.example.android.get2knowme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class EducationPage extends AppCompatActivity {


    //Takes the current state off the application as a parameter
    //Creates the education page of the application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_page); //sets the layout of the page
        Toolbar toolbar = findViewById(R.id.toolbar); //displays the top bar
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab); //creates the floating search button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Redirects the page to the UW homepage in a google search
                Intent navigate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.washington.edu/"));
                startActivity(navigate);
            }
        });
    }

}

package com.example.android.get2knowme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    //Pre: accepts the current view as a parameter
    //Post: Sets email conditions and navigates
    //      to the phones email app in a new email
    //      view with recipient, subject, and body filled
    //      with provided text
    public void sendToContact(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "mcmelton@comcast.net" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contact From Resume");
        intent.putExtra(Intent.EXTRA_TEXT, "mail body");
        startActivity(Intent.createChooser(intent, ""));
    }

    //Pre: accepts the current view as a parameter
    //Post: navigates to the Education page
    public void sendToEducation(View view) {
        Intent educationPage = new Intent(this, EducationPage.class);
        startActivity(educationPage);
    }


    //creates an ImageView to access the profile picture
    ImageView image;
    //contains all of the profile pictures
    public Integer[] photos = {
            R.drawable.profile,
            R.drawable.profile2,
            R.drawable.profile3,
            R.drawable.profile4,
            R.drawable.profile5
    };

    //Pre: Accepts the current view as a parameter
    //Post: randomly selects one of the profile pictures and
    //      sets the image to be that picture
    public void shufflePhotos(View view) {
        image = (ImageView) findViewById(R.id.profilePic);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int pick = r.nextInt(5);
                image.setImageResource(photos[pick]);
            }
        });



    }

    public void sendToWorkPage(View view) {
        Intent workPage = new Intent(this, WorkPage.class);
        startActivity(workPage);
    }

    public void sendToPhotoGallery(View view) {
        Intent photoPage = new Intent(this, PhotoPage.class);
        startActivity(photoPage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

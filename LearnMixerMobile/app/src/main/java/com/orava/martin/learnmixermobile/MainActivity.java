package com.orava.martin.learnmixermobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;


import android.net.Uri;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinerfor subject
        Spinner dropdownSubject = (Spinner)findViewById(R.id.spinnerSubject);
        String[] itemsSubject = new String[]{"Choose subject", "Biographh", "Phyzic", "Mathematic"};
        ArrayAdapter<String> adapterSubject = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsSubject);
        dropdownSubject.setAdapter(adapterSubject);

        //Spinerfor licence
        Spinner dropdownLicence = (Spinner)findViewById(R.id.spinnerLicence);
        String[] itemsLicence = new String[]{"All right reserved", "Attribution alone", "Attribution + ShareAlike", "Attribution + NonComercial"};
        ArrayAdapter<String> adapterLicence = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsLicence);
        dropdownLicence.setAdapter(adapterLicence);

        //Spiner for Level
        Spinner dropdownLevel = (Spinner)findViewById(R.id.spinnerLevel);
        String[] itemsLevel = new String[]{"Reaction", "Interaction", "Expasion", "Remixin"};
        ArrayAdapter<String> adapterLevel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsLevel);
        dropdownLevel.setAdapter(adapterLevel);



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

    public void showHistory(View view) {

        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    public void showChapterOne(View view) {

        Intent intent = new Intent(this, ChapterOneActivity.class);
        startActivity(intent);
    }

    public void showLearningSource(View view) {

        Intent intent = new Intent(this, LearningResouceActivity.class);
        startActivity(intent);
    }

    public void showShare(View view) {

        Intent intent = new Intent(this, ShareActivity.class);
        startActivity(intent);
    }

    public void showHistory2(View view) {

        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }





    }





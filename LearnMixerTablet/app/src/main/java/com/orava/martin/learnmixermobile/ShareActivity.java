package com.orava.martin.learnmixermobile;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ShareActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        //Create spiner for class
        Spinner dropdownClass = (Spinner)findViewById(R.id.spinnerClass);
        String[] itemsClass = new String[]{"Class 8", "Class 10", "Class 13"};
        ArrayAdapter<String> adapterClass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsClass);
        dropdownClass.setAdapter(adapterClass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
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

    public void showMainPage(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}

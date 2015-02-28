package com.example.martin.learning;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends ActionBarActivity {

    //public final static String EXTRA_NAME = "com.example.martin.learning.MESSAGE";
    public final static String EXTRA_NAME = "a";
    public final static String EXTRA_LIKE = "b";
    public final static String EXTRA_DISLIKE = "c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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

    /**
     * This method open new screen
     * @param view
     */
    public void sendMessage(View view){

        Intent intent = new Intent(this,TestActivity.class);


        EditText edName = (EditText) findViewById(R.id.edName);
        String name = edName.getText().toString();
        intent.putExtra(EXTRA_NAME,name);

        EditText edLike = (EditText) findViewById(R.id.edLike);
        String like = edLike.getText().toString();
        intent.putExtra(EXTRA_LIKE,like);

        EditText edDislike = (EditText) findViewById(R.id.edDislike);
        String dislike = edDislike.getText().toString();
        intent.putExtra(EXTRA_DISLIKE,dislike);


        startActivity(intent);

    }


}//Class myActivity

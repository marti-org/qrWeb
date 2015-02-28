package com.example.martin.learning;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class TestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MyActivity.EXTRA_NAME);

        TextView txvName = (TextView) findViewById(R.id.txvHellou);
        String helloMsg = "Hello " + name;
        txvName.setText(helloMsg);


        String like = intent.getStringExtra(MyActivity.EXTRA_LIKE);
        String dislike = intent.getStringExtra(MyActivity.EXTRA_DISLIKE);

        TextView txvMessage = (TextView) findViewById(R.id.txvMessage);
        String message = "I see that you like "+like+" and you don't like "+dislike;
        txvMessage.setText(message);

    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }
    */

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

    public void goBack(View view){
        Intent intent = new Intent(this,MyActivity.class);
        startActivity(intent);
    }
}

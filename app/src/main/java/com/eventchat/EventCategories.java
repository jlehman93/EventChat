package com.eventchat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class EventCategories extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_categories);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_categories, menu);
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

    public void go(int category) {
        Intent returnIntent = new Intent(this,MainActivity.class);
        returnIntent.putExtra("category", category);
        startActivity(returnIntent);
    }

    public void gogeneral(View V) {
        go(0);
    }
    public void gomusic(View V) {
        go(1);
    }
    public void gosports(View V) {
        go(2);
    }
    public void goparties(View V) {
        go(3);
    }
    public void gocompetitions(View V) {
        go(4);
    }
    public void gorecreation(View V) {
        go(5);
    }
    public void goholidays(View V) {
        go(6);
    }
    public void gohappyhour(View V) {
        go(7);
    }
    public void goart(View V) {
        go(8);
    }
    public void goeducation(View V) {
        go(9);
    }
    public void goflashmobs(View V) {
        go(10);
    }
    public void gomisc(View V) {
        go(11);
    }
}

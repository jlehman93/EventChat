package com.eventchat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    ListView eventListView;
    ArrayList<String> eventList;
    ArrayAdapter<String> aa; //for events list
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventListView = (ListView)findViewById(R.id.listItems);
        eventList = new ArrayList<String>();
        //in reality, get this stuff via web request
        eventList.add("Jazz Concert\nBo Diddley - 8PM");
        eventList.add("Florida Gators\nOConnel Center - 9PM");
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,eventList);
        eventListView.setAdapter(aa);
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();



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



    public void showEventCategories(View v) {
        Log.v("TEST", "put popup here");
        //may use dialog, but may quit and use intents
    }

    public void makeEvent(View v) {
        Log.v("TEST","go to create event");
        Intent makeIntent = new Intent(this,CreateEvent.class);
        startActivity(makeIntent);

    }
}

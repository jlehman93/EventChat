package com.eventchat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ListView eventListView;
    ArrayList<String> eventList;
    ArrayList<String> categoryList;
    ArrayList<String> descList;
    ArrayAdapter<String> aa; //for events list
    final Context context = this;
    int eventInt = -1;
    String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventListView = (ListView)findViewById(R.id.listItems);
        eventList = new ArrayList<String>();
        descList = new ArrayList<String>();
        //in reality, get this stuff via web request
        ParseQuery<ParseObject> query = ParseQuery.getQuery("eventObject");
        //query.whereEqualTo("category", 0); //get things from a specific category
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> returnedEventList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + returnedEventList.size() + " scores");
                    for(int k=0;k<returnedEventList.size();k++)
                    {
                        Log.v("TEST",returnedEventList.get(k).getString("name"));
                        Log.v("TEST",returnedEventList.get(k).getString("location"));
                        descList.add(returnedEventList.get(k).getString("description"));
                        eventList.add(returnedEventList.get(k).getString("name")+"\n"+returnedEventList.get(k).getString("location")+" - ");
                    }
                    //List<String> newEventList = databaseHandler.getItems();
                    //aa.clear();
                    //aa.addAll(eventList);
                    //aa.notifyDataSetChanged();
                    //aa = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,eventList);
                    //eventListView.setAdapter(aa);

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

        try{
            Thread.sleep(3000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        eventList.add("Jazz Concert\nBo Diddley - 8PM");
        descList.add("jazz description");
        eventList.add("Florida Gators\nOConnel Center - 9PM");
        descList.add("yay gators");
        Log.v("TEST","in array");
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,eventList);
        eventListView.setAdapter(aa);
        categoryList = new ArrayList<String>(Arrays.asList("General", "Live Music", "Sports"));

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Log.v("TEST","a"+position);
                Intent eventIntent = new Intent(context,EventPage.class);
                //Bundle extras = new Bundle();
                //extras.putString("Name",eventList.get(position));
                //extras.putString("Description",descList.get(position));
                //eventIntent.putExtra("Name",eventList.get(position));
                Log.v("TEST","trying to put");
                eventIntent.putExtra("Stuff",eventList.get(position)+"&"+descList.get(position));
                Log.v("TEST","putting");
                //eventIntent.putExtras(extras);
                startActivity(eventIntent);

            }
        });

        /**
        JSONArray myArray = new JSONArray();
        ParseObject testObject = new ParseObject("TestObject");
        myArray.put("one");
        myArray.put("two");
        myArray.put("three");
        byte[] myData = { 4, 8, 16, 32 };
        testObject.put("foo",myData);
        testObject.saveInBackground();
         */




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


    public void onClick(View v) {
        //trying to handle clicking on list
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                eventInt = position;
                Log.v("TEST",""+eventInt);
            }
        });
    }


    public void showEventCategories(View v) {
        Intent makeIntent = new Intent(this,EventCategories.class);
        startActivity(makeIntent);

        //may use dialog, but may quit and use intents
    }

    public void makeEvent(View v) {
        //if user does not exist
        //Intent signupIntent = new Intent(this,signup.class);
        //startActivity(signupIntent);
        Log.v("TEST","go to create event");
        Intent makeIntent = new Intent(this,CreateEvent.class);
        makeIntent.putStringArrayListExtra("categories",categoryList);
        startActivity(makeIntent);

    }


}

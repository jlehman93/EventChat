package com.eventchat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class EventPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
<<<<<<< HEAD
        Log.v("TESTEP","in EP");
        Intent i = getIntent();
        String contents = i.getStringExtra("Stuff");
        objName = contents.substring(0,contents.indexOf("\n"));
        contents = contents.substring(contents.indexOf("\n")+1);
        objLoc = contents.substring(0,contents.indexOf(" - "));
        objDesc=contents.substring(contents.indexOf("&")+1);
        Log.v("TESTEP",objName);
        Log.v("TESTEP",objDesc);
        Log.v("TESTEP",objLoc);
        /**
        Intent i = getIntent();
        String contents = i.getStringExtra("Name");
        Log.v("TEST",contents);
        String description = i.getStringExtra("Description");
        Log.v("TEST",description);
        String objName = contents.substring(0,contents.indexOf("\n"));
        contents = contents.substring(contents.indexOf("\n"));
        String objLoc = contents.substring(2,contents.indexOf(" - "));
        String objDesc = description;
         */
        //Log.v("TEST", name);

        Log.v("TEST","done sleeping");
        nameView = (TextView)findViewById(R.id.name);
        //categoryView = (TextView)findViewById(R.id.categories);
        descriptionView = (TextView)findViewById(R.id.description);
        locationView = (TextView)findViewById(R.id.loc);

        nameView.setText(objName);
        //categoryView.setText(objCat);
        descriptionView.setText(objDesc);
        locationView.setText(objLoc);


=======
>>>>>>> parent of ef82fb7... trying to event page
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_page, menu);
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

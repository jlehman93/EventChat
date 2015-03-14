package com.eventchat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class EventPage extends ActionBarActivity {

    TextView nameView;
    TextView categoryView;
    TextView descriptionView;
    TextView locationView;
    TextView timeView;
    String objName;
    int objCat;
    String objDesc;
    String objLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
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


    }

    String getCategory(int cat) {
        if(cat==0) {
            return "General";
        } else if(cat==1) {
            return "Music";
        } else if(cat==2) {
            return "Sports";
        } else if(cat==3) {
            return "Parties";
        } else if(cat==4) {
            return "Competitions";
        } else if(cat==5) {
            return "Recreation";
        } else if(cat==6) {
            return "Holidays";
        } else if(cat==7) {
            return "Happy Hour";
        } else if(cat==8) {
            return "Art";
        } else if(cat==9) {
            return "Education";
        } else if(cat==10) {
            return "Flash Mobs";
        } else {
            return "Miscellaneous";
        }
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

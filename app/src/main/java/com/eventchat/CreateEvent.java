package com.eventchat;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;


public class CreateEvent extends ActionBarActivity implements TimePickerDialog.OnTimeSetListener, AdapterView.OnItemSelectedListener {

    Button timeButton;
    Spinner spinner;
    ArrayList<String> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        categoryList = i.getStringArrayListExtra("categories");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        timeButton = (Button)findViewById(R.id.eventTime);
        spinner = (Spinner) findViewById(R.id.categories);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,categoryList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_create_event, menu);
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

    public void showTimePickerDialog(View V) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        Log.v("TEST", "onTimeSetActivity");
        Log.v("TEST",""+view.getId());
        timeButton.setText(hourOfDay + ":" + minute);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Log.v("TEST",""+pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }

    public void makeEvent(View view) {
        //do web request
        Intent returnIntent = new Intent(this,MainActivity.class);
        startActivity(returnIntent);
    }
}

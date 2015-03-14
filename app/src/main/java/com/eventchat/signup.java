package com.eventchat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.parse.ParseObject;


public class signup extends ActionBarActivity {

    EditText email;
    EditText password;
    EditText name;
    Button registerButton;
    Switch toggleSwitch;
    TextView switchStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        registerButton=(Button)findViewById(R.id.register);
        email =(EditText)findViewById(R.id.email);
        password =(EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        switchStatus = (TextView) findViewById(R.id.switchStatus);
        toggleSwitch = (Switch) findViewById(R.id.toggleSwitch);
    }
    public void onCheckedChanged(CompoundButton buttonView,
                                 boolean isChecked) {

        if(isChecked){
            switchStatus.setText("Switch is currently ON");
        }else{
            switchStatus.setText("Switch is currently OFF");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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
    public void registerUser(View view) {
        ParseObject eventObject = new ParseObject("userObject");
        eventObject.put("Email",email.getText().toString());
        eventObject.put("Password", password.getText().toString());
        eventObject.put("Name", name.getText().toString());
        eventObject.saveInBackground();
        Intent returnIntent = new Intent(this,MainActivity.class);
        startActivity(returnIntent);
    }
}

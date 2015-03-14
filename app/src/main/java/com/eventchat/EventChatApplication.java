package com.eventchat;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Jacob on 3/14/2015.
 */
public class EventChatApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "d3G3pXG05HXDLsjvrqnXWLv9Xp8lCxopVrVfUzMW", "byKBcnFCK7Z8Z2g0xQ9uNmUehtudCWcvXm2A7Vdr");
    }
}

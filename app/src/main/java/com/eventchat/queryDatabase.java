package com.eventchat;

import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Jacob on 3/14/2015.
 */
public class queryDatabase {

    public queryDatabase(){

    }

    public void checkEventList(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("eventObject");
    }
}

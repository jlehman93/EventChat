package com.eventchat;

import java.util.ArrayList;

/**
 * Created by Jacob on 3/14/2015.
 */
public class EventCategoriesModel {
    public ArrayList<String> categories = new ArrayList<String>();

    //Constructor that populates the category list.
    EventCategoriesModel(){
        categories.add("General");
        categories.add("Live Music");
        categories.add("Sports");
        categories.add("Competitions");
        categories.add("Recreation");
        categories.add("Happy Hours");
        categories.add("Holiday");
        categories.add("Flash Mobs");
        categories.add("Miscellaneous");
    }

    public ArrayList<String> getCategories(){
        return this.categories;
    }
}

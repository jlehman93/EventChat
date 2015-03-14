package com.eventchat;

import java.util.HashMap;

/**
 * Created by Jacob on 3/14/2015.
 */
public class pictureCategoryModel {
    public HashMap<String, String> categoryPictureMap = new HashMap<>();

    public pictureCategoryModel(){
        categoryPictureMap.put("0", "@mipmap/cat_general.png");
        categoryPictureMap.put("1", "@mipmap/cat_music.png");
        categoryPictureMap.put("2", "@cat_sports.png");
        categoryPictureMap.put("3", "@cat_parties.png");
        categoryPictureMap.put("8", "@mipmap/cat_art.png");
        categoryPictureMap.put("4", "@mipmap/cat_art.png");
        categoryPictureMap.put("9", "@mipmap/cat_education.png");
        categoryPictureMap.put("10" , "@mipmap/cat_flashmobs.png");
        categoryPictureMap.put("7", "@mipmap/cat_happyhour.png");
        categoryPictureMap.put("6", "@mipmap/cat_holidays.png");
        categoryPictureMap.put("11", "@cat_misc.png");
        categoryPictureMap.put("5", "@cat_recreation.png");
    }

    public HashMap getCatPicMap(){
        return this.categoryPictureMap;
    }


}

package com.eventchat;

import java.util.HashMap;

/**
 * Created by Jacob on 3/14/2015.
 */
public class PictureGetter {
    public PictureGetter() {
    }

    ;
    private pictureCategoryModel pcm = new pictureCategoryModel();
    HashMap<String, String> hm = pcm.categoryPictureMap;

    public String getPicture(String str) {
        switch (str) {
            case "0":
                return hm.get("0");
            case "1":
                return hm.get("1");
            case "2":
                return hm.get("2");
            case "3":
                return hm.get("3");
            case "4":
                return hm.get("4");
            case "5":
                return hm.get("5");
            case "6":
                return hm.get("6");
            case "7":
                return hm.get("7");
            case "8":
                return hm.get("8");
            case "9":
                return hm.get("9");
            case "10":
                return hm.get("10");
            case "11":
                return hm.get("11");
            default:
                break;
        }
        return null;
    }
}


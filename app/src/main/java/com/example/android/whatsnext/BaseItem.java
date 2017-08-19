package com.example.android.whatsnext;

/**
 * Created by vishaal on 19/8/17.
 */

public class BaseItem {

    String timeFrom;
    String timeTo;
    String eventName;

    public BaseItem(String timeFrom,String timeTo, String eventName){
        this.timeFrom=timeFrom;
        this.timeTo=timeTo;
        this.eventName=eventName;
    }

}

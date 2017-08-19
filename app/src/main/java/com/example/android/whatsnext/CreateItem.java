package com.example.android.whatsnext;

/**
 * Created by vishaal on 19/8/17.
 */

public class CreateItem
{
    String timeFrom;
    String timeTo;
    String eventName;
    String date;

    public CreateItem(String timeFrom,String timeTo, String eventName, String date){
        this.timeFrom=timeFrom;this.timeTo=timeTo;this.eventName=eventName;this.date=date;
    }
}

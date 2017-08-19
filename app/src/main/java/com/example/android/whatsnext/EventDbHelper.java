package com.example.android.whatsnext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vishaal on 19/8/17.
 */



public class EventDbHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME="eventDb.db";

    private static final int DATABASE_VERSION=1;

    public EventDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        final String CREATE_TABLE;
        CREATE_TABLE="CREATE TABLE "+ EventContract.EventEntry.TABLE_NAME+" ( "
                + EventContract.EventEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EventContract.EventEntry.COLUMN_DAY+" TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMN_EVENT_NAME+" TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMN_TIME_FROM+" TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMN_TIME_TO+" TEXT NOT NULL "
                +");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ EventContract.EventEntry.TABLE_NAME);
        onCreate(db);
    }
}

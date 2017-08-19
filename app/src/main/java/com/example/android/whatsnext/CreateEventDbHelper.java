package com.example.android.whatsnext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vishaal on 19/8/17.
 */

public class CreateEventDbHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME="createeventDb.db";

    private static final int DATABASE_VERSION=1;

    public CreateEventDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        final String CREATE_TABLE;
        CREATE_TABLE="CREATE TABLE "+ CreateEventContract.CreateEventEntry.TABLE_NAME+" ( "
                + CreateEventContract.CreateEventEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CreateEventContract.CreateEventEntry.COLUMN_DATE+" TEXT NOT NULL, "
                + CreateEventContract.CreateEventEntry.COLUMN_EVENT_NAME+" TEXT NOT NULL, "
                + CreateEventContract.CreateEventEntry.COLUMN_TIME_FROM+" TEXT NOT NULL, "
                + CreateEventContract.CreateEventEntry.COLUMN_TIME_TO+" TEXT NOT NULL "
                +");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ CreateEventContract.CreateEventEntry.TABLE_NAME);
        onCreate(db);
    }
}

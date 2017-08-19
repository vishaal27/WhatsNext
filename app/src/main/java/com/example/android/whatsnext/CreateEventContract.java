package com.example.android.whatsnext;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by vishaal on 19/8/17.
 */

public class CreateEventContract
{
    public static final String  AUTHORITY="com.example.android.whatsnext";

    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+AUTHORITY);

    public static final String PATH_EVENT="createevent";

    public static final class CreateEventEntry implements BaseColumns
    {
        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENT).build();

        public static final String TABLE_NAME="createevent";

        public static final String COLUMN_DATE="date";

        public static final String COLUMN_EVENT_NAME="event_name";

        public static final String COLUMN_TIME_FROM="timefrom";

        public static final String COLUMN_TIME_TO="timeto";




    }
}

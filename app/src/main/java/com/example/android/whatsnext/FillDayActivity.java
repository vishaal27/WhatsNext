package com.example.android.whatsnext;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FillDayActivity extends AppCompatActivity
{

    private TextView addToDay;
    private EditText editTextEventName;
    private EditText editTextTimeFrom;
    private EditText editTextTimeTo;
    private Button addButton;
    private Button doneButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_day);

        getSupportActionBar().hide();
        Intent intent=getIntent();
        final String nameDay=intent.getStringExtra("DAY_NAME");

        addToDay=(TextView) findViewById(R.id.addtoDay);
        editTextEventName=(EditText) findViewById(R.id.eventName);
        editTextTimeFrom=(EditText) findViewById(R.id.timeFrom);
        editTextTimeTo=(EditText) findViewById(R.id.timeTo);
        addButton=(Button) findViewById(R.id.buttonAdd);
        doneButton=(Button) findViewById(R.id.buttonDone);



        addToDay.setText("Add to "+nameDay);



        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventNameField = editTextEventName.getText().toString().trim();
                String timeFromField = editTextTimeFrom.getText().toString().trim();
                String timeFromTo = editTextTimeTo.getText().toString().trim();

                if (!eventNameField.equals("") || !timeFromField.equals("") || !timeFromTo.equals("")) {


                    EventDbHelper eventDbHelper = new EventDbHelper(getApplicationContext());
                    SQLiteDatabase database = eventDbHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(EventContract.EventEntry.COLUMN_EVENT_NAME, eventNameField);
                    contentValues.put(EventContract.EventEntry.COLUMN_TIME_FROM, timeFromField);
                    contentValues.put(EventContract.EventEntry.COLUMN_TIME_TO, timeFromTo);
                    contentValues.put(EventContract.EventEntry.COLUMN_DAY, nameDay);


                    long id = database.insert(EventContract.EventEntry.TABLE_NAME, null, contentValues);

                    Log.d("TAG", "added to db " + id + eventNameField + timeFromField + timeFromTo + nameDay);
                    editTextTimeTo.getText().clear();
                    editTextTimeFrom.getText().clear();
                    editTextEventName.getText().clear();
                    database.close();
                    finish();
                }
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventNameField=editTextEventName.getText().toString().trim();
                String timeFromField=editTextTimeFrom.getText().toString().trim();
                String timeFromTo=editTextTimeTo.getText().toString().trim();



                EventDbHelper eventDbHelper= new EventDbHelper(getApplicationContext());
                SQLiteDatabase database= eventDbHelper.getWritableDatabase();
                ContentValues contentValues= new ContentValues();
                contentValues.put(EventContract.EventEntry.COLUMN_EVENT_NAME, eventNameField);
                contentValues.put(EventContract.EventEntry.COLUMN_TIME_FROM, timeFromField);
                contentValues.put(EventContract.EventEntry.COLUMN_TIME_TO, timeFromTo);
                contentValues.put(EventContract.EventEntry.COLUMN_DAY, nameDay);


                long id=database.insert(EventContract.EventEntry.TABLE_NAME, null, contentValues);

                Log.d("TAG", "added to db "+id+eventNameField+timeFromField+timeFromTo+nameDay);
                editTextTimeTo.getText().clear();
                editTextTimeFrom.getText().clear();
                editTextEventName.getText().clear();
                database.close();
            }
        });

    }
}

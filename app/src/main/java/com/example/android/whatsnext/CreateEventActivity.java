package com.example.android.whatsnext;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateEventActivity extends AppCompatActivity {



    private EditText editTextEventName;
    private EditText editTextTimeFrom;
    private EditText editTextTimeTo;
    private EditText editTextDate;
    private Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        editTextEventName=(EditText) findViewById(R.id.eventName1);
        editTextDate=(EditText) findViewById(R.id.dateOfEvent1);
        editTextTimeFrom=(EditText) findViewById(R.id.timeFrom1);
        editTextTimeTo=(EditText) findViewById(R.id.timeTo1);

        addButton=(Button) findViewById(R.id.buttonAdd1);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eventNameField = editTextEventName.getText().toString().trim();
                String timeFromField = editTextTimeFrom.getText().toString().trim();
                String timeFromTo = editTextTimeTo.getText().toString().trim();
                String date = editTextDate.getText().toString().trim();

                if (!eventNameField.equals("") || !timeFromField.equals("") || !timeFromTo.equals("") || !(date.equals(""))) {


                    CreateEventDbHelper eventDbHelper = new CreateEventDbHelper(getApplicationContext());
                    SQLiteDatabase database = eventDbHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(CreateEventContract.CreateEventEntry.COLUMN_EVENT_NAME, eventNameField);
                    contentValues.put(CreateEventContract.CreateEventEntry.COLUMN_TIME_FROM, timeFromField);
                    contentValues.put(CreateEventContract.CreateEventEntry.COLUMN_TIME_TO, timeFromTo);
                    contentValues.put(CreateEventContract.CreateEventEntry.COLUMN_DATE, date);


                    long id = database.insert(CreateEventContract.CreateEventEntry.TABLE_NAME, null, contentValues);

                    Log.d("TAG", "added to db " + id + eventNameField + timeFromField + timeFromTo + date);
                    editTextTimeTo.getText().clear();
                    editTextTimeFrom.getText().clear();
                    editTextEventName.getText().clear();
                    database.close();
                    Toast.makeText(getApplicationContext(), "New Event created.", Toast.LENGTH_SHORT).show();
                    finish();

                }
            }
        });
    }
    }


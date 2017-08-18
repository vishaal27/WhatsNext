package com.example.android.whatsnext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        Intent intent=getIntent();
        String nameDay=intent.getStringExtra("DAY_NAME");

        addToDay=(TextView) findViewById(R.id.addtoDay);
        editTextEventName=(EditText) findViewById(R.id.eventName);
        editTextTimeFrom=(EditText) findViewById(R.id.timeFrom);
        editTextTimeTo=(EditText) findViewById(R.id.timeTo);
        addButton=(Button) findViewById(R.id.buttonAdd);
        doneButton=(Button) findViewById(R.id.buttonDone);

    }
}

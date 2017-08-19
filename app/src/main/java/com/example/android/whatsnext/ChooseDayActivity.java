package com.example.android.whatsnext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseDayActivity extends AppCompatActivity {


    private Button mondayButton;
    private Button tuesdayButton;
    private Button wednesdayButton;
    private Button thursdayButton;
    private Button fridayButton;
    private Button saturdayButton;
    private Button sundayButton;
    private Button buttonShowCreateTimetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_choose_day);

        getSupportActionBar().hide();
        final SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(sharedPreferences.getBoolean("FIRST_TIME",true))
        {
            setContentView(R.layout.activity_choose_day);
            mondayButton=(Button) findViewById(R.id.buttonMonday);
            tuesdayButton=(Button) findViewById(R.id.buttonTuesday);
            wednesdayButton=(Button) findViewById(R.id.buttonWednesday);
            thursdayButton=(Button) findViewById(R.id.buttonThursday);
            fridayButton=(Button) findViewById(R.id.buttonFriday);
            saturdayButton=(Button) findViewById(R.id.buttonSaturday);
            sundayButton=(Button) findViewById(R.id.buttonSunday);

            buttonShowCreateTimetable=(Button) findViewById(R.id.createTimeTable);

            buttonShowCreateTimetable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences.edit().putBoolean("FIRST_TIME", false).apply();
                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            mondayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Monday");
                    startActivity(intent);
                }
            });

            tuesdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Tuesday");
                    startActivity(intent);
                }
            });

            wednesdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Wednesday");
                    startActivity(intent);
                }
            });

            thursdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Thursday");
                    startActivity(intent);
                }
            });

            fridayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Friday");
                    startActivity(intent);
                }
            });

            saturdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Saturday");
                    startActivity(intent);
                }
            });

            sundayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), FillDayActivity.class);
                    intent.putExtra("DAY_NAME", "Sunday");
                    startActivity(intent);
                }
            });


        }
        else
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}

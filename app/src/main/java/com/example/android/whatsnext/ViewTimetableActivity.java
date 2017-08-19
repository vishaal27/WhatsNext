package com.example.android.whatsnext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class ViewTimetableActivity extends AppCompatActivity implements ViewTimetableCustomAdapter.ListItemClickListener {

    private ViewTimetableCustomAdapter mAdapter;
    private RecyclerView mBaseTimetableList;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_timetable);

        getSupportActionBar().hide();


        mBaseTimetableList = (RecyclerView) findViewById(R.id.view_base_timeline);
        layoutManager = new LinearLayoutManager(this);
        mBaseTimetableList.setLayoutManager(layoutManager);

        mBaseTimetableList.setHasFixedSize(true);
        mAdapter=new ViewTimetableCustomAdapter(MainActivity.mondayBaseItems.size()+MainActivity.tuesdayBaseItems.size()+MainActivity.wednesdayBaseItems.size()+MainActivity.thursdayBaseItems.size()+MainActivity.fridayBaseItems.size()+MainActivity.saturdayBaseItems.size()+MainActivity.sundayBaseItems.size(), this);
        //mAdapter= new ViewTimetableCustomAdapter(7, this);
        mBaseTimetableList.setAdapter(mAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), clickedItemIndex+"", Toast.LENGTH_SHORT).show();
    }
}

package com.example.android.whatsnext;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomAdapter.ListItemClickListener, CreatedEventsCustomAdapter.ListItemClickListener
{
    public static List<BaseItem> baseItemList=new ArrayList<BaseItem>();
    public static List<CreateItem> createItemList=new ArrayList<CreateItem>();
    public static List<BaseItem> mondayBaseItems= new ArrayList<BaseItem>();
    public static List<BaseItem> tuesdayBaseItems= new ArrayList<BaseItem>();
    public static List<BaseItem> wednesdayBaseItems= new ArrayList<BaseItem>();
    public static List<BaseItem> thursdayBaseItems= new ArrayList<BaseItem>();
    public static List<BaseItem> fridayBaseItems= new ArrayList<BaseItem>();
    public static List<BaseItem> saturdayBaseItems= new ArrayList<BaseItem>();
    public static List<BaseItem> sundayBaseItems= new ArrayList<BaseItem>();

    private BottomNavigationView bottomNavigationView;

    public static final String ANONYMOUS = "anonymous";
    private static final int RC_SIGN_IN = 1;
    private CustomAdapter mAdapter;
    private RecyclerView mBaseTimetableList;
    private RecyclerView.LayoutManager layoutManager;

    private CreatedEventsCustomAdapter mAdapter1;
    private RecyclerView mCreatedEventsList;
    private RecyclerView.LayoutManager layoutManager1;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.navigation);
        Cursor cursor=(new EventDbHelper(getApplicationContext()).getReadableDatabase().rawQuery("select * from "+ EventContract.EventEntry.TABLE_NAME, null));

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String eventName = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_EVENT_NAME));
                String day1 = cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_DAY));
                String timeFrom=cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_TIME_FROM));
                String timeTo=cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_TIME_TO));

                if(day1.toLowerCase().equals("monday")){
                    mondayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }

                else if(day1.toLowerCase().equals("tuesday")){
                    tuesdayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }

                else  if(day1.toLowerCase().equals("wednesday")){
                    wednesdayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }

                else if(day1.toLowerCase().equals("thursday")){
                    thursdayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }

                else if(day1.toLowerCase().equals("friday")){
                    fridayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }

                else if(day1.toLowerCase().equals("saturday")){
                    saturdayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }
                else if(day1.toLowerCase().equals("sunday")){
                    sundayBaseItems.add(new BaseItem(timeFrom, timeTo, eventName));
                }

                Log.d("TAG", day1+" ,"+eventName+" ,"+timeFrom+" ,"+timeTo);
                cursor.moveToNext();
            }
        }


//        mFirebaseAuth=FirebaseAuth.getInstance();
//        mUsername = ANONYMOUS;
        //addButtonCreatedEvents=(Button) findViewById(R.id.button_add);

        mBaseTimetableList = (RecyclerView) findViewById(R.id.base_timeline);
        layoutManager = new LinearLayoutManager(this);
        mBaseTimetableList.setLayoutManager(layoutManager);

        mBaseTimetableList.setHasFixedSize(true);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day)
        {
            case Calendar.MONDAY: mAdapter = new CustomAdapter(mondayBaseItems.size(), this);break;

            case Calendar.TUESDAY:  mAdapter = new CustomAdapter(tuesdayBaseItems.size(), this);break;

            case Calendar.WEDNESDAY:  mAdapter = new CustomAdapter(wednesdayBaseItems.size(), this);break;

            case Calendar.THURSDAY:  mAdapter = new CustomAdapter(thursdayBaseItems.size(), this);break;

            case Calendar.FRIDAY:  mAdapter = new CustomAdapter(fridayBaseItems.size(), this);break;

            case Calendar.SATURDAY:  mAdapter = new CustomAdapter(saturdayBaseItems.size(), this);break;

            case Calendar.SUNDAY:  mAdapter = new CustomAdapter(sundayBaseItems.size(), this);break;
        }


        mBaseTimetableList.setAdapter(mAdapter);

        mCreatedEventsList = (RecyclerView) findViewById(R.id.created_events);
        layoutManager1 = new LinearLayoutManager(this);
        mCreatedEventsList.setLayoutManager(layoutManager1);

        mCreatedEventsList.setHasFixedSize(true);
        mAdapter1 = new CreatedEventsCustomAdapter(5, this);
        mCreatedEventsList.setAdapter(mAdapter1);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item

                switch (item.getItemId())
                {
                    case R.id.menu_search:

                    {
                        startActivity(new Intent(getApplicationContext(), ViewTimetableActivity.class));
                        return true;
                    }
                }

                return true;
            }
        });

//        mAuthStateListener= new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user= firebaseAuth.getCurrentUser();
//                if(user!=null)
//                {
//                    //Toast.makeText(getApplicationContext(), "Welcome to FriendlyChat!", Toast.LENGTH_SHORT).show();
//                    mUsername=user.getDisplayName();
//                    //setDatabaseReadListener();
//                }
//                else
//                {
//
//                    Log.d("TAG", "Logged out");
//                }
//            }
//        };







    }

    @Override
    protected void onStart() {
        super.onStart();
        //mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if(mAuthStateListener!=null)
//            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), clickedItemIndex+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemClick1(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), clickedItemIndex+"", Toast.LENGTH_SHORT).show();
    }
}

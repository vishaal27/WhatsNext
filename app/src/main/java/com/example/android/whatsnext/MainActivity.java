package com.example.android.whatsnext;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CustomAdapter.ListItemClickListener, CreatedEventsCustomAdapter.ListItemClickListener
{

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

//        mFirebaseAuth=FirebaseAuth.getInstance();
//        mUsername = ANONYMOUS;
        //addButtonCreatedEvents=(Button) findViewById(R.id.button_add);

        mBaseTimetableList = (RecyclerView) findViewById(R.id.base_timeline);
        layoutManager = new LinearLayoutManager(this);
        mBaseTimetableList.setLayoutManager(layoutManager);

        mBaseTimetableList.setHasFixedSize(true);
        mAdapter = new CustomAdapter(10, this);
        mBaseTimetableList.setAdapter(mAdapter);

        mCreatedEventsList = (RecyclerView) findViewById(R.id.created_events);
        layoutManager1 = new LinearLayoutManager(this);
        mCreatedEventsList.setLayoutManager(layoutManager1);

        mCreatedEventsList.setHasFixedSize(true);
        mAdapter1 = new CreatedEventsCustomAdapter(5, this);
        mCreatedEventsList.setAdapter(mAdapter1);


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

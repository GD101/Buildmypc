package com.example.glenn.buildmypc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Created by Glenn on 4/19/2017.
 */

public class amd extends MainActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FirebaseDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amdcpu);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        new GetDataFromFireabase().excuteonExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


         FirebaseDatabase myDataset = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference(0);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new myadapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

}


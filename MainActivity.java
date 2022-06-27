package com.example.rvcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;//Bridge between data and image/ arrayList and RecyclerView
    private RecyclerView.LayoutManager mLayoutManager;//allign single items in our list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        for(int i=0;i<10;i++){
            if(i<5) {
                exampleList.add(new ExampleItem("Text1.", "Num-" + i, ExampleItem.ItemType.ONE_ITEM));
            }else{
                exampleList.add(new ExampleItem("Text1.", "Text2.", "Num-" + i, ExampleItem.ItemType.TWO_ITEM));
            }
        }
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
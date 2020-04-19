package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    --add next line to  build.gradle available in Gradle.Scripts package to use recyclerView in your layouts
//    implementation 'com.google.android.material:material:1.0.0'

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private Toolbar toolbar;
    private TextView toolbatText;
    private Button addItems, refresh;

    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//define a layout manager for your recycler view
        toolbar = findViewById(R.id.toolbar);
        toolbatText = findViewById(R.id.toolbar_text_view);
        addItems = findViewById(R.id.add_items_button);
        refresh = findViewById(R.id.refresh_button);

        setSupportActionBar(toolbar);//set the tool in empty app bar//no action bar
        getSupportActionBar().setTitle("");//remove title from appbar
//        getSupportActionBar().setHomeButtonEnabled(true);//set home button enabled in toolbar

        list = new ArrayList<>();
//        toolbatText.setText("");// set your toolbar title dynamically


        for (int a = 0; a < 11; a++) {// a loop that adds 10 numbers in the list
            list.add(String.valueOf(a));
        }


        recyclerAdapter = new RecyclerAdapter(this, list);

        recyclerView.setAdapter(recyclerAdapter);


        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int a = 0; a < 6; a++) {
                    list.add(String.valueOf(a));
                }
            }
        });


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerAdapter.notifyDataSetChanged();// to refresh the adapter data
            }
        });
    }
}

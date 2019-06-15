package com.example.temperatureview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Integer> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        data = new ArrayList<>();
        data.add(24);
        data.add(18);
        data.add(22);
        data.add(19);
        data.add(23);
        data.add(24);
        data.add(26);
        data.add(28);
        Hour_Adapter adapter = new Hour_Adapter(this,data);
        recyclerView.setAdapter(adapter);
    }
}

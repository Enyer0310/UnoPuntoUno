package com.example.loginandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity_recycler extends AppCompatActivity {

    List<ListElment> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElment("#607d8b","Brayan Cortes","Chileno"));
        elements.add(new ListElment("#607d8b","Maximiliano Falcon","Uruguayo"));
        elements.add(new ListElment("#607d8b","Emiliano Amor","Argentino"));
        elements.add(new ListElment("#607d8b","Oscar Opazo","Chileno"));
        elements.add(new ListElment("#607d8b","Gabriel Suazo","Chileno"));
        elements.add(new ListElment("#607d8b","Leonardo Gil","Chileno"));
        elements.add(new ListElment("#607d8b","Vicente Pizarro","Chileno"));
        elements.add(new ListElment("#607d8b","Gabriel Costa","Peruano"));
        elements.add(new ListElment("#607d8b","Juan Martin Lucero","Argentino"));
        elements.add(new ListElment("#607d8b","Alexander Oroz","Chileno"));
        elements.add(new ListElment("#607d8b","Marcos Bolados","Chileno"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView =findViewById(R.id.listRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}
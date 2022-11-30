package com.example.loginandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

public class Activity_recycler extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<User> list;
    

    List<ListElment> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recyclerView = findViewById(R.id.listRecycle);
        database = FirebaseDatabase.getInstance().getReference("Users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);


                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
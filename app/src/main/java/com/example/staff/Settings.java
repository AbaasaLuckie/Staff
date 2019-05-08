package com.example.staff;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Settings extends AppCompatActivity {
    EditText text;
    Button show;
    DatabaseHelper database;
    RecyclerView recyclerView;
    RecyclerAdapter recycler;
    List<NoteHelper> mydata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        Intent intent = getIntent();
//        String get = intent.getStringExtra(NewAccount.put);
//        show = findViewById(R.id.show);
////        text= findViewById(R.id.tv);
////        text.setText(get+" Under Development");
//
//
//        text = findViewById(R.id.name);
//        show = findViewById(R.id.show);
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String message = text.getText().toString();
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result",message);
//                setResult(Activity.RESULT_OK,returnIntent);
//                finish();
//            }
//        });
        show =  findViewById( R.id.view );
        mydata = new ArrayList<NoteHelper>();
        recyclerView =  findViewById( R.id.Myrecycle );

        show.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = new DatabaseHelper( Settings.this );
                mydata = database.getdata();
                recycler = new RecyclerAdapter( mydata );


                Log.i( "View notes", "" + mydata );
                RecyclerView.LayoutManager reLayoutManager = new LinearLayoutManager( getApplicationContext() );
                recyclerView.setLayoutManager( reLayoutManager );
                recyclerView.setItemAnimator( new DefaultItemAnimator() );
                recyclerView.setAdapter( recycler );


            }
        } );


    }
}

package com.example.staff;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    EditText text;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        String get = intent.getStringExtra(NewAccount.put);
        show = findViewById(R.id.show);
//        text= findViewById(R.id.tv);
//        text.setText(get+" Under Development");


        text = findViewById(R.id.name);
        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = text.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",message);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });


    }
}

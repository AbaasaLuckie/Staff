package com.example.staff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        String get = intent.getStringExtra(NewAccount.put);
        TextView text = findViewById(R.id.tv);
        text.setText(get+" Under Development");
    }
}

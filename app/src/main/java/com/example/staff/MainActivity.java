package com.example.staff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String uname = "com.example.staff.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Name: Abaasa Nyangoma Lucky
//        Reg:  2017/BIT/050/ps
//        Course:Mobile Dev't

    }

    public void create(View view) {
        Intent intent = new Intent(this,NewAccount.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    public void dashboard(View view) {
        EditText name,pass;
//        name = findViewById(R.id.name);
//        pass = findViewById(R.id.password);

            Intent intent = new Intent(this, Dashboard.class);
//            String firstname = name.getText().toString();
//            intent.putExtra(uname,firstname);
            startActivity(intent);
    }

}

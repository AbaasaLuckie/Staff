package com.example.staff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class NewAccount extends AppCompatActivity {
    public static final String name = "com.example.staff.MESSAGE";
    public static final String put = "com.example.staff.MESSAGE";
    EditText fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
    }

    public void dashboard(View view) {
        fname = findViewById(R.id.fname);
        Intent intent = new Intent(this,Dashboard.class);
        String firstname = fname.getText().toString();
        intent.putExtra(name,firstname);

        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Set:
                Toast.makeText(this, "Selected Item "+item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Settings.class);
                String it = item.getTitle().toString();
                intent.putExtra(put,it);
                startActivity(intent);
            case R.id.info:
                Toast.makeText(this, "Selected Item "+item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intents = new Intent(this, Settings.class);
                String its = item.getTitle().toString();
                intents.putExtra(put,its);
                startActivity(intents);
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

package com.example.staff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class NewAccount extends AppCompatActivity {
    public static final String name = "com.example.staff.MESSAGE";
    public static final String put = "com.example.staff.MESSAGE";
    EditText fname, sname, phone, sfid, mail, station;
    Button dashboard;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        dashboard = findViewById(R.id.verify);
        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        phone = findViewById(R.id.phone);
        sfid = findViewById(R.id.sfid);
        mail = findViewById(R.id.mail);
        station = findViewById(R.id.station);
        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = fname.getText().toString();
                String s = sname.getText().toString();
                String p = phone.getText().toString();
                String sf = sfid.getText().toString();
                String m = mail.getText().toString();
                String st = station.getText().toString();

//                databaseHelper = new DatabaseHelper(this);
                databaseHelper = new DatabaseHelper(NewAccount.this);
                if (f.isEmpty() && s.isEmpty() && p.isEmpty() && sf.isEmpty() && m.isEmpty() && st.isEmpty()) {

                    Snackbar.make(view, "Empty Fields, Unable to Synchronise", Snackbar.LENGTH_LONG).setAction("Error", null).show();
                } else if (p.isEmpty()) {
                    phone.setError("Missing Telephone Contact");
                } else if (f.isEmpty()) {
                    fname.setError("Missing First Name");
                } else if (s.isEmpty()) {
                    sname.setError("Missing Second Name");
                } else if (sf.isEmpty()) {
                    sfid.setError("Missing Staff ID Number");
                } else if (m.isEmpty()) {
                    mail.setError("Missing Mail Contact");
                } else if (st.isEmpty()) {
                    station.setError("Missing Station Name");
                } else {

                    databaseHelper.insertdata(f, s, m, p, sf, st);
                    fname.setText("");
                    sname.setText("");
                    phone.setText("");
                    sfid.setText("");
                    mail.setText("");
                    station.setText("");
                    
//                    dashboard(view);
                    displayAboutDialog();
//                    Snackbar.make(view, "Empty Fields, Unable to Synchronise", Snackbar.LENGTH_LONG).setAction("Error", null).show();
//                    Toast.makeText(NewAccount.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void displayAboutDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.about_title));
        builder.setMessage(getString(R.string.about_desc));

        builder.setPositiveButton("Visit Dashboard", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stacktips.com"));
//                startActivity(browserIntent);
                Intent intent = new Intent(NewAccount.this,Dashboard.class);
                startActivity(intent);

                dialog.cancel();
            }
        });
        builder.setNegativeButton("No Thanks!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void dashboard(View view) {
        Intent intent = new Intent(this, Dashboard.class);
        String Names = " " + fname.getText().toString() + " " + sname.getText().toString();
        intent.putExtra(name, Names);

        startActivity(intent);

//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.Set:
//                Toast.makeText(this, "Selected Item "+item.getTitle(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, Settings.class);
//                String it = item.getTitle().toString();
//                intent.putExtra(put,it);
//                startActivity(intent);
//                break;
//            case R.id.info:
//                Toast.makeText(this, "Selected Item "+item.getTitle(), Toast.LENGTH_SHORT).show();
//                Intent intents = new Intent(this, Settings.class);
//                String its = item.getTitle().toString();
//                intents.putExtra(put,its);
//                startActivity(intents);
//                break;
//            default:
//                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//
    }
}
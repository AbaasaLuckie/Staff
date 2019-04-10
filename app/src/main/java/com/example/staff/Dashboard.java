package com.example.staff;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Dashboard extends AppCompatActivity {
    TextView txtForResult;
    Button get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        String accName = intent.getStringExtra(NewAccount.name);
        TextView accNam1 = findViewById(R.id.txt1);
        TextView accNam2 = findViewById(R.id.acc2);
        txtForResult = findViewById(R.id.txt1);
        get = findViewById(R.id.get);

//        get.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                start();
//            }
//        });



        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);

        bottomnav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFrag()).commit();





    }
    public void start(View view){
        Intent forresult = new Intent(getApplicationContext(),Settings.class);
        startActivityForResult(forresult,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
//                txtForResult.setText(""+result);
                Toast toast =  Toast.makeText(getApplicationContext(),"Showing "+result,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
//                Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
            }
            else{
//                txtForResult.setText("Unknown Account");
                Toast toast =  Toast.makeText(getApplicationContext(),"Unknown Account" +
                        "",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void share(){
        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_SUBJECT,""+BuildConfig.APPLICATION_ID);
        intent.putExtra(Intent.EXTRA_TEXT,"Thank you for using the Staff Application");
        intent.setType("text/plain");
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.share:
                share();
                break;
            default:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_dash:
                            selectedFragment = new DashboardFrag();
                            break;
                        case R.id.nav_menu:
                            selectedFragment = new MenuFrag();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };
}

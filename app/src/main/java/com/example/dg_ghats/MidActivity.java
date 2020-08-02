package com.example.dg_ghats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MidActivity extends AppCompatActivity {


    private Button startbtn11;
    private Button startbtn12;
    private Button startbtn13;
    private Button startbtn15;
    private Button startbtnm;

    private AppBarConfiguration mAppBarConfiguration;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid);


        startbtn11 = findViewById(R.id.startbtn11);
        startbtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(),PdfActivity1.class);
                startActivity(j);
            }
        });

        startbtn12 = findViewById(R.id.startbtn12);

        startbtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(MidActivity.this,Homeactivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startbtn13 = findViewById(R.id.startbtn13);
        startbtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(getApplicationContext(),PdfActivity2.class);
                startActivity(k);
            }
        });

        startbtnm = findViewById(R.id.startbtnm);
        startbtnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(MidActivity.this,MapsActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startbtn15 = findViewById(R.id.startbtn15);
        startbtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(MidActivity.this,KumbhActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

    }




    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
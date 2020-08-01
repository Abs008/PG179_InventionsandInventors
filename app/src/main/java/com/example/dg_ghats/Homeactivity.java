package com.example.dg_ghats;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Homeactivity extends AppCompatActivity {
    VideoView videohome;

    private Button startbtn1;
    private Button startbtn2;
    private Button startbtn3;
    private Button startbtn4;
    private Button startbtn5;

    private AppBarConfiguration mAppBarConfiguration;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        videohome=(VideoView) findViewById(R.id.videohome);
        String path = "android.resource://com.example.dg_ghats/"+R.raw.sea;
        Uri u = Uri.parse(path);
        videohome.setVideoURI(u);
        videohome.start();
        videohome.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);

            }
        });




        startbtn1 = findViewById(R.id.startbtn1);

        startbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(Homeactivity.this,CategoryActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startbtn2 = findViewById(R.id.startbtn2);
        startbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(Homeactivity.this,CategoryActivity1.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startbtn3 = findViewById(R.id.startbtn3);
        startbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext() ,PdfActivity.class);
                startActivity(p);
            }
        });

        startbtn4 = findViewById(R.id.startbtn4);

        startbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(Homeactivity.this,CategoryActivity2.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        startbtn5 = findViewById(R.id.startbtn5);

        startbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(Homeactivity.this,CategoryActivity3.class);
                startActivity(categoryIntent);
                finish();
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(Homeactivity.this,FeedbackActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_exclusive,R.id.nav_objective,R.id.nav_wholeview,R.id.nav_update,
                R.id.nav_share,R.id.nav_rate,R.id.nav_moreapp)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        break;

                    case R.id.nav_exclusive:
                        Intent i= new Intent(Homeactivity.this,ExclusiveActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_objective:
                        Intent j = new Intent(Homeactivity.this,AwarenessActivity.class);
                        startActivity(j);
                        break;

                    case R.id.nav_wholeview:
                        Intent k = new Intent(Homeactivity.this,WholeView.class);
                        startActivity(k);
                        break;

                    case R.id.nav_update:
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + "com.example.dg_ghats")));

                        }catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http//play.google.com/store/apps/details?id" +getPackageName())));

                        }

                        break;

                    case R.id.nav_share:
                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plane");
                        String shareBody = "https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu&hl=en_IN";
                        String sharesubject = "Hey,D!G! Ghats is a cool app which lets you find info about ghats and relative things...";
                        sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        sharingIntent.putExtra(Intent.EXTRA_SUBJECT,sharesubject);

                        startActivity(Intent.createChooser(sharingIntent,"Share Using"));
                        break;


                    case R.id.nav_rate:
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + "com.example.dg_ghats")));

                        }catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http//play.google.com/store/apps/details?id" +getPackageName())));

                        }
                        break;

                    case R.id.nav_moreapp:
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(("market://search?q=Department+of+Drinking+Water+and+Sanitation"))));

                        }catch (android.content.ActivityNotFoundException anfe){
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/developer?id=Developer+Name+Here")));
                        }
                        break;

                }
                drawer.closeDrawers();
                return false;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homeactivity, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_privacy){
            Intent intent = new Intent(Homeactivity.this,PolicyActivity.class);
            startActivity(intent);
            finish();

            return true;
        }
        else
            if(id == R.id.action_about){
                Intent intent = new Intent(Homeactivity.this,AboutActivity.class);
                startActivity(intent);
                finish();

                return true;

            }

            else
            if(id == R.id.action_contact){
                Intent intent = new Intent(Homeactivity.this,ContactActivity.class);
                startActivity(intent);
                finish();

                return true;
            }


            else

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume(){
        videohome.resume();
        super.onResume();
    }

    @Override
    protected void onPause(){
        videohome.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        videohome.stopPlayback();
        super.onDestroy();
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
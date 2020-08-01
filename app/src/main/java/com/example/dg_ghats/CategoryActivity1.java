package com.example.dg_ghats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class CategoryActivity1 extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter1 customAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);

        String[]title = new String[]
                {
                        "Farrukhabad","Fatehpur","Kanpur","Prayagraj","Saraon","Varanasi"

                };
        String[]htmlFile = new String[]
                {
                        "Farrukhabad","Fatehpur","kanpur2","prayagraj","saraon","Varanasi"
                };

        customAdapter1 = new CustomAdapter1(this,title,htmlFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity1.this,Homeactivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(CategoryActivity1.this,Homeactivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
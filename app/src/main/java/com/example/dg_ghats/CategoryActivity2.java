package com.example.dg_ghats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class CategoryActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);

        String[]title = new String[]
                {
                        "Hajipur","Patna","Sahebganj"

                };
        String[]htmlFile = new String[]
                {
                        "hajipur","Patna","Sahebganj"
                };

        customAdapter2 = new CustomAdapter2(this,title,htmlFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter2);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity2.this,Homeactivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(CategoryActivity2.this,Homeactivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
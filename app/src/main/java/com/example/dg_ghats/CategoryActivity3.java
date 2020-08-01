package com.example.dg_ghats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class CategoryActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter3 customAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category3);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);

        String[]title = new String[]
                {
                        "Baranagar","Barrackpore","Berhampore","Bhatpara","ChandanNagar","Hoogly","Kanchrapara","Naihati"

                };
        String[]htmlFile = new String[]
                {
                        "Baranagar","Barrackpore","Berhampore","Bhatpata(Wb)","Chandannagar","Hooghly","kanchrapara","Naihati"
                };

        customAdapter3 = new CustomAdapter3(this,title,htmlFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter3);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity3.this,Homeactivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(CategoryActivity3.this,Homeactivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
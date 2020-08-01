package com.example.dg_ghats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.CustomHolder>
{

    Context context;
    String[] title;
    String[]htmlFile;

    public CustomAdapter3(Context context, String[] title, String[] htmlFile) {
        this.context = context;
        this.title = title;
        this.htmlFile = htmlFile;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_list3,parent,false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        final String htmlfile = htmlFile[position];


        holder.textView.setText(title[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,StudyActivity3.class);
                intent.putExtra("file",htmlfile);
                context.startActivity(intent);
                ((CategoryActivity3)context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {

        return title.length;
    }

    public class CustomHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView textView;


        public CustomHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linear);
            textView = (TextView) itemView.findViewById(R.id.title);
        }
    }

}

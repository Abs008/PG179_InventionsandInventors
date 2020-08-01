package com.example.dg_ghats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class FeedbackActivity extends AppCompatActivity {
    private Button hotelbtn;
    EditText namedata,emaildata,messagedata;
    Button details, submit;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        namedata=findViewById(R.id.namedata);
        emaildata=findViewById(R.id.emaildata);
        messagedata=findViewById(R.id.messagedata);



        submit = findViewById(R.id.submit);
        details= findViewById(R.id.details);
        Firebase.setAndroidContext(this);

        hotelbtn = findViewById(R.id.hotelbtn);

        hotelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(FeedbackActivity.this,HotelActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        String UniqueID =
         Settings.Secure.getString(getApplicationContext().getContentResolver() ,
          Settings.Secure.ANDROID_ID);

        firebase = new Firebase("https://d-g--ghats.firebaseio.com/Users" + UniqueID);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details.setEnabled(true);
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();


                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()){
                    namedata.setError("Required Field");
                    submit.setEnabled(false);
                }else
                {
                    namedata.setError(null);
                    submit.setEnabled(true);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);
                if (email.isEmpty())
                {
                    emaildata.setError("Required Field");
                    submit.setEnabled(false);
                }else
                {
                    emaildata.setError(null);
                    submit.setEnabled(true);
                }

                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);
                if (message.isEmpty())
                {
                    messagedata.setError("Required Field");
                    submit.setEnabled(false);
                }else
                {
                    messagedata.setError(null);
                    submit.setEnabled(true);
                }
                Toast.makeText(FeedbackActivity.this, "Your feedback is recorded " , Toast.LENGTH_SHORT).show();

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(FeedbackActivity.this)
                                .setTitle("Sent Details")
                                .setMessage("Name -" + name +"\n\nEmail-" + email + "\n\nMessage -" + message)
                                .show();
                    }
                });
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FeedbackActivity.this,Homeactivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(FeedbackActivity.this,Homeactivity.class);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
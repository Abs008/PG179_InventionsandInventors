package com.example.dg_ghats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StudyActivity2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study2);
        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        Intent intent = getIntent();
        String url=intent.getStringExtra("file");
        webView.loadUrl("file:///android_asset/Bihar/"+url+".html");
        webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StudyActivity2.this,CategoryActivity2.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(StudyActivity2.this,CategoryActivity2.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
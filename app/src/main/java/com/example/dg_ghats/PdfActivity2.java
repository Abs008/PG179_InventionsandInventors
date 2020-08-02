package com.example.dg_ghats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity2 extends AppCompatActivity {

    PDFView pdfView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);
        pdfView2=(PDFView) findViewById(R.id.pdfviewer2);
        pdfView2.fromAsset("local.pdf").load();
    }
}
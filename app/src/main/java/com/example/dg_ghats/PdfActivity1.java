package com.example.dg_ghats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity1 extends AppCompatActivity {
    PDFView pdfView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1);
        pdfView1=(PDFView) findViewById(R.id.pdfviewer1);
        pdfView1.fromAsset("origin.pdf").load();
    }
}
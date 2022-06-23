package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.finalproject.ui.RequestsActivity;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
    }

        public void next11 (View view) {
            Intent intent = new Intent(this,MainActivity11.class);
            startActivity(intent);
    }
    public void next9 (View view) {
        Intent intent = new Intent(this, RequestsActivity.class);
        startActivity(intent);
    }
}
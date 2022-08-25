package com.rama.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        startActivity(new Intent(MainActivity.this, AddActivity.class));
    }

    public void view(View view) {
        startActivity(new Intent(MainActivity.this, ViewActivity.class));
    }

    public void sync(View view) {
    }
}
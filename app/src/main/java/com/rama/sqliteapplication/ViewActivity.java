package com.rama.sqliteapplication;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Cursor cursor;
    RecyclerView recyclerView;
    UserHelper userHelper;

    MyModel myModel;
    MyRvAdapter myAdapter;
    List<MyModel> myModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.list);

        userHelper = new UserHelper(this);
        db = userHelper.getWritableDatabase();

        myModelArrayList.clear();

        String[] col = {"Name", "ClassName", "ImagePath", "VideoPath", "Time"};
        String sortOrder = "Time" + " DESC";
        cursor = db.query("MyTable", col, null, null, null, null, sortOrder);

        if (cursor.getCount() > 0 && cursor != null) {
            while (cursor.moveToNext()) {

                @SuppressLint("Range") String nameStr = cursor.getString(cursor.getColumnIndex("Name"));
                @SuppressLint("Range") String classNameStr = cursor.getString(cursor.getColumnIndex("ClassName"));
                @SuppressLint("Range") String imagePathStr = cursor.getString(cursor.getColumnIndex("ImagePath"));
                @SuppressLint("Range") String videoPathStr = cursor.getString(cursor.getColumnIndex("VideoPath"));

                //myModel = new MyModel("" + nameStr, "" + classNameStr, "" + imagePathStr, "" + videoPathStr);
                myModelArrayList.add(new MyModel(nameStr, classNameStr, imagePathStr, videoPathStr));
                myAdapter = new MyRvAdapter(this, myModelArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(myAdapter);
            }
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }

    }
}
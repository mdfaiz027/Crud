package com.rama.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Cursor cursor;
    ListView listView;
    UserHelper userHelper;

    MyModel myModel;
    MyAdapter myAdapter;
    List<MyModel> myModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView = findViewById(R.id.list);

        userHelper = new UserHelper(this);
        db = userHelper.getWritableDatabase();

        myModelArrayList.clear();

        String[] col = {"Name", "ClassName", "Time"};
        String sortOrder = "Time" + " DESC";
        cursor = db.query("MyTable",col, null,null,null,null,sortOrder);

        if(cursor.getCount()>0 && cursor!=null)
        {
            while (cursor.moveToNext()){

                @SuppressLint("Range") String nameStr = cursor.getString(cursor.getColumnIndex("Name"));
                @SuppressLint("Range") String classNameStr = cursor.getString(cursor.getColumnIndex("ClassName"));

                myModel = new MyModel(""+nameStr, ""+classNameStr);
                myModelArrayList.add(myModel);
                myAdapter = new MyAdapter(getApplicationContext(), myModelArrayList);
                listView.setAdapter(myAdapter);
            }
        }
        else{
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }

    }
}
package com.rama.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserHelper extends SQLiteOpenHelper {
    public static final String DATA_BASENAME="MyDatabase.db";
    Context context;

    public UserHelper(@Nullable Context context) {
        super(context,DATA_BASENAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table MyTable(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,Name Text,ClassName Text,ImagePath Text, VideoPath Text, Time Text)");
        Toast.makeText(context, "SQL Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            //
        }
    }

    public long createMethod(SQLiteDatabase db, String name, String className, String imagePath, String videoPath, String Time)
    {
        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        cv.put("ClassName",className);
        cv.put("ImagePath",imagePath);
        cv.put("VideoPath",videoPath);
        cv.put("Time", Time);

        long set=db.insert("MyTable",null,cv);
        return set;
    }

}

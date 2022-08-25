package com.rama.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText name, className;
    SQLiteDatabase db;
    UserHelper userHelper;
    String namestr, classNameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);

        name=findViewById(R.id.name);
        className =findViewById(R.id.className);

        userHelper=new UserHelper(this);
        db=userHelper.getWritableDatabase();
    }

    public void save(View view) {

        namestr=name.getText().toString();
        classNameStr = className.getText().toString();

        long set=userHelper.createMethod(db,namestr, classNameStr);

        //Toast.makeText(this, ""+set, Toast.LENGTH_SHORT).show();

        if (set==-1)
        {
            Toast.makeText(this, "Record Already Exist", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "New Record Created", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.rama.sqliteapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    EditText name, className;
    SQLiteDatabase db;
    UserHelper userHelper;
    String namestr, classNameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=findViewById(R.id.name);
        className =findViewById(R.id.className);

        userHelper=new UserHelper(this);
        db=userHelper.getWritableDatabase();
    }

    public void save(View view) {

        namestr=name.getText().toString();
        classNameStr = className.getText().toString();
        String time = getTime();

        if(namestr.trim().equals("")){

            name.setError("Enter the name!");

        }else if(classNameStr.trim().equals("")){

            className.setError("Enter the class name!");

        }else{

            long set=userHelper.createMethod(db,namestr, classNameStr, time);

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

    private String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
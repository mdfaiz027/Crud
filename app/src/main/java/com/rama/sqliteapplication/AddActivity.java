package com.rama.sqliteapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    EditText name, className;
    SQLiteDatabase db;
    UserHelper userHelper;
    String namestr, classNameStr;

    TextView imagePath, videoPath;
    Uri getImageUri, getVideoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=findViewById(R.id.name);
        className=findViewById(R.id.className);
        imagePath=findViewById(R.id.imagePath);
        videoPath=findViewById(R.id.videoPath);

        userHelper=new UserHelper(this);
        db=userHelper.getWritableDatabase();
    }

    public void save(View view) {

        namestr = name.getText().toString();
        classNameStr = className.getText().toString();

        String time = getTime();

        if(namestr.trim().equals("")){

            name.setError("Enter the name!");

        }else if(classNameStr.trim().equals("")){

            className.setError("Enter the class name!");

        }else{

            long set=userHelper.createMethod(db,""+namestr, ""+classNameStr, ""+getImageUri, ""+getVideoUri, time);

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

    public void uploadImage(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 202);
    }

    public void uploadVideo(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("video/*");
        startActivityForResult(intent, 203);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case 202:
                if(resultCode==RESULT_OK && data!=null && data.getData()!=null){
                    getImageUri = data.getData();
                    imagePath.setText(""+getImageUri);
                }
                break;
            case 203:
                if(resultCode==RESULT_OK && data!=null && data.getData()!=null){
                    getVideoUri = data.getData();
                    videoPath.setText(""+getVideoUri);
                }
                break;
        }

    }
}
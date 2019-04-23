package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase con=openOrCreateDatabase("test.db",MODE_PRIVATE,null);
        con.execSQL("create table a(id number,name char(10))");
        con.execSQL("insert into a (id,name) values(10,'sss')");
        Cursor cursor= con.rawQuery("select * from a",null);
        while (cursor.moveToNext()){
            Log.w("Data  ", String.valueOf(cursor.getInt(0))+cursor.getString(1));

        }
    }
}

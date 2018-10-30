package com.example.sonduong.intentex;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "student";
    private static final int DB_VERSION = 1;
    public StudentDatabaseHelper(Context context){
        super (context, DB_NAME,null,DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table student( id Integer primary Key autoincrement, name Text, age Integer, address Text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(SQLiteDatabase  db, String name, int age, String address){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address",address);
        db.insert("student",null, values);
    }
}

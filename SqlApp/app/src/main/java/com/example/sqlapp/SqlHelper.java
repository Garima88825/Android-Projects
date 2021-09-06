package com.example.sqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class SqlHelper extends SQLiteOpenHelper {

    public SqlHelper(Context context) {
        super(context, "App.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table EmployeeData(empid Text primary key, name Text, salary Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists EmployeeData");
    }

    public boolean insertData(String empid, String name, String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("empid", empid);
        contentValues.put("name", name);
        contentValues.put("salary", salary);

        long result = db.insert("EmployeeData",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateData(String empid, String name, String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("salary", salary);
        Cursor cursor = db.rawQuery("Select * from EmployeeData where empid=?", new String[]{empid});
        if(cursor.getCount() > 0){
            long result = db.update("EmployeeData",contentValues, "empid=?",new String[]{empid});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }

    public boolean deleteData(String empid){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("EmployeeData","empid=?",new String[]{empid} );
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from EmployeeData",null);
        return cursor;
    }
}

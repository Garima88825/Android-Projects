package com.example.sqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText empid, name, salary;
    Button prev, next, clear, insert, update, delete;
    SqlHelper DB;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empid = findViewById(R.id.empID);
        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        clear = findViewById(R.id.clear);
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        clear.setOnClickListener(this);
        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        DB = new SqlHelper(this);
        cursor = DB.getData();
        if(cursor.getCount() > 0){
            cursor.moveToNext();
            empid.setText(cursor.getString(0));
            name.setText(cursor.getString(1));
            salary.setText(cursor.getString(2));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
    }

    public void clearTxtBox() {
        empid.getText().clear();
        name.getText().clear();
        salary.getText().clear();
    }

    @Override
    public void onClick(View v) {

        String dempid, dname, dsalary;
        Boolean check;

        switch (v.getId()) {
            case R.id.prev:
                if (cursor.getCount() > 0 && cursor.getPosition() > 0 && cursor.moveToPrevious()) {
                    empid.setText(cursor.getString(0));
                    name.setText(cursor.getString(1));
                    salary.setText(cursor.getString(2));
                }
                break;
            case R.id.next:
                if (cursor.getCount() > 0 && cursor.getPosition() < cursor.getCount() - 1 && cursor.moveToNext()) {
                    empid.setText(cursor.getString(0));
                    name.setText(cursor.getString(1));
                    salary.setText(cursor.getString(2));
                }
                break;

            case R.id.clear:
                clearTxtBox();
                break;

            case R.id.insert:

                dempid = empid.getText().toString().trim();
                dname = name.getText().toString().trim();
                dsalary = salary.getText().toString().trim();

                if(TextUtils.isEmpty(dempid) || TextUtils.isEmpty(dname) || TextUtils.isEmpty(dsalary)){
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                check = DB.insertData(dempid, dname, dsalary);
                if (check) {
                    Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    clearTxtBox();
                    cursor = DB.getData();
                } else {
                    Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.update:

                dempid = empid.getText().toString().trim();
                dname = name.getText().toString().trim();
                dsalary = salary.getText().toString().trim();

                if(TextUtils.isEmpty(dempid)){
                    Toast.makeText(this, "Please fill roll no", Toast.LENGTH_SHORT).show();
                    return;
                }

                check = DB.updateData(dempid, dname, dsalary);

                if (check) {
                    Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                    clearTxtBox();
                    cursor = DB.getData();
                } else {
                    Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.delete:

                dempid = empid.getText().toString().trim();

                if(TextUtils.isEmpty(dempid)){
                    Toast.makeText(this, "Please fill roll no", Toast.LENGTH_SHORT).show();
                    return;
                }

                dempid = empid.getText().toString().trim();
                check = DB.deleteData(dempid);

                if (check) {
                    Toast.makeText(this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                    clearTxtBox();
                    cursor = DB.getData();
                } else {
                    Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}

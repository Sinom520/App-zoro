package com.example.app;

import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        static public MyDatabaseHelper dbHelper;
        static public Intent op2 = new Intent("ACTION_START2");
        EditText user_name1;
        EditText user_ID1;
        EditText user_password1;
        Button user_enter;
        Button user_login;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            dbHelper = new MyDatabaseHelper(this, "Taobao.db", null, 1);
            dbHelper.getWritableDatabase();

            /*SQLiteDatabase db1 = dbHelper.getWritableDatabase();
            ContentValues values1 = new ContentValues();
            values1.put("store_name","李宁");
            values1.put("store_kind","运动休闲服");
            db1.insert("Store",null,values1);
            values1.clear();

            SQLiteDatabase db2 = dbHelper.getWritableDatabase();
            ContentValues values2 = new ContentValues();
            values2.put("good_store","李宁");
            values2.put("good_name","运动裤");
            values2.put("good_price","$283");
            db2.insert("Good",null,values2);
            values2.clear();*/

            user_enter = (Button) findViewById(R.id.user_enter);
            user_login = (Button) findViewById(R.id.user_login);
            user_name1 = (EditText) findViewById(R.id.user_name1);
            user_ID1 = (EditText) findViewById(R.id.user_ID1);
            user_password1 = (EditText) findViewById(R.id.user_password1);

            user_enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (check1()){
                        if (check2()){
                            startActivity(op2);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"无此用户,请先注册",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this,"请输入完整信息",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            user_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent op1 = new Intent("ACTION_START1");
                    startActivity(op1);
                }
            });
        }

    private boolean check2() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor1 = db.query("User", null, null, null, null, null, null);
        if (cursor1.moveToFirst()) {
            do {
                if(cursor1.getString(cursor1.getColumnIndex("user_name")).equals(user_name1.getText().toString().trim())&&
                cursor1.getString(cursor1.getColumnIndex("user_ID")).equals(user_ID1.getText().toString().trim())&& cursor1.getString(cursor1.getColumnIndex("user_password")).equals(user_password1.getText().toString().trim())){
                    return true;
                }
            } while (cursor1.moveToNext());
        }
        cursor1.close();
        db.close();
        return false;
    }

    private boolean check1() {
            if (user_name1.getText().toString().trim().isEmpty()||user_ID1.getText().toString().trim().isEmpty()||user_password1.getText().toString().trim().isEmpty()){
                return false;
            }
            else {
                return true;
            }
    }
    }


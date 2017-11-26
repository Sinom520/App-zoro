package com.example.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.app.MainActivity.dbHelper;
import static com.example.app.MainActivity.op2;

public class user_login extends AppCompatActivity {
    EditText user_name2;
    EditText user_password2;
    EditText user_ID2;
    Button new_user_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        new_user_login = (Button)findViewById(R.id.new_user_login);
        user_name2 = (EditText)findViewById(R.id.user_name2);
        user_ID2 = (EditText)findViewById(R.id.user_ID2);
        user_password2 = (EditText)findViewById(R.id.user_password2);

        new_user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check3()){
                    if (check2()){
                        if (check1()){
                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            ContentValues values = new ContentValues();
                            values.put("user_name",user_name2.getText().toString().trim());
                            values.put("user_ID",user_ID2.getText().toString().trim());
                            values.put("user_password",user_password2.getText().toString().trim());
                            db.insert("User",null,values);
                            values.clear();
                            startActivity(op2);
                        }
                        else {
                            Toast.makeText(user_login.this,"该用户名已被使用",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(user_login.this,"账号已注册",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(user_login.this,"请填写完整信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean check2() {
        SQLiteDatabase db2 = dbHelper.getWritableDatabase();
        Cursor cursor2 = db2.query("User",null,null,null,null,null,null);
        if (cursor2.moveToFirst()){
            do {
                if(cursor2.getString(cursor2.getColumnIndex("user_name")).equals(user_name2.getText().toString().trim())&& cursor2.getString(cursor2.getColumnIndex("user_ID")).equals(user_ID2.getText().toString().trim())&&
                cursor2.getString(cursor2.getColumnIndex("user_password")).equals(user_password2.getText().toString().trim())){
                 return false;
                }
            }while (cursor2.moveToNext());
        }
        cursor2.close();
        db2.close();
        return true;
    }//判断是否已注册

    private boolean check1() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor2 = db.query("User",null,null,null,null,null,null);
        if (cursor2.moveToFirst()){
            do {
                if (cursor2.getString(cursor2.getColumnIndex("user_name")).equals(user_name2.getText().toString().trim())) {
                    return false;
                }
            }while (cursor2.moveToNext());
        }
        cursor2.close();
        db.close();
        return true;
    }//判断用户名是否重复
    private boolean check3(){
        if (user_name2.getText().toString().trim().isEmpty()||user_ID2.getText().toString().trim().isEmpty()||user_password2.getText().toString().trim().isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
}

package com.example.app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.app.MainActivity.dbHelper;

public class add_store extends AppCompatActivity {
    private EditText as_name;
    private EditText as_kind;
    private Button as;
    private String str1;//获得店铺名称
    private String str2;//获得经营类型

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);

        as_name = (EditText) findViewById(R.id.as_name);
        as_kind = (EditText) findViewById(R.id.as_kind);
        as = (Button)findViewById(R.id.as);

        str1 = as_name.getText().toString();
        str2 = as_kind.getText().toString();
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check2()){
                    SQLiteDatabase db5 = dbHelper.getWritableDatabase();
                    ContentValues values5 = new ContentValues();
                    values5.put("store_name",as_name.getText().toString().trim());
                    values5.put("store_kind",as_kind.getText().toString().trim());
                    db5.insert("Store",null,values5);
                    values5.clear();
                    Toast.makeText(add_store.this,"增添成功",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(add_store.this,"请填写完整信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean check2() {
        if (as_name.getText().toString().isEmpty()||as_kind.getText().toString().isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
}

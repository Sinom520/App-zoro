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

public class add_good extends AppCompatActivity {

    private EditText ag_name;
    private EditText ag_price;
    private EditText ag_s_name;
    private Button ag;
    private String str3;//获得商品名称
    private String str4;//获得商品价格
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_good);

        ag_name = (EditText) findViewById(R.id.ag_name);
        ag_price = (EditText) findViewById(R.id.ag_price);
        ag_s_name = (EditText)findViewById(R.id.ag_s_name);
        ag = (Button)findViewById(R.id.ag);

        str3 = ag_name.getText().toString();
        str4 = ag_price.getText().toString();
        ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check3()){
                    SQLiteDatabase db4 = dbHelper.getWritableDatabase();
                    ContentValues values4 = new ContentValues();
                    values4.put("good_store",ag_s_name.getText().toString().trim());
                    values4.put("good_name",ag_name.getText().toString().trim());
                    values4.put("good_price",ag_price.getText().toString().trim());
                    db4.insert("Good",null,values4);
                    values4.clear();
                    Toast.makeText(add_good.this,"增添成功",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(add_good.this,"请填写完整信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean check3() {
        if (ag_name.getText().toString().isEmpty()||ag_price.getText().toString().isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
}

package com.example.app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.app.MainActivity.dbHelper;

public class leader_store extends AppCompatActivity {
    private TextView one1;
    private TextView two1;
    private TextView three1;
    private TextView four1;
    private TextView five1;
    private TextView six1;
    private TextView seven1;//店铺
    private Button add1;//增添店铺
    private Button delete1;//删除店铺

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_store);

        one1 = (TextView)findViewById(R.id.one1);
        two1 = (TextView)findViewById(R.id.two1);
        three1 = (TextView)findViewById(R.id.three1);
        four1 = (TextView)findViewById(R.id.four1);
        five1 = (TextView)findViewById(R.id.five1);
        six1 = (TextView)findViewById(R.id.six1);
        seven1 = (TextView)findViewById(R.id.seven1);
        add1 = (Button)findViewById(R.id.add1);
        delete1 = (Button)findViewById(R.id.delete1);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op8 = new Intent("ACTION_START8");
                startActivity(op8);
            }
        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(leader_store.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

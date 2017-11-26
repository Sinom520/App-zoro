package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class leader_good extends AppCompatActivity {
    private TextView one2;
    private TextView two2;
    private TextView three2;
    private TextView four2;
    private TextView five2;
    private TextView six2;
    private TextView seven2;//商品
    private Button add2;//增添商品
    private Button delete2;//删除商品

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_good);

        one2 = (TextView)findViewById(R.id.one2);
        two2 = (TextView)findViewById(R.id.two2);
        three2 = (TextView)findViewById(R.id.three2);
        four2 = (TextView)findViewById(R.id.four2);
        five2 = (TextView)findViewById(R.id.five2);
        six2 = (TextView)findViewById(R.id.six2);
        seven2 = (TextView)findViewById(R.id.seven2);
        add2 = (Button)findViewById(R.id.add2);
        delete2 = (Button)findViewById(R.id.delete2);


        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(leader_good.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op10 = new Intent("ACTION_START10");
                startActivity(op10);
            }
        });
    }
}

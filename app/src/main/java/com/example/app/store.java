package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class store extends AppCompatActivity {
    private Button list;//订单
    private Button car;//购物车
    private Button rule1;//S(36)
    private Button rule2;//M(37)
    private Button rule3;//L(38)
    private Button color1;//米色
    private Button color2;//黑色
    private Button color3;//浅蓝色
    static public String r;//选中的尺寸
    static public String c;//选中的颜色
    static public TextView good_name1;//商品名称
    static public TextView good_price1;//商品价格
    static public  Intent op4 = new Intent("ACTION_START4");
    private Boolean flag2 = false;//判断是否选择商品尺寸
    private Boolean flag3 = false;//判断是否选择商品颜色
    static public Boolean flag4 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        good_name1 = (TextView)findViewById(R.id.good_name1);
        good_price1 = (TextView)findViewById(R.id.good_name1);
        rule1 = (Button) findViewById(R.id.rule1);
        color1 = (Button) findViewById(R.id.color1);
        rule2 = (Button) findViewById(R.id.rule2);
        color2 = (Button) findViewById(R.id.color2);
        rule3 = (Button) findViewById(R.id.rule3);
        color3 = (Button) findViewById(R.id.color3);
        list = (Button)findViewById(R.id.list);
        car = (Button)findViewById(R.id.car);

        rule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rule2.setEnabled(false);
                rule3.setEnabled(false);
                r = "S(36)";
                flag2 = true;
            }
        });
        rule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rule1.setEnabled(false);
                rule3.setEnabled(false);
                r = "M(37)";
                flag2 = true;
            }
        });
        rule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rule2.setEnabled(false);
                rule1.setEnabled(false);
                r = "L(38)";
                flag2 = true;
            }
        });
        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color2.setEnabled(false);
                color3.setEnabled(false);
                c= "米色";
                flag3 = true;
            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1.setEnabled(false);
                color3.setEnabled(false);
                c = "黑色";
                flag3 = true;
            }
        });
        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1.setEnabled(false);
                color2.setEnabled(false);
                c = "浅蓝色";
                flag3 = true;
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(op4);

            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()){
                    flag4 = true;
                    Intent op5 = new Intent("ACTION_START5");
                    startActivity(op5);
                }
                else {
                    Toast.makeText(store.this,"请选择商品属性",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean check() {
        if(flag2&&flag3){
            return true;
        }
        else {
            return false;
        }
    }
}

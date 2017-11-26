package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.app.shopping_car.flag1;
import static com.example.app.store.c;
import static com.example.app.store.flag4;
import static com.example.app.store.r;

public class list extends AppCompatActivity {
    private TextView good_name2;//已选商品名称
    private TextView good_price2;//已选商品价格
    private TextView rule;//已选商品尺寸
    private TextView color;//已选商品颜色
    private TextView later;//提示已完成支付
    private String str = "商品已付款";//提示内容


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        good_name2 = (TextView) findViewById(R.id.good_name2);
        good_price2 = (TextView) findViewById(R.id.good_price2);
        rule = (TextView) findViewById(R.id.rule);
        color = (TextView) findViewById(R.id.color);
        later = (TextView)findViewById(R.id.later);

        if (flag4){
            rule.setText(r);
            color.setText(c);
        }
        if (flag1){
            later.setText(str);
        }
    }
}

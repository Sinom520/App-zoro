package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.app.store.c;
import static com.example.app.store.op4;
import static com.example.app.store.r;

public class shopping_car extends AppCompatActivity {
    private TextView good_name3;//已选商品名称
    private TextView good_price3;//已选商品价格
    private TextView rule4;//已选商品尺寸
    private TextView color4;//已选商品颜色
    private Button list_car;//查看订单
    private Button pay;//立即支付
    static public Boolean flag1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);

        good_name3 = (TextView)findViewById(R.id.good_name3);
        good_price3 = (TextView)findViewById(R.id.good_price3);
        rule4 = (TextView)findViewById(R.id.rule4);
        color4 = (TextView)findViewById(R.id.color4);
        list_car = (Button)findViewById(R.id.list_car);
        pay = (Button)findViewById(R.id.pay);

        rule4.setText(r);
        color4.setText(c);
        list_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(op4);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = true;
                Toast.makeText(shopping_car.this,"支付成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

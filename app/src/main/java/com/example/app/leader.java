package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class leader extends AppCompatActivity {
    private Button store;//增删店铺
    private Button good;//增删商品

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        store = (Button)findViewById(R.id.store);
        good = (Button)findViewById(R.id.good);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op7 = new Intent("ACTION_START7");
                startActivity(op7);
            }
        });
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op9 = new Intent("ACTION_START9");
                startActivity(op9);
            }
        });
    }
}

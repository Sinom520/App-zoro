package com.example.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.app.MainActivity.op2;


public class center extends AppCompatActivity {
    private DrawerLayout drawer ;
    private Toolbar toolbar;
    private NavigationView inc;
    private TextView ni;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu) ;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item .getItemId()){
            case R.id.search:
                Toast.makeText(center.this,"搜索商品",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imformation:
                Toast.makeText(center.this,"已经是最新版本",Toast.LENGTH_SHORT).show();
                break;
            case R.id.skip:
                Intent op3 = new Intent("ACTION_START3");
                startActivity(op3);
            case R.id.leader:
                Intent op6 = new Intent("ACTION_START6");
                startActivity(op6);
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        inc = (NavigationView) findViewById(R.id.inc);
        ni = (TextView) findViewById(R.id.ni);
        inc.setItemIconTintList(null);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        }
        inc.setCheckedItem(R.id.inc);
        inc.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawers();
                return true;
            }
        });

    }
}

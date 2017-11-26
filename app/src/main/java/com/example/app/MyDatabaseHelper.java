package com.example.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by hp on 2017/11/25.
 */

 public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER = "create table User("
            + "id integer primary key autoincrement,"
            + "user_name text,"
            + "user_ID text,"
            + "user_password text)";

    public static final String CREATE_STORE = "create table Store("
            + "id integer primary key autoincrement,"
            + "store_name text,"
            + "store_kind text)";

    public static final String CREATE_GOOD = "create table Good("
            + "id integer primary key autoincrement,"
            + "good_store text,"
            + "good_name text,"
            + "good_price text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_STORE);
        db.execSQL(CREATE_GOOD);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    }
}

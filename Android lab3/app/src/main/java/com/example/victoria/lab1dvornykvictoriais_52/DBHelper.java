package com.example.victoria.lab1dvornykvictoriais_52;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Victoria on 13.05.2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pizzasDb";
    public static final String TABLE_PIZZAS = "orders";

    public static final String KEY_ID = "_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_SIZE = "size";
    public static final String KEY_DOUGH = "dough";
    public static final String KEY_WISHES = "wishes";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_PIZZAS + "(" + KEY_ID
                + " integer primary key," + KEY_TYPE + " text," + KEY_SIZE + " text," + KEY_DOUGH + " text," + KEY_WISHES + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_PIZZAS);

        onCreate(sqLiteDatabase);
    }
}

package com.db_try;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by User on 12.01.2018.
 */

public class SqlConnector extends SQLiteOpenHelper {

    private static final String NAME = "application.db";
    private static final int VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tables.ACCOUNT_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public SqlConnector(Context context) {
        super(context, NAME, null, VERSION);

    }
}

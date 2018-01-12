package com.db_try;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public SqlConnector mSqlConnector;
    public AccountInfo accountInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountInfo=new AccountInfo("1fn","2ln");
        mSqlConnector=new SqlConnector(this);

        SQLiteDatabase writeConnection=mSqlConnector.getWritableDatabase();
        writeConnection.beginTransaction();
        ContentValues contentValues=new ContentValues();
        contentValues.put(AccountInfoDb.ID,"1");
        contentValues.put(AccountInfoDb.FIRST_NAME,accountInfo.first_name);
        contentValues.put(AccountInfoDb.LAST_NAME,accountInfo.last_name);
        writeConnection.insert(AccountInfoDb.TABLE,null,contentValues);
       // writeConnection.delete(AccountInfoDb.TABLE,null,null);
        writeConnection.setTransactionSuccessful();
        writeConnection.endTransaction();

        SQLiteDatabase readableConnection=mSqlConnector.getReadableDatabase();
        Cursor cursor=readableConnection.query(AccountInfoDb.TABLE,new String[]{AccountInfoDb.ID,AccountInfoDb.FIRST_NAME,AccountInfoDb.LAST_NAME},null,null,AccountInfoDb.ID,null,null);

        if (cursor.getCount()==0){
            Log.e(TAG, "onCreate: empty" );
        }else Log.e(TAG, "onCreate: full" );

        while (cursor.moveToNext()){
            String id=cursor.getString(cursor.getColumnIndex(AccountInfoDb.ID));
            Log.e(TAG, "onCreate: "+id);
            String fn=cursor.getString(cursor.getColumnIndex(AccountInfoDb.FIRST_NAME));
            Log.e(TAG, "onCreate: fn "+fn);
            Log.e(TAG, "onCreate: lf "+cursor.getString(cursor.getColumnIndex(AccountInfoDb.LAST_NAME)));
        }
        cursor.close();

    }
}

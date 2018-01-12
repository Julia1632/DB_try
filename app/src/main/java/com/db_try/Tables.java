package com.db_try;

/**
 * Created by User on 12.01.2018.
 */

public class Tables {
    public static final String ACCOUNT_INFO_TABLE
            = "CREATE TABLE IF NOT EXISTS " +
            AccountInfoDb.TABLE + "(" +
            AccountInfoDb.ID + " VARCHAR (500)," +
            AccountInfoDb.FIRST_NAME + " VARCHAR (500)," +
            AccountInfoDb.LAST_NAME + " VARCHAR (500) )";

}

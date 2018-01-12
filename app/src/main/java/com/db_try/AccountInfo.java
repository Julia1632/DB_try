package com.db_try;

import org.json.JSONObject;

import java.io.Serializable;


public class AccountInfo implements Serializable {
    public String first_name;
    String last_name;
    String maiden_name;
    String screen_name;
    int sex;
    int relation;
    String bdate;
    String home_town;
    String status;
    String phone;


    //https://api.vk.com/method/METHOD_NAME?PARAMETERS&access_token=ACCESS_TOKEN&v=V

    public AccountInfo parse(JSONObject pAccouuntInfo) throws Exception {
        AccountInfo accountInfo = new AccountInfo();

        accountInfo.first_name=pAccouuntInfo.getString("first_name");
        accountInfo.last_name=pAccouuntInfo.getString("last_name");


        return accountInfo;
    }

    public AccountInfo(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public AccountInfo() {
    }
}

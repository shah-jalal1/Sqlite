package com.redonicsoft.sqlitedatabase.db_access;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.redonicsoft.sqlitedatabase.RegistrationActivity;
import com.redonicsoft.sqlitedatabase.entity.RegistrationEntity;

public class DBConnection extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION=1;
    private final static String DATABSE_NAME="smartdeviceappdevelopment.db";

    public DBConnection(@Nullable Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ RegistrationEntity.TABLE_NAME+"("+
                RegistrationEntity._ID+" INTEGER PRIMARY KEY,"+
                RegistrationEntity.FULL_NAME+" TEXT,"+
                RegistrationEntity.USER_NAME+" TEXT,"+
                RegistrationEntity.PASSWORD+" TEXT,"+
                RegistrationEntity.EMAIL_ADDRESS+" TEXT,"+
                RegistrationEntity.CONTACT_NUMBER+" TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RegistrationEntity.TABLE_UPGRADE);
        onCreate(db);
    }

    public void addRegistrationData(String fullName, String userName, String password, String email, String contact){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues registrationDataSave = new ContentValues();
        registrationDataSave.put(RegistrationEntity.FULL_NAME,fullName);
        registrationDataSave.put(RegistrationEntity.USER_NAME,userName);
        registrationDataSave.put(RegistrationEntity.PASSWORD,password);
        registrationDataSave.put(RegistrationEntity.EMAIL_ADDRESS,email);
        registrationDataSave.put(RegistrationEntity.CONTACT_NUMBER, contact);

        long resultOfRegistration = database.insert(RegistrationEntity.TABLE_NAME, null, registrationDataSave);
        if(resultOfRegistration>0){
            System.out.println("Data save successfully");


        }

    }

    public boolean checkLogin(){

        return Boolean.FALSE;
    }
}

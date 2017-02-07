package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by Sian on 07/02/2017.
 *
 * Database helper for Pets app. Manages database creation and version management.
 *
 */

public class PetDbHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    //Database version. If you change the database schema, you must increment the database version.
    public static final int DB_VERSION =1;
    //Name of the database file
    public static final String DB_NAME = "pets";

    /**
     * Constructs a new instance of petDBHelper
     * @param context of the app
     */
    public PetDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //String for creating pets table with 5 columns
        String CREATE_SQL_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                PetEntry.COLUMN_PET_BREED + " TEXT, " +
                PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL, " +
                PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(CREATE_SQL_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     * @param db SQLite "pets" database
     * @param oldVersion old version of database
     * @param newVersion new version of database
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Still at version 1 so no need to upgrade right now
//        String SQL_DELETE_ENTRIES = "";
//        db.execSQL(SQL_DELETE_ENTRIES);
//        onCreate(db);
    }
}

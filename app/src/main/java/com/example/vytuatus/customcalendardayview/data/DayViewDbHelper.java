package com.example.vytuatus.customcalendardayview.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.vytuatus.customcalendardayview.data.DayViewContract.EventsEntry;

/**
 * Created by vytuatus on 7/7/17.
 */

public class DayViewDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "events.db";

    public DayViewDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold locations.  A location consists of the string supplied in the
        // location setting, the city name, and the latitude and longitude
        final String SQL_CREATE_EVENTS_TABLE = "CREATE TABLE " + EventsEntry.TABLE_NAME + " (" +
                EventsEntry._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                EventsEntry.COLUMN_MESSAGE + " TEXT NOT NULL, " +
                EventsEntry.COLUMN_START + " INTEGER NOT NULL, " +
                EventsEntry.COLUMN_END + " INTEGER NOT NULL, " +
                " );";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EventsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}

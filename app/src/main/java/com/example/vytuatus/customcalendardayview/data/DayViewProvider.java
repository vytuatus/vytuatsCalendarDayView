package com.example.vytuatus.customcalendardayview.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by vytuatus on 7/9/17.
 */

public class DayViewProvider extends ContentProvider {

    //the constants will be used in URI matcher. Just to make life easier when matching a URI
    //With the data action they want to perform

    public static final int CODE_ALL_EVENTS = 100;
    public static final int CODE_SPECIFIC_EVENT = 101;

    private DayViewDbHelper mDayViewDbHelper;

    //declare URI matcher
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static UriMatcher buildUriMatcher(){

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = DayViewContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, DayViewContract.PATH_EVENTS, CODE_ALL_EVENTS);
        matcher.addURI(authority, DayViewContract.PATH_EVENTS + "/*", CODE_SPECIFIC_EVENT);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mDayViewDbHelper = new DayViewDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor cursor;

        switch (sUriMatcher.match(uri)){
            case CODE_ALL_EVENTS:

                cursor = mDayViewDbHelper.getReadableDatabase().query(
                        DayViewContract.EventsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}

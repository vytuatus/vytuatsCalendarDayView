package com.example.vytuatus.customcalendardayview.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by vytuatus on 7/9/17.
 */

public class DayViewContract {

    public static final String CONTENT_AUTHORITY = "com.example.vytuatus.customcalendardayview";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_EVENTS = "events";

    public static final class EventsEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENTS).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EVENTS;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EVENTS;

        // Table name
        public static final String TABLE_NAME = "events";

        //Table column names
        public static final String COLUMN_MESSAGE = "message";
        public static final String COLUMN_START = "start";
        public static final String COLUMN_END = "end";

        //Return the URI with the row id at the end
        public static Uri buildEventUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

package com.example.onrequest.schema.converters;

import android.net.Uri;

import androidx.room.TypeConverter;

public class Converters {

    @TypeConverter
    public static Uri fromString(String uri) {
        return uri == null ? null : Uri.parse(uri);
    }

    @TypeConverter
    public static String toString(Uri uri) {
        return uri == null ? null : uri.toString();
    }
}

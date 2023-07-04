package com.example.onrequest.schema;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {MenuItem.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract MenuItemDao getMenuItemDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "MenuEntracesDB")
                    .allowMainThreadQueries().
                    addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    db.execSQL( "INSERT INTO menuitem VALUES(1, 'coca cola', 10.2,'https://www.w3schools.com/howto/img_avatar.png', 'DRINK', 'desc')" );
                    db.execSQL( "INSERT INTO menuitem VALUES(2, 'hambuguer', 10.2,'https://www.w3schools.com/howto/img_avatar.png', 'FOOD', 'desc')" );
                }
            }).build();
        }
        return INSTANCE;
    }
}


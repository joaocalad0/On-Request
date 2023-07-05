package com.example.onrequest.schema;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {MenuItem.class,
                Cart.class,
                MenuTable.class},
        version = 1
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract MenuItemDao getMenuItemDao();

    public abstract CartDao getCartDao();
    public abstract TableDao getTableDao();

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
                            db.execSQL("INSERT INTO menuitem VALUES(1, 'coca cola', 10.2,'https://www.w3schools.com/howto/img_avatar.png', 'DRINK', 'desc')");
                            db.execSQL("INSERT INTO menuitem VALUES(2, 'hambuguer', 10.2,'https://www.w3schools.com/howto/img_avatar.png', 'FOOD', 'desc')");
                            db.execSQL("INSERT INTO menuItem VALUES(3, 'Pizza', 8.5, 'https://www.w3schools.com/howto/img_avatar.png', 'FOOD', 'desc')");
                            db.execSQL("INSERT INTO menuItem VALUES(4, 'Pepsi', 1.2, 'https://www.w3schools.com/howto/img_avatar.png', 'DRINK', 'desc')");
                            db.execSQL("INSERT INTO menuTable (tableId) VALUES (1)");
                            db.execSQL("INSERT INTO menuTable (tableId) VALUES (2)");
                            db.execSQL("INSERT INTO menuTable (tableId) VALUES (3)");
                            db.execSQL("INSERT INTO menuTable (tableId) VALUES (4)");
                            db.execSQL("INSERT INTO menuTable (tableId) VALUES (5)");
                            db.execSQL("INSERT INTO menuTable (tableId) VALUES (6)");
                        }
                    }).build();
        }
        return INSTANCE;
    }
}


package com.example.onrequest.schema.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.onrequest.schema.converters.Converters;
import com.example.onrequest.schema.dao.CartDao;
import com.example.onrequest.schema.dao.MenuItemDao;
import com.example.onrequest.schema.dao.MenuTableDao;
import com.example.onrequest.schema.entity.cart.Cart;
import com.example.onrequest.schema.entity.cart.CartMenuItem;
import com.example.onrequest.schema.entity.item.MenuItem;
import com.example.onrequest.schema.entity.table.MenuTable;

@Database(
        entities = {
                MenuItem.class,
                Cart.class,
                CartMenuItem.class,
                MenuTable.class
        },
        version = 1
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract MenuItemDao getMenuItemDao();

    public abstract CartDao getCartDao();

    public abstract MenuTableDao getMenuTableDao();

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
                            db.execSQL("INSERT INTO menuTable (menuTableId) VALUES (1)");
                            db.execSQL("INSERT INTO menuTable (menuTableId) VALUES (2)");
                            db.execSQL("INSERT INTO menuTable (menuTableId) VALUES (3)");
                            db.execSQL("INSERT INTO menuTable (menuTableId) VALUES (4)");
                            db.execSQL("INSERT INTO menuTable (menuTableId) VALUES (5)");
                            db.execSQL("INSERT INTO menuTable (menuTableId) VALUES (6)");
                        }
                    }).build();
        }
        return INSTANCE;
    }
}


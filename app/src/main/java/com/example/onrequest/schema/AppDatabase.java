package com.example.onrequest.schema;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Food.class, Drink.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract DrinkDao getDrinkDao();

    public abstract FoodDao getFoodDao();

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
                    db.execSQL("INSERT INTO menu VALUES(1, '123', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.','https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(2, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(3, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(4, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(5, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(6, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(7, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(8, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(9, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(10, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(11, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(12, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(13, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(14, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(15, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                }
            }).build();
        }
        return INSTANCE;
    }
}

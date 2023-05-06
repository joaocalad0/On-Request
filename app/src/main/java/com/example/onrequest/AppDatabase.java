package com.example.onrequest;

import static com.bumptech.glide.load.data.mediastore.ThumbFetcher.build;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Menu.class, Message.class},version = 1)
    public abstract class AppDatabase extends RoomDatabase {

    public abstract MenuDao getMenuDao();
    public abstract MessageDao getMessageDao();

    private static Builder<AppDatabase> INSTANCE;

    public static AppDatabase getInstance(Context context) {

        if (INSTANCE==null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "MenuDB").allowMainThreadQueries().addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    db.execSQL("INSERT INTO menu VALUES(1, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(2, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(3, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(4, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(5, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(6, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                    db.execSQL("INSERT INTO menu VALUES(7, 'Lorem Ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'https://www.w3schools.com/howto/img_avatar.png')");
                }
            });
             .build();
        }
        return INSTANCE;
    }
}

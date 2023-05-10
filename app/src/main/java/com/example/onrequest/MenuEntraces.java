package com.example.onrequest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class MenuEntraces {
     @PrimaryKey(autoGenerate = true)
     private long id;
    private String drink;
    private String food;
    private String avatar;

    public MenuEntraces(long id, String drink, String food, String avatar) {
        this.id = id;
        this.drink = drink;
        this.food = food;
        this.avatar = avatar;
    }

    public String getDrink() {

        return drink;
    }

    public String getFood() {

        return food;
    }

    public String getAvatar() {
        return avatar;}

    public long getId() {
        return id;
    }
}

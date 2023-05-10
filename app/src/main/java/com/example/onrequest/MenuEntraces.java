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

    private Double food_price;
    private Double drink_price;

    public MenuEntraces(String drink, String food, String avatar, Double drink_price,Double food_price) {
        this.drink = drink;
        this.food = food;
        this.avatar = avatar;
        this.food_price = food_price;
        this.drink_price = drink_price;
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


    public Double getFood_price() {
        return food_price;
    }

    public Double getDrink_price() {
        return drink_price;
    }
}



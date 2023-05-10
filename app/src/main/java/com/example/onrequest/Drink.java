package com.example.onrequest;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Drink")
public class Drink {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "DrinkId")
    @NonNull
    private int DrinkId;

    @NonNull
    @ColumnInfo(name = "DrinkName")
    private String drinkName;

    @ColumnInfo(name = "Drinkprice")
    private Double drinkPrice;

    public Drink(int drinkId, @NonNull String drinkName, Double drinkPrice) {
        DrinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    public int getDrinkId() {
        return DrinkId;
    }

    public void setDrinkId(int drinkId) {
        DrinkId = drinkId;
    }

    @NonNull
    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(@NonNull String drinkName) {
        this.drinkName = drinkName;
    }

    public Double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(Double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
}

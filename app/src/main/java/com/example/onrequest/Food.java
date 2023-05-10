package com.example.onrequest;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Food")
public class Food {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "FoodId")
    @NonNull
    private int FoodId;

    @NonNull
    @ColumnInfo(name = "FoodName")
    private String foodName;

    @ColumnInfo(name = "FoodPrice")
    private Double foodPrice;


    public Food(int foodId, @NonNull String foodName, Double foodPrice) {
        FoodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getFoodId() {
        return FoodId;
    }

    public void setFoodId(int foodId) {
        FoodId = foodId;
    }

    @NonNull
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(@NonNull String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
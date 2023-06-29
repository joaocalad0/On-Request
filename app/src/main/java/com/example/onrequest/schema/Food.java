package com.example.onrequest.schema;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food implements MenuItem {

    private static final long serialVersionUID = 1L;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "foodId")
    private long foodId;

    @NonNull
    @ColumnInfo(name = "foodName")
    private String foodName;

    @NonNull
    @ColumnInfo(name = "foodPrice")
    private Double foodPrice;

    @NonNull
    @ColumnInfo(name = "foodAvatar")
    private Uri foodAvatar;

    public Food() {

    }

    public Food(long foodId, @NonNull String foodName, @NonNull Double foodPrice, @NonNull Uri uri) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodAvatar = uri;
    }

    public Food(@NonNull String foodName, @NonNull Double foodPrice, @NonNull Uri uri) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodAvatar = uri;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    @NonNull
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(@NonNull String foodName) {
        this.foodName = foodName;
    }

    @NonNull
    public Uri getFoodAvatar() {
        return foodAvatar;
    }

    @NonNull
    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(@NonNull Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodAvatar(@NonNull Uri foodAvatar) {
        this.foodAvatar = foodAvatar;
    }

    @Override
    public long getId() {
        return foodId;
    }

    @Override
    public Double getPrice() {
        return foodPrice;
    }

    @Override
    public String getName() {
        return foodName;
    }

    @Override
    public Uri getDrinkAvatar() {
        return foodAvatar;
    }
}
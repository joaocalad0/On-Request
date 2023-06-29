package com.example.onrequest.schema;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drink")
public class Drink implements MenuItem {

    private static final long serialVersionUID = 2L;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "drinkId")
    private long drinkId;

    @NonNull
    @ColumnInfo(name = "drinkName")
    private String drinkName;

    @NonNull
    @ColumnInfo(name = "drinkPrice")
    private Double drinkPrice;

    @NonNull
    @ColumnInfo(name = "drinkAvatar")
    private Uri drinkAvatar;

    public Drink() {

    }

    public Drink(long drinkId, @NonNull String drinkName, @NonNull Double drinkPrice, @NonNull Uri uri) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkAvatar = uri;
    }

    public Drink(@NonNull String drinkName, @NonNull Double drinkPrice, @NonNull Uri uri) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkAvatar = uri;
    }

    public long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    @NonNull
    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(@NonNull String drinkName) {
        this.drinkName = drinkName;
    }

    @NonNull
    public Double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(@NonNull Double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public void setDrinkAvatar(@NonNull Uri drinkAvatar) {
        this.drinkAvatar = drinkAvatar;
    }

    @Override
    public long getId() {
        return drinkId;
    }

    @Override
    public Double getPrice() {
        return drinkPrice;
    }

    @Override
    public String getName() {
        return drinkName;
    }

    @Override
    public Uri getDrinkAvatar() {
        return drinkAvatar;
    }
}

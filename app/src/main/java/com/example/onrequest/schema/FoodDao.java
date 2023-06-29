package com.example.onrequest.schema;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface FoodDao {

        @Query("SELECT * FROM food")
        List<Food> getAll();

        @Insert
        void insert(Food food);

        @Update
        void update(Food food);
    }


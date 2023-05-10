package com.example.onrequest;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


    @Dao
    public interface FoodDao {

        @Query("SELECT * FROM Food")
        List<Food> getAll();

        @Insert
        void insert(Food food);

        @Update
        void update(Food food);
    }


package com.example.onrequest;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface DrinkDao {

        @Query("SELECT * FROM Drink")
        List<Drink> getAll();

        @Insert
        void insert(Drink drink);

        @Update
        void update(Drink drink);
    }


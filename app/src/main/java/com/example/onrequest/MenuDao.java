package com.example.onrequest;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MenuDao {
    @Query("SELECT * FROM menu")
    List<Menu> getAll();

    @Query("SELECT * FROM menu WHERE id = :menuId")
    Menu getById(long menuId);

    @Insert
    void insert(Menu menu);

    @Insert
    void insert(List<Menu> menuList);

    @Update
    void update(Menu menu);
}


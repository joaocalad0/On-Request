package com.example.onrequest.schema;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MenuItemDao {

    @Query("SELECT * FROM menuitem")
    List<MenuItem> getAll();

    @Insert
    void insert(MenuItem menuItem);

    @Update
    void update(MenuItem menuItem);
}

package com.example.onrequest.schema.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onrequest.schema.entity.item.MenuItem;
import com.example.onrequest.schema.entity.item.MenuItemCategory;

import java.util.List;

@Dao
public interface MenuItemDao {

    @Query("SELECT * FROM menuitem")
    List<MenuItem> getAll();

    @Query("SELECT * FROM menuitem WHERE menuItemCategory = :category")
    List<MenuItem> getByCategory(MenuItemCategory category);

    @Insert
    long insert(MenuItem menuItem);

    @Update
    void update(MenuItem menuItem);

    @Delete
    void delete(MenuItem menuItem);
}

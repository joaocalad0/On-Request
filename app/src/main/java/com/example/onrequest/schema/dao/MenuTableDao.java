package com.example.onrequest.schema.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onrequest.schema.entity.table.MenuTable;

import java.util.List;

@Dao
public interface MenuTableDao {

    @Query("SELECT * FROM menutable WHERE menuTableId = :id")
    MenuTable getById(long id);

    @Query("SELECT * FROM menutable")
    List<MenuTable> getAll();

    @Insert
    void insert(MenuTable menuTable);

    @Update
    void update(MenuTable menuTable);

    @Delete
    void delete(MenuTable menuTable);
}

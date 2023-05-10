package com.example.onrequest;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MenuDao {
    @Query("SELECT * FROM MenuEntraces")
    List<MenuEntraces> getAll();

    @Query("SELECT * FROM MenuEntraces WHERE id = :menuId")
    MenuEntraces getById(long menuId);

    @Insert
    void insert(MenuEntraces menu);

    @Insert
    void insert(List<MenuEntraces> menuList);

    @Update
    void update(MenuEntraces menu);
}


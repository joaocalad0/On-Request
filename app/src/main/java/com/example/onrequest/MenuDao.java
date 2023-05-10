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

    @Query("SELECT * FROM MenuEntraces WHERE id = :Id")
    MenuEntraces getById(long Id);

    @Insert
    void insert(MenuEntraces menuEntraces);

    @Insert
    void insert(List<MenuEntraces> menuEntracesList);

    @Update
    void update(MenuEntraces menuEntraces);
}


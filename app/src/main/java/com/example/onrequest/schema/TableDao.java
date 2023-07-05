package com.example.onrequest.schema;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TableDao {

     @Query("SELECT * FROM menutable WHERE tableId = :id")
     MenuTable getById (long id);

     @Query("SELECT * FROM menutable")
     List<MenuTable> getAll ();

}

package com.example.onrequest.schema;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MenuTableDao {

     @Query("SELECT * FROM menutable WHERE tableId = :id")
     MenuTable getById (long id);

     @Query("SELECT * FROM menutable")
     List<MenuTable> getAll();

     @Query("SELECT * FROM MENUTABLE m INNER JOIN CART c ON c.cartId = m.cartId WHERE m.tableId = :tableId AND c.cartState = 'OPEN'")
     Cart getOpenCartByTable(long tableId);

     @Update
     void update(MenuTable menuTable);
}

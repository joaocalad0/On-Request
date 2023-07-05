package com.example.onrequest.schema;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CartDao {

    @Transaction
    @Query("SELECT * FROM cart")
    List<CartWithMenuItem> getAllCartsWithMenuItem();

    @Transaction
    @Query("SELECT * FROM cart where cartId = :id")
    List<CartWithMenuItem> getAllCartsWithMenuItem(long id);

    @Insert
    void insert(Cart cart);

}

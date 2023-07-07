package com.example.onrequest.schema;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartDao {

    @Query("SELECT * FROM cart where cartId = :cartId")
    Cart cartById(long cartId);

    @Transaction
    @Query("SELECT * FROM cart")
    List<CartWithMenuItem> getAllCartsWithMenuItem();

    @Transaction
    @Query("SELECT * FROM cart where cartId = :id")
    CartWithMenuItem getAllCartsWithMenuItem(long id);

    @Insert
    long insert(Cart cart);

    @Update
    void update(Cart cart);

}

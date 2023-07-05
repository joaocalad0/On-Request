package com.example.onrequest.schema;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class cartTable {

   @PrimaryKey(autoGenerate = true)
   private long cartTableId;


   @Nullable
   @ColumnInfo(name = "cartId")
   private long cartId;

        tableid
}

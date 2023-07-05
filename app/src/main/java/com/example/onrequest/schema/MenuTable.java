package com.example.onrequest.schema;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MenuTable implements Parcelable {

   @PrimaryKey(autoGenerate = true)
   private long tableId;

   @Nullable
   @ColumnInfo(name = "cartId")
   private Long cartId;

   public MenuTable(long tableId, Long cartId) {
      this.cartId = cartId;
      this.tableId = tableId;
   }

   protected MenuTable(Parcel in) {
      tableId = in.readLong();
      if (in.readByte() == 0) {
         cartId = null;
      } else {
         cartId = in.readLong();
      }
   }

   public static final Creator<MenuTable> CREATOR = new Creator<MenuTable>() {

      @Override
      public MenuTable createFromParcel(Parcel in) {
         return new MenuTable(in);
      }

      @Override
      public MenuTable[] newArray(int size) {
         return new MenuTable[size];
      }
   };

   @Nullable
   public Long getCartId() {
      return cartId;
   }

   public void setCartId(Long cartId) {
      this.cartId = cartId;
   }

   public long getTableId() {
      return tableId;
   }

   public void setTableId(long tableId) {
      this.tableId = tableId;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(@NonNull Parcel parcel, int i) {
      parcel.writeLong(tableId);
      if (cartId == null) {
         parcel.writeByte((byte) 0);
      } else {
         parcel.writeByte((byte) 1);
         parcel.writeLong(cartId);
      }
   }
}

package com.example.onrequest.schema;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Cart {

    @PrimaryKey(autoGenerate = true)
    private long cartId;

    @ColumnInfo(name = "menuItemId")
    private long menuItemId;

    public Cart(long cartId, long menuItemId) {
        this.cartId = cartId;
        this.menuItemId = menuItemId;
    }

    @Ignore
    public Cart(long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
    }
}

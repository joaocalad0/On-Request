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

    @ColumnInfo(name = "cartState")
    private CartState cartState;

    public Cart(long cartId, long menuItemId, CartState cartState) {
        this.cartId = cartId;
        this.menuItemId = menuItemId;
        this.cartState = cartState;
    }

    @Ignore
    public Cart(long menuItemId) {
        this.menuItemId = menuItemId;
        this.cartState = CartState.OPEN;
    }

    @Ignore
    public Cart() {
        this.cartState = CartState.OPEN;
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

    public CartState getCartState() {
        return cartState;
    }

    public void setCartState(CartState cartState) {
        this.cartState = cartState;
    }
}

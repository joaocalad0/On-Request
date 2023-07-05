package com.example.onrequest.schema;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class CartWithMenuItem {

    @Embedded
    public Cart cart;

    @Relation(
            parentColumn = "menuItemId",
            entityColumn = "menuItemId"
    )
    public List<MenuItem> menuItems;

    public CartWithMenuItem(Cart cart, List<MenuItem> menuItems) {
        this.cart = cart;
        this.menuItems = menuItems;
    }

    @Ignore
    public CartWithMenuItem(Cart cart, MenuItem menuItem) {
        this.cart = cart;
        List<MenuItem> menuItemList = new ArrayList<>(1);
        menuItemList.add(menuItem);
        this.menuItems = menuItemList;
    }
}

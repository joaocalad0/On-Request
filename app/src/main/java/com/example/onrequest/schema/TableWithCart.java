package com.example.onrequest.schema;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class TableWithCart {

    @Embedded
    public MenuTable menuTable;

    @Relation(
            parentColumn = "cartId",
            entityColumn = "cartId"
    )
    public List<Cart> carts;

    public TableWithCart(MenuTable menuTable, List<Cart> carts) {
        this.menuTable = menuTable;
        this.carts = carts;
    }
}

package com.example.onrequest.manager;

import android.content.Context;

import com.example.onrequest.schema.AppDatabase;
import com.example.onrequest.schema.Cart;
import com.example.onrequest.schema.CartDao;
import com.example.onrequest.schema.MenuItem;
import com.example.onrequest.schema.MenuTable;
import com.example.onrequest.schema.MenuTableDao;

public class CartManager {

    private final CartDao cartDao;

    private final MenuTableDao menuTableDao;

    private static CartManager INSTANCE;

    private CartManager(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        this.cartDao = appDatabase.getCartDao();
        this.menuTableDao = appDatabase.getMenuTableDao();
    }

    public static CartManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CartManager(context);
        }
        return INSTANCE;
    }

    public void addMenuItem(MenuTable menuTable, MenuItem menuItem) {
        Cart cart = menuTableDao.getOpenCartByTable(menuTable.getTableId());
        if (cart == null) {
            long cartId = cartDao.insert(new Cart());
            cart = cartDao.cartById(cartId);
            menuTable.setCartId(cartId);
            menuTableDao.update(menuTable);
        }
        cart.setMenuItemId(menuItem.getMenuItemId());
        cartDao.insert(cart);
    }

}

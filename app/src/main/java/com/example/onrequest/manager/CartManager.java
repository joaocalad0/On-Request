package com.example.onrequest.manager;

import android.content.Context;

import com.example.onrequest.schema.dao.CartDao;
import com.example.onrequest.schema.dao.MenuTableDao;
import com.example.onrequest.schema.db.AppDatabase;
import com.example.onrequest.schema.entity.cart.Cart;
import com.example.onrequest.schema.entity.cart.CartMenuItem;
import com.example.onrequest.schema.entity.cart.CartWithMenuItems;
import com.example.onrequest.schema.entity.item.MenuItem;
import com.example.onrequest.schema.entity.table.MenuTable;

import java.util.List;

public class CartManager {

    private final CartDao cartDao;

    private static CartManager INSTANCE;

    private CartManager(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        this.cartDao = appDatabase.getCartDao();
    }

    public static CartManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CartManager(context);
        }
        return INSTANCE;
    }

    public void addMenuItem(MenuTable menuTable, MenuItem menuItem) {
        Cart cart = getOpenCartByTable(menuTable);
        CartMenuItem cartMenuItem = new CartMenuItem(cart, menuItem);
        cartDao.insert(cartMenuItem);
    }

    public List<CartWithMenuItems> getCartWithMenuItemsByTable(MenuTable menuTable) {
        Cart cart = getOpenCartByTable(menuTable);
        return cartDao.getCartWithMenuItemByCartId(cart.getCartId());
    }

    public boolean isOpenCart(MenuTable menuTable) {
        return cartDao.getOpenCartByTable(menuTable.getMenuTableId()) != null;
    }

    private Cart getOpenCartByTable(MenuTable menuTable) {
        Cart cart = cartDao.getOpenCartByTable(menuTable.getMenuTableId());
        if (cart == null) {
            Cart newCart = new Cart(menuTable);
            long newCartId = cartDao.insert(newCart);
            return cartDao.getById(newCartId);
        }
        return cart;
    }

    public void payCart(Cart cart) {
        cart.pay();
        cartDao.update(cart);
    }

}

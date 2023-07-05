package com.example.onrequest.manager;

import android.content.Context;

import com.example.onrequest.schema.AppDatabase;
import com.example.onrequest.schema.CartDao;

public class CartManager {

    private final CartDao cartDao;

    private static CartManager INSTANCE;

    private CartManager(Context context) {
        this.cartDao = AppDatabase.getInstance(context).getCartDao();
    }

    public static CartManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CartManager(context);
        }
        return INSTANCE;
    }



}

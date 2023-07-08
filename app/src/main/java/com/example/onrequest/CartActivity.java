package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onrequest.manager.CartManager;
import com.example.onrequest.schema.entity.cart.CartWithMenuItems;
import com.example.onrequest.schema.entity.item.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartActivity extends AppCompatActivity {

    private static final String MENU_ITEM_CART = "menuItem";

    private CartManager cartManager;

    public static void startCartActivity(Context context, List<CartWithMenuItems> cartWithMenuItems) {
        Intent intent = new Intent(context, CartActivity.class);
        intent.putParcelableArrayListExtra(MENU_ITEM_CART, new ArrayList<>(cartWithMenuItems));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        this.cartManager = CartManager.getInstance(this);
        Intent intent = getIntent();
        CartWithMenuItemsPresenter menuItemCounter = new CartWithMenuItemsPresenter(intent.getParcelableArrayListExtra(MENU_ITEM_CART));
        if (!menuItemCounter.cartWithMenuItems.isEmpty()) {
            Map<MenuItem, Integer> counterMap = menuItemCounter.getContent();
            // TODO MOSTRAR DADOS DO CARRO
            counterMap.forEach(((menuItem, counter) -> {

            }));
            double cartTotal = menuItemCounter.total();

            Button checkout = findViewById(R.id.buttonCheckOut);
            checkout.setOnClickListener(view -> {
                if (!menuItemCounter.cartWithMenuItems.isEmpty()) {
                    cartManager.payCart(menuItemCounter.cartWithMenuItems.get(0).cart);
                }
                onBackPressed();
            });
        } else {
            finish();
        }
    }

    private static class CartWithMenuItemsPresenter {

        private List<CartWithMenuItems> cartWithMenuItems;

        public CartWithMenuItemsPresenter(List<CartWithMenuItems> cartWithMenuItems) {
            this.cartWithMenuItems = cartWithMenuItems;
        }

        public Map<MenuItem, Integer> getContent() {
            List<MenuItem> menuItemsInCart = cartWithMenuItems.stream().map(it -> it.menuItem)
                    .distinct()
                    .collect(Collectors.toList());
            Map<MenuItem, Integer> counterMap = new HashMap<>(menuItemsInCart.size() * 2);
            this.cartWithMenuItems.forEach(cartWithMenuItems -> {
                Integer counter = counterMap.get(cartWithMenuItems.menuItem) != null ? (counterMap.get(cartWithMenuItems.menuItem) + 1) : 1;
                counterMap.put(cartWithMenuItems.menuItem, counter);
            });
            return counterMap;
        }

        public double total() {
            return cartWithMenuItems.stream().mapToDouble(it -> it.menuItem.getMenuItemPrice()).sum();
        }
    }
}
package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.onrequest.schema.AppDatabase;
import com.example.onrequest.schema.Cart;
import com.example.onrequest.schema.CartDao;
import com.example.onrequest.schema.MenuItem;

public class MenuDetailsActivity extends AppCompatActivity {

    private static final String MENU_ITEM = "menuPosition";

    public static void startActivity(Context context, MenuItem menuItem) {
        Intent intent = new Intent(context, MenuDetailsActivity.class);
        intent.putExtra(MenuDetailsActivity.MENU_ITEM, menuItem);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onclick);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        CartDao cartDao = AppDatabase.getInstance(this).getCartDao();

        if (bundle != null) {
            MenuItem menuItem = (MenuItem) bundle.getParcelable(MENU_ITEM);
            ImageView imageViewAvatar = findViewById(R.id.imageView7);
            TextView textViewDrink = findViewById(R.id.textView2);
            TextView descTextView = findViewById(R.id.descTextView);
            descTextView.setText(menuItem.getMenuItemDesc());
            textViewDrink.setText(menuItem.getMenuItemName());
            Glide.with(this).load(menuItem.getMenuItemAvatar()).into(imageViewAvatar);
            View addButton = findViewById(R.id.button2);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cart cart = new Cart(menuItem.getMenuItemId());
                    cartDao.insert(cart);
                }
            });
        } else {
            finish();
        }


    }
}

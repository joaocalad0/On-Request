package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.onrequest.manager.CartManager;
import com.example.onrequest.schema.MenuItem;
import com.example.onrequest.schema.MenuTable;

public class MenuDetailsActivity extends AppCompatActivity {

    private static final String MENU_ITEM = "menuItem";
    private static final String MENU_TABLE = "menuTable";

    public static void startActivity(Context context, MenuTable menuTable, MenuItem menuItem) {
        Intent intent = new Intent(context, MenuDetailsActivity.class);
        intent.putExtra(MenuDetailsActivity.MENU_ITEM, menuItem);
        intent.putExtra(MenuDetailsActivity.MENU_TABLE, menuTable);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onclick);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            CartManager cartManager = CartManager.getInstance(this);
            MenuItem menuItem = (MenuItem) bundle.getParcelable(MENU_ITEM);
            MenuTable menuTable = (MenuTable) bundle.getParcelable(MENU_TABLE);
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
                    cartManager.addMenuItem(menuTable, menuItem);
                }
            });
        } else {
            finish();
        }


    }
}

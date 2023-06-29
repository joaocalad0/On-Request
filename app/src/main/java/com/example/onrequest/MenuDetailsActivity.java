package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
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
        setContentView(R.layout.activity_menu_details);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            MenuItem menuItem = (MenuItem) bundle.getSerializable(MENU_ITEM);
            ImageView imageViewAvatar = findViewById(R.id.imageViewAvatar);
            TextView textViewDrink = findViewById(R.id.textviewdrink);
            textViewDrink.setText(menuItem.getName());
            Glide.with(this).load(menuItem.getDrinkAvatar()).into(imageViewAvatar);
        } else {
            finish();
        }
    }
}

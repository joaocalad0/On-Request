package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MenuDetailsActivity extends AppCompatActivity {

    private static final String KEY_MENU_POSITION = "menuPosition";

    public static void startActivity(Context context, int position) {
        Intent intent = new Intent(context, MenuDetailsActivity.class);
        intent.putExtra(MenuDetailsActivity.KEY_MENU_POSITION, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null) {
            int position = bundle.getInt(KEY_MENU_POSITION, -1);
            MenuEntraces menu = MemoryDataBase.getAllMenus(position);
            ImageView imageViewAvatar = findViewById(R.id.imageViewAvatar);
            TextView textViewDrink = findViewById(R.id.textviewdrink);
            TextView textViewFood = findViewById(R.id.textviewfood);

            Glide.with(this).load(menu.getAvatar()).into(imageViewAvatar);
            textViewDrink.setText(menu.getDrink());
            textViewFood.setText(menu.getFood());
        } else {
            finish();
        }
    }
}

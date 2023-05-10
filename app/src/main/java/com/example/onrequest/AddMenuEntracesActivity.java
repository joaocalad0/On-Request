package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;

public class AddMenuEntracesActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent intent = new Intent(context, AddMenuEntracesActivity.class);
        intent.putExtra("Key1", 100);
        intent.putExtra("Key2", "Uma String Qualquer");
        context.startActivity(intent);
    }

    private EditText editTextFood;
    private EditText editTextDrink;
    private EditText editTextFood_price;
    private EditText editTextDrink_price;
    private EditText editTextAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_entraces);
        addFood();
        addDrink();


        //this.editTextName = findViewById(R.id.editTextName);
        //this.editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        //this.editTextAvatar = findViewById(R.id.editTextAvatar);
    }

    public void addFood(View view) {
        // save contact do Database and finish Activity
        String food = editTextFood_price.getText().toString();
        Double food_price = Double.valueOf(editTextFood_price.getText().toString());
        String avatar = editTextAvatar.getText().toString();

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        MenuDao menuDao = appDatabase.getMenuDao();
//        contactDao.insert(newContact);

        MenuEntraces menuEntraces = new MenuEntraces( food, 23, avatar);

        AppDatabase.getInstance(this).getMenuDao().insert(new MenuEntraces);
        finish();
    }

    public void addDrink(View view) {
        // save contact do Database and finish Activity
        String drink = this.editTextDrink_price.getText().toString();
        Double drink_price = Double.valueOf(this.editTextDrink_price.getText().toString());
        String avatar = this.editTextAvatar.getText().toString();

        MenuEntraces newMenuEntraces = new MenuEntraces(0, drink, drink_price, avatar);

//        AppDatabase appDatabase = AppDatabase.getInstance(this);
//        ContactDao contactDao = appDatabase.getContactDao();
//        contactDao.insert(newContact);

        AppDatabase.getInstance(this).getMenuDao().insert(new MenuEntraces);
        finish();
    }
}


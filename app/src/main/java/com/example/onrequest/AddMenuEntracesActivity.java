package com.example.onrequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        addFood(0);
        addDrink(0);


        //this.editTextName = findViewById(R.id.editTextName);
        //this.editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        //this.editTextAvatar = findViewById(R.id.editTextAvatar);
    }

    public void addFood(int view) {
        // save contact do Database and finish Activity
        String food = editTextFood_price.getText().toString();
        Double food_price = Double.valueOf(editTextFood_price.getText().toString());
        String avatar = editTextAvatar.getText().toString();

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        MenuDao menuDao = appDatabase.getMenuDao();
//        FoodDao.insert(newFodd);

        MenuEntraces menuEntraces = new MenuEntraces( food, 23, avatar);

        AppDatabase.getInstance(this).getMenuDao().insert(new MenuEntraces);
        finish();
    }

    public void addDrink(int view) {
        // save contact do Database and finish Activity
        String drink = this.editTextDrink_price.getText().toString();
        Double drink_price = Double.valueOf(this.editTextDrink_price.getText().toString());
        String avatar = this.editTextAvatar.getText().toString();

        MenuEntraces newMenuEntraces = new MenuEntraces(drink, 22, avatar);

//        AppDatabase appDatabase = AppDatabase.getInstance(this);
//        ContactDao contactDao = appDatabase.getContactDao();
//        contactDao.insert(newContact);

        AppDatabase.getInstance(this).getMenuDao().insert(new MenuEntraces);
        finish();
    }
}


package com.example.onrequest;

import static com.example.onrequest.schema.MenuItemCategory.DRINK;
import static com.example.onrequest.schema.MenuItemCategory.FOOD;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onrequest.schema.AppDatabase;
import com.example.onrequest.schema.MenuItem;
import com.example.onrequest.schema.MenuItemDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obter uma referência para a RecyclerView que existe no layout da MainActivity4
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        MenuItemDao menuItemDao = appDatabase.getMenuItemDao();
        List<MenuItem> all = menuItemDao.getAll();
        List<MenuItem> food = menuItemDao.getByCategory(FOOD);
        List<MenuItem> drink = menuItemDao.getByCategory(DRINK);



        // criar um objeto do tipo MenuAdapter (que extende Adapter)
        MenuAdapter adapter = new MenuAdapter(all);

        // criar um objecto do tipo LinearLayoutManager para ser utilizado na RecyclerView
        // o LinearLayoutManager tem como orientação default a orientação Vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Definir que a RecyclerView utiliza como Adapter o objeto que criámos anteriormente
        recyclerView.setAdapter(adapter);

        // Definir que a RecyclerView utiliza como LayoutManager o objeto que criámos anteriormente
        recyclerView.setLayoutManager(layoutManager);


        Button buttonAll = findViewById(R.id.buttonAll);
        Button buttonFood = findViewById(R.id.buttonFood);
        Button buttonDrink = findViewById(R.id.buttonDrink);

       buttonAll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               adapter.refresh(all);
           }
       });

       buttonFood.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               adapter.refresh(food);
           }
       });

       buttonDrink.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               adapter.refresh(drink);
           }
       });

    }

}
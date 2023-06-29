package com.example.onrequest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onrequest.schema.AppDatabase;
import com.example.onrequest.schema.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obter uma referência para a RecyclerView que existe no layout da MainActivity4
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        List<MenuItem> drinkItems = new ArrayList<>(appDatabase.getDrinkDao().getAll());
        List<MenuItem> foodItems = new ArrayList<>(appDatabase.getFoodDao().getAll());
        List<MenuItem> menuItems = new ArrayList<>(drinkItems.size() + foodItems.size());
        menuItems.addAll(drinkItems);
        menuItems.addAll(foodItems);

        // criar um objeto do tipo MenuAdapter (que extende Adapter)
        MenuNewAdapter adapter = new MenuNewAdapter(menuItems);

        // criar um objecto do tipo LinearLayoutManager para ser utilizado na RecyclerView
        // o LinearLayoutManager tem como orientação default a orientação Vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Definir que a RecyclerView utiliza como Adapter o objeto que criámos anteriormente
        recyclerView.setAdapter(adapter);
        // Definir que a RecyclerView utiliza como LayoutManager o objeto que criámos anteriormente
        recyclerView.setLayoutManager(layoutManager);

    }
}
package com.example.onrequest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Definir uma lista de Menu (em memória) para ser apresentada na RecyclerView
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Carlos Sancho", "12345678"));
        menuList.add(new Menu("ABC", "12345678"));
        menuList.add(new Menu("aaaa", "hdhdhdh"));
        menuList.add(new Menu("XYZ", "12345678"));
        menuList.add(new Menu("Menu 1", "12345678"));

        // obter uma referência para a RecyclerView que existe no layout da MainActivity4
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // criar um objeto do tipo MenuAdapter (que extende Adapter)
        MenuAdapter adapter = new MenuAdapter(menuList);
        // criar um objecto do tipo LinearLayoutManager para ser utilizado na RecyclerView
        // o LinearLayoutManager tem como orientação default a orientação Vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Definir que a RecyclerView utiliza como Adapter o objeto que criámos anteriormente
        recyclerView.setAdapter(adapter);
        // Definir que a RecyclerView utiliza como LayoutManager o objeto que criámos anteriormente
        recyclerView.setLayoutManager(layoutManager);

    }
}
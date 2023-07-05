package com.example.onrequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onrequest.schema.AppDatabase;
import com.example.onrequest.schema.TableDao;

public class tables_activity extends AppCompatActivity {

    private TableDao tableDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tableDao = AppDatabase.getInstance(this).getTableDao();

        setContentView(R.layout.tables_activity);

        Button table1 = findViewById(R.id.table1);
        Button table2 = findViewById(R.id.table2);
        Button table3 = findViewById(R.id.table3);
        Button table4 = findViewById(R.id.table4);
        Button table5 = findViewById(R.id.table5);
        Button table6 = findViewById(R.id.table6);

        table1.setOnClickListener(buttonOnClick(1));
        table2.setOnClickListener(buttonOnClick(2));
        table3.setOnClickListener(buttonOnClick(3));
        table4.setOnClickListener(buttonOnClick(4));
        table5.setOnClickListener(buttonOnClick(5));
        table6.setOnClickListener(buttonOnClick(6));
    }

   private View.OnClickListener buttonOnClick(long tableId) {
       return view -> {
           Intent menuIntent = new Intent(this, MainActivity.class);
           menuIntent.putExtra("table", tableDao.getById(tableId));
           startActivity(menuIntent);
       };
   }


}
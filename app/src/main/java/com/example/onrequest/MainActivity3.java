package com.example.onrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void table1 (View view) {
        Intent table1 = new Intent(this, MainActivity4.class);
        startActivity(table1);
    }

    public void table2 (View view) {
        Intent table2 = new Intent(this, MainActivity4.class);
        startActivity(table2);
    }

    public void table3 (View view) {
        Intent table3 = new Intent(this, MainActivity4.class);
        startActivity(table3);
    }

    public void table4 (View view) {
        Intent table4 = new Intent(this, MainActivity4.class);
        startActivity(table4);
    }

    public void table5 (View view) {
        Intent table5 = new Intent(this, MainActivity4.class);
        startActivity(table5);
    }

    public void table6 (View view) {
        Intent table6 = new Intent(this, MainActivity4.class);
        startActivity(table6);
    }
}
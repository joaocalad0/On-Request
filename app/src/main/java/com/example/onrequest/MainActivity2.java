package com.example.onrequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void submit (View view) {
        Intent submit = new Intent(this, MainActivity3.class);
        startActivity(submit);
    }

    public void forgot (View view) {
        Intent forgot = new Intent(this, CreateAccount.class);
        startActivity(forgot);
    }
}
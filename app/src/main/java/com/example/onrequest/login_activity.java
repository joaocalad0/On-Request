package com.example.onrequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void submit (View view) {
        Intent submit = new Intent(this, tables_activity.class);
        startActivity(submit);
    }

    public void forgot (View view) {
        Intent forgot = new Intent(this, CreateAccount.class);
        startActivity(forgot);
    }
}
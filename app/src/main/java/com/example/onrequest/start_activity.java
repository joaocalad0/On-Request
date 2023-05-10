package com.example.onrequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    public void imageView1 (View view) {
        Intent imageView1 = new Intent(this, login_activity.class);
        startActivity(imageView1);
    }
}
package com.azcodeur.nectar.Identification;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azcodeur.nectar.R;

public class LocationActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        findViewById(R.id.valid_btn)
                .setOnClickListener(v -> {
                    startActivity(new Intent(this, LoginActivity.class));
                });
    }

    public void back(View view) {
        onBackPressed();
    }
}
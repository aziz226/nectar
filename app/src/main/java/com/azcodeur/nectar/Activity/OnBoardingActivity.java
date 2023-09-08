package com.azcodeur.nectar.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azcodeur.nectar.Identification.SignInActivity;
import com.azcodeur.nectar.R;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        findViewById(R.id.get_started)
                .setOnClickListener(v -> {
                    startActivity(new Intent(this, SignInActivity.class));
                });
    }
}
package com.azcodeur.nectar.Activity;//package com.azcodeur.nectar.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.azcodeur.nectar.MainActivity;
import com.azcodeur.nectar.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));//OnBoardingActivity.class));
        }, 5000);

    }

}
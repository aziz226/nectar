package com.azcodeur.nectar.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

import com.azcodeur.nectar.R;

public class OderAcceptedActivity extends AppCompatActivity {

    private ConstraintLayout trackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_accepted);
    }

    public void backpressed(View view) {
        onBackPressed();
    }
}
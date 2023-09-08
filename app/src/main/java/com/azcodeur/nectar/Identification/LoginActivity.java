package com.azcodeur.nectar.Identification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.azcodeur.nectar.MainActivity;
import com.azcodeur.nectar.R;

public class LoginActivity extends AppCompatActivity {

    private ConstraintLayout logBtn;
    private EditText email, password;
    private TextView goToSignUp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logBtn= findViewById(R.id.login_btn);
        email= findViewById(R.id.id_lemail);
        password= findViewById(R.id.id_lpass);
        goToSignUp= findViewById(R.id.sign_up);

        goToSignUp.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });

        logBtn.setOnClickListener(v -> {
          startActivity(new Intent(this, MainActivity.class));
        });
    }
}
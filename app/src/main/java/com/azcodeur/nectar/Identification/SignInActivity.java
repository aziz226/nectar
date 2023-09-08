package com.azcodeur.nectar.Identification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.azcodeur.nectar.R;
import com.hbb20.CountryCodePicker;

public class SignInActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private TextView phoneInput;
    private Button sendOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        phoneInput = findViewById(R.id.login_mobile_number);

        phoneInput.setOnClickListener(v -> {
            startActivity(new Intent(this, PhoneActivity.class));
        });
    }
}
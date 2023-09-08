package com.azcodeur.nectar.Identification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.azcodeur.nectar.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText uname, email, password;
    private TextView policy, goToLoginBtn;
    private ConstraintLayout signUpBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        uname= findViewById(R.id.id_username);
        email= findViewById(R.id.id_semail);
        password= findViewById(R.id.id_spass);
        policy= findViewById(R.id.policy);
        goToLoginBtn= findViewById(R.id.log_in);
        signUpBtn= findViewById(R.id.signup_btn);

        PrivacyPolicy();

        goToLoginBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });

        signUpBtn.setOnClickListener(v -> {
            //startActivity(new Intent(this, SignUpActivity.class));
        });

    }

    private void PrivacyPolicy() {
        // Créez une instance de SpannableString avec votre phrase complète
        String phrase = getString(R.string.en_continuant_vous_reconnaissez_d_avoir_lu_et_accepter_les_termes_conditions_d_utilisation_et_la_politique_de_confidentialit);
        SpannableString spannableString = new SpannableString(phrase);

// Définissez les parties du texte à rendre cliquables
        String clickableText1 = getString(R.string.les_termes_conditions);
        String clickableText2 = getString(R.string.la_politique_de_confidentialit);

// Trouvez les index de début et de fin des parties cliquables
        int startIndex1 = phrase.indexOf(clickableText1);
        int endIndex1 = startIndex1 + clickableText1.length();

        int startIndex2 = phrase.indexOf(clickableText2);
        int endIndex2 = startIndex2 + clickableText2.length();

// Créez un ClickableSpan pour gérer le clic et les styles du texte cliquable
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Code à exécuter lorsque la partie du texte est cliquée
                Toast.makeText(SignUpActivity.this, "Termes & conditions d'utilisation cliqués!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // Modifiez les styles du texte cliquable
                ds.setColor(Color.GREEN); // Couleur rouge
                ds.setUnderlineText(true);
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Code à exécuter lorsque la partie du texte est cliquée
                Toast.makeText(SignUpActivity.this, "Politique de confidentialité cliquée!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // Modifiez les styles du texte cliquable
                ds.setColor(Color.GREEN); // Couleur bleue
                ds.setUnderlineText(true);
            }
        };

// Ajoutez les ClickableSpans à la SpannableString pour les plages de caractères spécifiées
        spannableString.setSpan(clickableSpan1, startIndex1, endIndex1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan2, startIndex2, endIndex2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// Définissez le texte dans le TextView
        policy.setText(spannableString);

// Activez la prise en charge du clic sur le texte
        policy.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void back(View view) {
        onBackPressed();
    }
}
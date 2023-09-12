package com.azcodeur.nectar.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Activity.OderAcceptedActivity;
import com.azcodeur.nectar.Adapter.CartAdapter;
import com.azcodeur.nectar.Adapter.PostAdapter;
import com.azcodeur.nectar.Identification.SignUpActivity;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private ConstraintLayout btnCheckOut, paimentLayout, paieValidateBtn;
    private TextView totalPrice, policy;
    private CartAdapter postAdapter;
    private ArrayList<PostModel> list;
    private ImageView checkoutClose;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView= view.findViewById(R.id.cart_recycler_view);
        btnCheckOut= view.findViewById(R.id.id_checkout);
        totalPrice= view.findViewById(R.id.cart_total_price);
        policy= view.findViewById(R.id.cart_policy);
        paimentLayout= view.findViewById(R.id.paiement_layout);
        checkoutClose= view.findViewById(R.id.checkout_close);
        paieValidateBtn= view.findViewById(R.id.place_order);

        paimentLayout.setVisibility(View.GONE);

        list= new ArrayList<>();

        list.add(new PostModel("", "Orange mur", "2kg, priced", "3000"));
        list.add(new PostModel("", "Pasteque", "6kg, priced", "1500"));
        list.add(new PostModel("", "Pomme rouge", "1kg, priced", "800"));
        list.add(new PostModel("", "Bannane", "8kg", "8000"));
        list.add(new PostModel("", "Mangue", "1.5kg", "1850"));
        list.add(new PostModel("", "Fraise", "8kg", "3550"));

        postAdapter= new CartAdapter(getActivity(), list);

        PostRecycler();
        PrivacyPolicy();

        btnCheckOut.setOnClickListener(v -> {
            paimentLayout.setVisibility(View.VISIBLE);
        });
        checkoutClose.setOnClickListener(v -> {
            paimentLayout.setVisibility(View.GONE);
        });
        paieValidateBtn.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), OderAcceptedActivity.class));
        });

        return view;
    }

    private void PostRecycler() {
        LinearLayoutManager manager= new LinearLayoutManager(getActivity());
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(postAdapter);
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
                Toast.makeText(getActivity(), "Termes & conditions d'utilisation cliqués!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // Modifiez les styles du texte cliquable
                ds.setColor(Color.BLACK); // Couleur rouge
                ds.setUnderlineText(true);
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Code à exécuter lorsque la partie du texte est cliquée
                Toast.makeText(getActivity(), "Politique de confidentialité cliquée!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // Modifiez les styles du texte cliquable
                ds.setColor(Color.BLACK); // Couleur bleue
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
}

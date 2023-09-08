package com.azcodeur.nectar.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.azcodeur.nectar.R;

public class ProductDetail extends AppCompatActivity {

    private ImageView plusBtn, moinsBtn;
    private TextView productNum, productPrice;
    private int minimal_command= 1, price= 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        plusBtn= findViewById(R.id.plus_btn);
        moinsBtn= findViewById(R.id.moins_btn);
        productNum= findViewById(R.id.product_num);
        productPrice= findViewById(R.id.prod_price);

        productNum.setText(""+minimal_command);
        productPrice.setText(""+price+" FCFA");

        plusBtn.setOnClickListener(v -> {
            minimal_command++;
            productNum.setText(String.valueOf(minimal_command));
            productPrice.setText(String.valueOf(price*minimal_command)+" FCFA");
        });
        moinsBtn.setOnClickListener(v -> {
            if (minimal_command>1){
                minimal_command--;
                productNum.setText(String.valueOf(minimal_command));
                productPrice.setText(String.valueOf(price*minimal_command)+" FCFA");
            }
        });

        //productNum.setText(""+minimal_command);

        if (minimal_command> 1){
            // Obtenez une référence au vecteur drawable
            Drawable drawable = getResources().getDrawable(R.drawable.ic_moin);
            // Changez la teinte en vert
            drawable.setColorFilter(getResources().getColor(android.R.color.holo_green_light), PorterDuff.Mode.SRC_IN);
            // Appliquez le drawable modifié à votre vue
            moinsBtn.setImageDrawable(drawable);
        }
    }

    public void backpressed(View view) {
        onBackPressed();
    }
}
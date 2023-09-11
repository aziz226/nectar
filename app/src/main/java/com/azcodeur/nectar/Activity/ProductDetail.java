package com.azcodeur.nectar.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.azcodeur.nectar.Adapter.SliderAdapter;
import com.azcodeur.nectar.Adapter.SliderDetailAdapter;
import com.azcodeur.nectar.Model.SliderModel;
import com.azcodeur.nectar.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class ProductDetail extends AppCompatActivity {

    private ImageView plusBtn, moinsBtn;
    private TextView productNum, productPrice;
    private int minimal_command= 1, price= 100;
    private SliderDetailAdapter adapter;
    private ArrayList<SliderModel> sliderDataArrayList;
    private SliderView sliderView;

    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        plusBtn= findViewById(R.id.plus_btn);
        moinsBtn= findViewById(R.id.moins_btn);
        productNum= findViewById(R.id.product_num);
        productPrice= findViewById(R.id.prod_price);
        sliderView = findViewById(R.id.slider_detail);

        sliderDataArrayList = new ArrayList<>();

        sliderDataArrayList.add(new SliderModel(url1, "Huile naturel", "Solde a 45%"));
        sliderDataArrayList.add(new SliderModel(url2, "Macaronie de France", "Livraison gratuite"));
        sliderDataArrayList.add(new SliderModel(url3, "Coca-cola de retout", "2000f pour 6 Boites"));

        adapter = new SliderDetailAdapter(this, sliderDataArrayList);
        SliderRecycler();

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

    private void SliderRecycler() {
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        sliderView.setSliderAdapter(adapter);

        //sliderView.setScrollTimeInSec(10);

        //sliderView.setAutoCycle(true);
        //sliderView.startAutoCycle();
    }
}
package com.azcodeur.nectar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.azcodeur.nectar.Fragment.AccountFragment;
import com.azcodeur.nectar.Fragment.CartFragment;
import com.azcodeur.nectar.Fragment.ExploreFragment;
import com.azcodeur.nectar.Fragment.FavoriteFragment;
import com.azcodeur.nectar.Fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.id_bttnav);

        ReplaceFrag(new ShopFragment());


        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId()== R.id.id_shop){
                ReplaceFrag(new ShopFragment());
            }else if (item.getItemId()== R.id.id_expo){
                ReplaceFrag(new ExploreFragment());
            }else if (item.getItemId()== R.id.id_cart){
                ReplaceFrag(new CartFragment());
            }else if (item.getItemId()== R.id.id_fav){
                ReplaceFrag(new FavoriteFragment());
            }else if (item.getItemId()== R.id.id_acc){
                ReplaceFrag(new AccountFragment());
            }

            return true;
        });
    }

    private void ReplaceFrag(Fragment fragment){
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        //.setReorderingAllowed(false);
        transaction.replace(R.id.id_framlay, fragment);
        transaction.commit();
    }
}
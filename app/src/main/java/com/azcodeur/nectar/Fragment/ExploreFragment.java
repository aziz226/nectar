package com.azcodeur.nectar.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Adapter.ExpoAdapter;
import com.azcodeur.nectar.Adapter.GrocerieAdapter;
import com.azcodeur.nectar.Model.ExpoModel;
import com.azcodeur.nectar.Model.GrocerieModel;
import com.azcodeur.nectar.Model.SliderModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class ExploreFragment extends Fragment {

    private ExpoAdapter grocerieAdapter;
    private ArrayList<GrocerieModel> grocerieList;
    private RecyclerView grocRecyc;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        grocerieList= new ArrayList<>();

        grocRecyc= view.findViewById(R.id.id_expo_recy);

        grocerieList.add(new GrocerieModel("ic_fruits", getString(R.string.fruits_l_gumes_frais), "cat_1" ));
        grocerieList.add(new GrocerieModel("ic_huile", getString(R.string.huile_de_cuisson_ghee), "cat_2"));
        grocerieList.add(new GrocerieModel("ic_fish", getString(R.string.viande_poisson), "cat_3"));
        grocerieList.add(new GrocerieModel("ic_pain", getString(R.string.boulangerie_snacks), "cat_4"));
        grocerieList.add(new GrocerieModel("ic_egg", getString(R.string.produits_laitiers_et_ufs), "cat_5"));
        grocerieList.add(new GrocerieModel("ic_boisson", getString(R.string.boissons), "cat_1"));

        grocerieAdapter= new ExpoAdapter(getActivity(), grocerieList);

        ExpoRecycler();
        return view;
    }

    private void ExpoRecycler() {
        GridLayoutManager manager= new GridLayoutManager(getActivity(), 2);
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
       // manager.setReverseLayout(true);
        //manager.setStackFromEnd(true);
        grocRecyc.setLayoutManager(manager);
        grocRecyc.setAdapter(grocerieAdapter);
    }
}

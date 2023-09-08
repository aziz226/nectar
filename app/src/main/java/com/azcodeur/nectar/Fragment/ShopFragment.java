package com.azcodeur.nectar.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Adapter.GrocerieAdapter;
import com.azcodeur.nectar.Adapter.PostAdapter;
import com.azcodeur.nectar.Adapter.SliderAdapter;
import com.azcodeur.nectar.Model.GrocerieModel;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.Model.SliderModel;
import com.azcodeur.nectar.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class ShopFragment extends Fragment {

    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";

    private RecyclerView recyclerView, sellingRecyc, grocRecyc, grocVertRecyc;
    private ArrayList<PostModel> list;
    private PostAdapter postAdapter;
    private SliderView sliderView;
    private SliderAdapter adapter;
    private GrocerieAdapter grocerieAdapter;
    private ArrayList<SliderModel> sliderDataArrayList;
    private ArrayList<GrocerieModel> grocerieList;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);


        sliderDataArrayList = new ArrayList<>();
        list= new ArrayList<>();
        grocerieList= new ArrayList<>();


        sliderView = view.findViewById(R.id.slider);
        recyclerView= view.findViewById(R.id.offer_recyc);
        sellingRecyc= view.findViewById(R.id.selling_recyc);
        grocRecyc= view.findViewById(R.id.grocerie_recyc);
        grocVertRecyc= view.findViewById(R.id.grocerie_Vert_recyc);

        sliderDataArrayList.add(new SliderModel(url1, "Huile naturel", "Solde a 45%"));
        sliderDataArrayList.add(new SliderModel(url2, "Macaronie de France", "Livraison gratuite"));
        sliderDataArrayList.add(new SliderModel(url3, "Coca-cola de retout", "2000f pour 6 Boites"));

        adapter = new SliderAdapter(getActivity(), sliderDataArrayList);

        list.add(new PostModel("", "Orange mur", "2kg, priced", "$50.00"));
        list.add(new PostModel("", "Pasteque", "6kg, priced", "$6.99"));
        list.add(new PostModel("", "Pomme rouge", "1kg, priced", "$9.99"));
        list.add(new PostModel("", "Bannane", "8kg", "$7.99"));

        postAdapter= new PostAdapter(getActivity(), list);

        grocerieList.add(new GrocerieModel("ic_snadimg", "Pouler", "cat_1" ));
        grocerieList.add(new GrocerieModel("ic_snadimg", "Boeuf", "cat_2"));
        grocerieList.add(new GrocerieModel("ic_snadimg", "Mouton", "cat_3"));
        grocerieList.add(new GrocerieModel("ic_snadimg", "Pintade", "cat_4"));
        grocerieList.add(new GrocerieModel("ic_snadimg", "Lapin", "cat_5"));

        grocerieAdapter= new GrocerieAdapter(getActivity(), grocerieList);

        list.add(new PostModel("", "Orange mur", "2kg, priced", "$50.00"));
        list.add(new PostModel("", "Pasteque", "6kg, priced", "$6.99"));
        list.add(new PostModel("", "Pomme rouge", "1kg, priced", "$9.99"));
        list.add(new PostModel("", "Bannane", "8kg", "$7.99"));

        postAdapter= new PostAdapter(getActivity(), list);

       PostRecycler();
       SliderRecycler();
       SellingRecycler();
       GroceriesRecycler();
       GroceriesVertRecycler();

        return view;
    }

    private void GroceriesVertRecycler() {
        LinearLayoutManager manager= new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        grocVertRecyc.setLayoutManager(manager);
        grocVertRecyc.setAdapter(postAdapter);
    }

    private void GroceriesRecycler() {
        LinearLayoutManager manager= new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        grocRecyc.setLayoutManager(manager);
        grocRecyc.setAdapter(grocerieAdapter);
    }

    private void SellingRecycler() {
        LinearLayoutManager manager= new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        sellingRecyc.setLayoutManager(manager);
        sellingRecyc.setAdapter(postAdapter);
    }

    private void SliderRecycler() {
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        sliderView.setSliderAdapter(adapter);

        sliderView.setScrollTimeInSec(10);

        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    private void PostRecycler() {
        LinearLayoutManager manager= new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(postAdapter);
    }
}

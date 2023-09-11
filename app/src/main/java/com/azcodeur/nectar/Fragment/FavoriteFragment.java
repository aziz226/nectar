package com.azcodeur.nectar.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Adapter.CartAdapter;
import com.azcodeur.nectar.Adapter.FavAdapter;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private ConstraintLayout btnAddAllCart;
    private ArrayList<PostModel> list;
    private FavAdapter postAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView= view.findViewById(R.id.fav_recycler_view);
        btnAddAllCart= view.findViewById(R.id.id_add_all_cart);

        list= new ArrayList<>();

        list.add(new PostModel("", "Orange mur", "2kg, priced", "3000 FCFA"));
        list.add(new PostModel("", "Pasteque", "6kg, priced", "1500 FCFA"));
        list.add(new PostModel("", "Pomme rouge", "1kg, priced", "800 FCFA"));
        list.add(new PostModel("", "Bannane", "8kg", "8000 FCFA"));
        list.add(new PostModel("", "Mangue", "1.5kg", "1850 FCFA"));
        list.add(new PostModel("", "Fraise", "8kg", "3550 FCFA"));

        postAdapter= new FavAdapter(getActivity(), list);

        PostRecycler();

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
}
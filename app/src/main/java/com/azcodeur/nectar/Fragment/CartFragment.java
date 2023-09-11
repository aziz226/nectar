package com.azcodeur.nectar.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Adapter.CartAdapter;
import com.azcodeur.nectar.Adapter.PostAdapter;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private ConstraintLayout btnCheckOut;
    private TextView totalPrice;
    private CartAdapter postAdapter;
    private ArrayList<PostModel> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView= view.findViewById(R.id.cart_recycler_view);
        btnCheckOut= view.findViewById(R.id.id_checkout);
        totalPrice= view.findViewById(R.id.cart_total_price);

        list= new ArrayList<>();

        list.add(new PostModel("", "Orange mur", "2kg, priced", "3000"));
        list.add(new PostModel("", "Pasteque", "6kg, priced", "1500"));
        list.add(new PostModel("", "Pomme rouge", "1kg, priced", "800"));
        list.add(new PostModel("", "Bannane", "8kg", "8000"));
        list.add(new PostModel("", "Mangue", "1.5kg", "1850"));
        list.add(new PostModel("", "Fraise", "8kg", "3550"));

        postAdapter= new CartAdapter(getActivity(), list);

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

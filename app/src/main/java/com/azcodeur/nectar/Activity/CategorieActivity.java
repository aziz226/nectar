package com.azcodeur.nectar.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azcodeur.nectar.Adapter.PostAdapter;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class CategorieActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<PostModel> list;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);

        list= new ArrayList<>();
        recyclerView= findViewById(R.id.cate_recyc);

        list.add(new PostModel("", "Orange mur", "2kg, priced", "$50.00"));
        list.add(new PostModel("", "Pasteque", "6kg, priced", "$6.99"));
        list.add(new PostModel("", "Pomme rouge", "1kg, priced", "$9.99"));
        list.add(new PostModel("", "Bannane", "8kg", "$7.99"));

        postAdapter= new PostAdapter(this, list);
        PostRecycler();

    }

    private void PostRecycler() {
        GridLayoutManager manager= new GridLayoutManager(this, 2);
        /*manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true); */
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(postAdapter);
    }

    public void Filter(View view) {
        startActivity(new Intent(this, FilterActivity.class));
    }

    public void backpressed(View view) {
        onBackPressed();
    }
}
package com.azcodeur.nectar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Activity.ProductDetail;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.Model.SliderModel;
import com.azcodeur.nectar.R;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    Context context;
    ArrayList<PostModel> list;

    public PostAdapter(Context context, ArrayList<PostModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PostModel sliderItem = list.get(position);

        // Glide is use to load image
        // from url in your imageview.
        /*Glide.with(context)
                .load(sliderItem.getImgPic())
                .fitCenter()
                .into(holder.picture); */

        holder.title.setText(sliderItem.getTitle());
        holder.description.setText(sliderItem.getDescription());
        holder.tvPrice.setText(sliderItem.getPrice());


        int color = ContextCompat.getColor(context, R.color.white);
        holder.floating.setImageTintList(ColorStateList.valueOf(color));
        //close.setImageTintList(ColorStateList.valueOf(color));

        holder.floating.setOnClickListener(v -> {
            Toast.makeText(context, sliderItem.getTitle(), Toast.LENGTH_SHORT).show();
        });

        holder.layout.setOnClickListener(v -> {
            Intent intent= new Intent(context.getApplicationContext(), ProductDetail.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView picture;
        TextView title, description, tvPrice;
        FloatingActionButton floating;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.id_post_pic);
            title= itemView.findViewById(R.id.id_post_name);
            description= itemView.findViewById(R.id.id_post_desc);
            tvPrice= itemView.findViewById(R.id.price);
            floating= itemView.findViewById(R.id.floatingActionButton);
            layout= itemView.findViewById(R.id.id_post_lay);

        }
    }
}

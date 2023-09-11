package com.azcodeur.nectar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.CartViewHolderAdapter> {
    Context context;
    ArrayList<PostModel> list;

    public FavAdapter(Context context, ArrayList<PostModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FavAdapter.CartViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fav_layout, parent, false);
        return new FavAdapter.CartViewHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.CartViewHolderAdapter holder, int position) {

        final PostModel sliderItem = list.get(position);

        // Glide is use to load image
        // from url in your imageview.
        /*Glide.with(context)
                .load(sliderItem.getImgPic())
                .fitCenter()
                .into(holder.picture); */

        holder.proName.setText(sliderItem.getTitle());
        holder.proDesc.setText(sliderItem.getDescription());
        holder.proPrice.setText(sliderItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartViewHolderAdapter extends RecyclerView.ViewHolder {
        ImageView proPic;
        TextView proName, proDesc, proPrice;
        ConstraintLayout layout;
        public CartViewHolderAdapter(@NonNull View itemView) {
            super(itemView);

            proPic= itemView.findViewById(R.id.fav_pro_pic);
            proName= itemView.findViewById(R.id.fav_pro_name);
            proDesc= itemView.findViewById(R.id.fav_pro_desc);
            proPrice= itemView.findViewById(R.id.fav_pro_price);
            layout= itemView.findViewById(R.id.fav_lay);

        }
    }
}

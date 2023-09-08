package com.azcodeur.nectar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.azcodeur.nectar.Model.ExpoModel;
import com.azcodeur.nectar.Model.GrocerieModel;
import com.azcodeur.nectar.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ExpoAdapter extends RecyclerView.Adapter<ExpoAdapter.ViewHolder>{
    Context context;
    ArrayList<GrocerieModel> categoryDomains;

    public ExpoAdapter(Context context, ArrayList<GrocerieModel> categoryDomains) {
        this.categoryDomains = categoryDomains;
        this.context= context;
    }

    @NonNull
    @Override
    public ExpoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.expo_layout,
                parent, false);
        return new ExpoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpoAdapter.ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getName());
        String picUrl= categoryDomains.get(position).getPic();
        String title= "";
        switch (position) {
            case 0:
                title="cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder
                        .itemView.getContext(), com.azcodeur.nectar.R.drawable.cat_back));
                break;
            case 1:
                title="cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder
                        .itemView.getContext(), com.azcodeur.nectar.R.drawable.cat_back2));
                break;
            case 2:
                title="cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder
                        .itemView.getContext(), com.azcodeur.nectar.R.drawable.cat_back3));
                break;
            case 3:
                title="cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder
                        .itemView.getContext(), com.azcodeur.nectar.R.drawable.cat_back4));
                break;
            case 4:
                title="cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder
                        .itemView.getContext(), com.azcodeur.nectar.R.drawable.cat_back5));
                break;
        }

        int drawableRessourceId = holder.itemView.getContext().getResources().getIdentifier(
                picUrl, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableRessourceId)
                .into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName= itemView.findViewById(R.id.id_expo_name);
            categoryPic= itemView.findViewById(R.id.id_expo_pic);
            mainLayout= itemView.findViewById(R.id.id_expo_lay);
        }
    }
}

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

import com.azcodeur.nectar.Model.CartModel;
import com.azcodeur.nectar.Model.PostModel;
import com.azcodeur.nectar.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolderAdapter> {
    Context context;
    ArrayList<PostModel> list;
    int minimal_command= 1, price;


    public CartAdapter(Context context, ArrayList<PostModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CartViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.panier_layout, parent, false);
        return new CartViewHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolderAdapter holder, int position) {

        final PostModel sliderItem = list.get(position);

        price= Integer.parseInt(sliderItem.getPrice());

       holder.closeBtn.setOnClickListener(v -> {
           Toast.makeText(context, "Supprimer le produit", Toast.LENGTH_SHORT).show();
       });

        holder.proNum.setText(""+minimal_command);
        holder.proPrice.setText(""+price+" FCFA");

        holder.plusBtn.setOnClickListener(v -> {
            minimal_command++;
            holder.proNum.setText(String.valueOf(minimal_command));
            holder.proPrice.setText(String.valueOf(price*minimal_command)+" FCFA");
        });

        holder.moinsBtn.setOnClickListener(v -> {
            if (minimal_command>1){
                minimal_command--;
                holder.proNum.setText(String.valueOf(minimal_command));
                holder.proPrice.setText(String.valueOf(price*minimal_command)+" FCFA");
            }
        });

        // Glide is use to load image
        // from url in your imageview.
        /*Glide.with(context)
                .load(sliderItem.getImgPic())
                .fitCenter()
                .into(holder.picture); */

        holder.proName.setText(sliderItem.getTitle());
        holder.proDesc.setText(sliderItem.getDescription());
        //holder.proPrice.setText(sliderItem.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartViewHolderAdapter extends RecyclerView.ViewHolder {
        ImageView proPic, closeBtn;
        TextView proName, proDesc, proPrice, proNum;
        ConstraintLayout moinsBtn, plusBtn;
        public CartViewHolderAdapter(@NonNull View itemView) {
            super(itemView);

            moinsBtn= itemView.findViewById(R.id.moins_btn);
            plusBtn= itemView.findViewById(R.id.plus_btn);
            proPic= itemView.findViewById(R.id.imageView17);
            proName= itemView.findViewById(R.id.textView16);
            proDesc= itemView.findViewById(R.id.textView17);
            proPrice= itemView.findViewById(R.id.cart_lay_price);
            proNum= itemView.findViewById(R.id.cart_product_num);
            closeBtn= itemView.findViewById(R.id.imageView18);

        }
    }
}

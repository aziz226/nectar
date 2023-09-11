package com.azcodeur.nectar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azcodeur.nectar.Model.SliderModel;
import com.azcodeur.nectar.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderDetailAdapter extends SliderViewAdapter<SliderDetailAdapter.SliderAdapterViewHolder> {

    // list for storing urls of images.
    private final List<SliderModel> mSliderItems;

    // Constructor
    public SliderDetailAdapter(Context context, ArrayList<SliderModel> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
    }

    // We are inflating the slider_layout
    // inside on Create View Holder method.
    @Override
    public SliderDetailAdapter.SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_detail_layout, null);
        return new SliderDetailAdapter.SliderAdapterViewHolder(inflate);
    }

    // Inside on bind view holder we will
    // set data to item of Slider View.
    @Override
    public void onBindViewHolder(SliderDetailAdapter.SliderAdapterViewHolder viewHolder, final int position) {

        final SliderModel sliderItem = mSliderItems.get(position);

        // Glide is use to load image
        // from url in your imageview.
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImgPic())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        //viewHolder.title.setText(sliderItem.getTitre());
       // viewHolder.description.setText(sliderItem.getDescription());
    }

    // this method will return
    // the count of our list.
    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        // Adapter class for initializing
        // the views of our slider view.
        View itemView;
        ImageView imageViewBackground;
        //TextView title, description;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.slid_det_img);
           // title= itemView.findViewById(R.id.slide_title);
            //description= itemView.findViewById(R.id.slide_desc);

            this.itemView = itemView;
        }
    }
}

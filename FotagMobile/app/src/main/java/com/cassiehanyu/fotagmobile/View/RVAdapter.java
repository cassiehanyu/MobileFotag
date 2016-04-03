package com.cassiehanyu.fotagmobile.View;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cassiehanyu.fotagmobile.Model.Image;
import com.cassiehanyu.fotagmobile.Model.Model;
import com.cassiehanyu.fotagmobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cassiehanyu on 2016-04-03.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ImageViewHolder> {
    private List images;
    private Model model;

    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        ImageView mainPhoto;
        ArrayList<ImageView> rates;

        ImageViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            mainPhoto = (ImageView) itemView.findViewById(R.id.mainPhoto);
            rates = new ArrayList<>(5);
            rates.add((ImageView) itemView.findViewById(R.id.star1));
            rates.add((ImageView) itemView.findViewById(R.id.star2));
            rates.add((ImageView) itemView.findViewById(R.id.star3));
            rates.add((ImageView) itemView.findViewById(R.id.star4));
            rates.add((ImageView) itemView.findViewById(R.id.star5));

        }

    }

    public RVAdapter(List images, Model model){
        this.images = images;
        this.model = model;
    }

    @Override
    public int getItemCount(){
        return images.size();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_panel, parent, false);
        ImageViewHolder imageView = new ImageViewHolder(v);
        return imageView;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int i) {
        holder.mainPhoto.setImageResource(R.drawable.star_empty);
        int j = 0;
        for(; j < model.getImageRate(i); j++){
            holder.rates.get(j).setImageResource(R.drawable.star_full);
        }
        for(j++; j < 5; j++){
            holder.rates.get(j).setImageResource(R.drawable.star_empty);
        }
    }

    public void swap(List list){
//        this.images.clear();
        this.images = list;
        notifyDataSetChanged();
    }
}

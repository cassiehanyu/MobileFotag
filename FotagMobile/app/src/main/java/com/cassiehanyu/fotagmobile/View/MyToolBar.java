package com.cassiehanyu.fotagmobile.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.cassiehanyu.fotagmobile.Model.Model;
import com.cassiehanyu.fotagmobile.R;

import java.util.ArrayList;

/**
 * Created by cassiehanyu on 2016-04-02.
 */
public class MyToolBar extends Toolbar {

    private Model model;
    private ImageView loadImage;
    private ImageButton loadBtn;
    private ImageButton searchBtn;
    private ImageView removeFilter;
    private ArrayList<ImageView> rateFilters;

    public MyToolBar(Context context, Model model) {
        super(context);
        Log.d("MVC_VIEW", "MyToolBar");

        View.inflate(context, R.layout.my_toolbar, this);

        this.model = model;
        System.out.println("tool bar created");
        loadBtn = (ImageButton) findViewById(R.id.btn_load);
//        loadBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("aaaaaaaaaaaa");
//            }
//        });
        searchBtn = (ImageButton) findViewById(R.id.btn_search);

        removeFilter = (ImageView) findViewById(R.id.no);

        rateFilters = new ArrayList<>(5);
        rateFilters.add((ImageView) findViewById(R.id.star_a));
        rateFilters.add((ImageView) findViewById(R.id.star_b));
        rateFilters.add((ImageView) findViewById(R.id.star_c));
        rateFilters.add((ImageView) findViewById(R.id.star_d));
        rateFilters.add((ImageView) findViewById(R.id.star_e));


        registerListeners();
    }

    private void registerListeners(){
        loadBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("aaaaaaaaaaaa");
                Log.d("My tool bar", "click load button");
                Snackbar.make(v, "load button clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                model.loadImage();
            }
        });


        removeFilter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("My tool bar", "click remove filter");
                for(int i = 0; i < 5; i ++){
                    rateFilters.get(i).setImageResource(R.drawable.star_empty);
                }
                model.removeFilter();
            }
        });

        for(final ImageView rateFilter : rateFilters){
            rateFilter.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("My tool bar", "click rate filter");
                    System.out.println("bbbbbbbbbb");
                    ImageView star = (ImageView) v;
                    int i = 0;
                    for(; i < 5; i ++){
                        rateFilters.get(i).setImageResource(R.drawable.star_full);
                        if(rateFilters.get(i).equals(star)){
                            break;
                        }
                    }
                    model.setFilterRate(i+1);
                    for(i++; i < 5; i++){
                        rateFilters.get(i).setImageResource(R.drawable.star_empty);
                    }

                }
            });

            rateFilter.setOnHoverListener(new OnHoverListener() {
                @Override
                public boolean onHover(View v, MotionEvent event) {
                    System.out.println("bbbbbbbbbb");
                    ImageView star = (ImageView) v;
                    star.setImageResource(R.drawable.star_full);

                    return true;
                }
            });
        }
    }



}

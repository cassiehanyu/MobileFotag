package com.cassiehanyu.fotagmobile.View;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.cassiehanyu.fotagmobile.Model.Model;
import com.cassiehanyu.fotagmobile.R;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by cassiehanyu on 2016-04-01.
 */
public class ImagePanel extends CardView implements Observer {

    private Model model;
    private int index;
    private ImageView photo;
    private ArrayList<ImageView> rates;

    public ImagePanel(Context context, Model model, int i) {
        super(context);

        Log.d("MVC_VIEW", "Image Panel Constructor");

        View.inflate(context, R.layout.image_panel, this);

        this.model = model;
        model.addObserver(this);

        index = i;

        photo = (ImageView) findViewById(R.id.mainPhoto);
        Bitmap bitmap = BitmapFactory.decodeFile(model.getImageFilePath(index));
        photo.setImageBitmap(bitmap);

        rates = new ArrayList<>(5);
        rates.add((ImageView) findViewById(R.id.star1));
        rates.add((ImageView) findViewById(R.id.star2));
        rates.add((ImageView) findViewById(R.id.star3));
        rates.add((ImageView) findViewById(R.id.star4));
        rates.add((ImageView) findViewById(R.id.star5));

    }

    @Override
    public void update(Observable observable, Object data) {

    }
}

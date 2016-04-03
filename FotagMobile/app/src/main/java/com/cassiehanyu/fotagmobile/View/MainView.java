package com.cassiehanyu.fotagmobile.View;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cassiehanyu.fotagmobile.DataHelper.Layout;
import com.cassiehanyu.fotagmobile.Model.Model;
import com.cassiehanyu.fotagmobile.R;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by cassiehanyu on 2016-04-02.
 */
public class MainView extends RecyclerView implements Observer {
    private Model model;
    RVAdapter rvAdapter;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;

    public MainView(Context context, Model model) {
        super(context);

        System.out.println("main view created");

        this.model = model;

        linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        gridLayoutManager = new GridLayoutManager(context,2);

        this.setLayoutManager(linearLayoutManager);

        rvAdapter = new RVAdapter(model.getImageModelList(),model);
        this.setAdapter(rvAdapter);

        //this.setScrollContainer(true);

        this.setVerticalScrollBarEnabled(true);

        model.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        List list;
        if(model.isFilterSelected()){
            list = model.getVisibleImages();
        }else{
            list = model.getImageModelList();
        }
        rvAdapter.swap(list);

        if(model.isChangeLayout()) {
            if (model.getCurLayout() == Layout.GRIDLAYOUT) {
                this.setLayoutManager(gridLayoutManager);
            } else if (model.getCurLayout() == Layout.LISTLAYOUT) {
                this.setLayoutManager(linearLayoutManager);
            }
        }
    }
}

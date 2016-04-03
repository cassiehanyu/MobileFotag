package com.cassiehanyu.fotagmobile.Model;

import android.util.Log;

import com.cassiehanyu.fotagmobile.DataHelper.Layout;
import com.cassiehanyu.fotagmobile.DataHelper.Rate;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by cassiehanyu on 2016-04-01.
 */
public class Model extends Observable {
    private ArrayList<Image> imageModelList;

    private int totalImage;

    Layout curLayout;
    private boolean changeLayout;

    private Rate filterRate;
    private boolean filterSelected;

    private boolean filterRemoved;

    public Model(){
        imageModelList = new ArrayList<>();
        totalImage = 0;
        curLayout = Layout.LISTLAYOUT;
        changeLayout = false;
        filterRate = Rate.ZERO;
        filterSelected = false;
        filterRemoved = false;
        //loadImage();
        imageModelList.add(new Image("","fff",Rate.FIVE,new Date()));
        totalImage++;
    }

    //region getter setter

    public boolean isFilterSelected(){
        return filterSelected;
    }

    public String getImageFilePath(int index){
        return imageModelList.get(index).getFilePath();
    }

    public ArrayList<Image> getImageModelList(){
        return imageModelList;
    }

    public ArrayList<Image> getVisibleImages(){
        ArrayList<Image> visibleImages = new ArrayList<>();
        if(filterRate == Rate.ZERO){
            for (int i = 0; i < imageModelList.size(); i++) {
                if (imageModelList.get(i).getRate() == filterRate.getRate()) {
                    visibleImages.add(imageModelList.get(i));
                }
            }
        }else {
            for (int i = 0; i < imageModelList.size(); i++) {
                if (imageModelList.get(i).getRate() >= filterRate.getRate()) {
                    visibleImages.add(imageModelList.get(i));
                }
            }
        }
        return visibleImages;
    }

    public Layout getCurLayout(){
        return curLayout;
    }

    public void setCurLayout(String layout){
        Layout newLayout = Layout.fromString(layout);
        if(curLayout != newLayout){
            changeLayout = true;
            curLayout = newLayout;
            setChanged();
            notifyObservers();
        }
        changeLayout = false;
    }

    public boolean isChangeLayout(){
        return changeLayout;
    }

    public int getImageRate(int index){
        return imageModelList.get(index).getRate();

    }

    public void setFilterRate(int rate){
        filterRate = Rate.fromInt(rate);
        filterSelected = true;
        setChanged();
        notifyObservers();
    }

    public void removeFilter(){
        filterSelected = false;
        filterRemoved = true;
        notifyObservers();
        filterRemoved = false;
    }

    public void setRating(int index, int rate){
        imageModelList.get(index).setRate(Rate.fromInt(rate));
        if(filterSelected) {
            setChanged();
            notifyObservers();
        }
    }

    public void loadImage(){
        imageModelList.add(new Image("","fff",Rate.TWO,new Date()));
        totalImage++;
        setChanged();
        notifyObservers();
    }

    //endregion


    //region MVC
    @Override
    public void addObserver(Observer observer) {
        Log.d("MVC", "Model: Observer added");
        super.addObserver(observer);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    public void notifyObservers() {
        Log.d("MVC", "Model: Observers notified");
        setChanged();
        super.notifyObservers();
    }

    @Override
    protected void setChanged() {
        super.setChanged();
    }

    @Override
    protected void clearChanged() {
        super.clearChanged();
    }

    //endregion
}

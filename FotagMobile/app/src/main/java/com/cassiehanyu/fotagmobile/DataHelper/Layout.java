package com.cassiehanyu.fotagmobile.DataHelper;

/**
 * Created by cassiehanyu on 2016-04-01.
 */
public enum Layout {
    GRIDLAYOUT("Grid"),
    LISTLAYOUT("List");

    Layout(String val){
        this.value = val;
    }

    private String value;

    public String getLayout()

    {
        return value;
    }

    public static Layout fromString(String val){
        for(Layout layout : Layout.values()){
            if(layout.getLayout() == val){
                return layout;
            }
        }
        return null;
    }
}

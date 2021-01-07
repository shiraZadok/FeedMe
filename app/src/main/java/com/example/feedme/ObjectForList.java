package com.example.feedme;

import android.widget.ImageView;

public class ObjectForList {
    public String text;
    public String image;
    public ObjectForList(String text,String image){
        this.text=text;
        this.image=image;
    }

    public ObjectForList() {

    }
    public void  SetAll (String text,String image){
        this.text=text;
        this.image=image;
    }

}

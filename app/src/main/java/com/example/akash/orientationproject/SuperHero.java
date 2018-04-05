package com.example.akash.orientationproject;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Akash on 11/30/2017.
 */

public class SuperHero implements Serializable {
    String name;
    String alias;
    String power;
    String weak;
    String bio;
    int pic;

    public SuperHero(String name, String alias, String power, String weak, int pic, String bio){
        this.name = name;
        this.alias = alias;
        this.power = power;
        this.weak = weak;
        this.bio=bio;
        this.pic = pic;
    }

    public String getName(){
        return name;
    }

    public String getAlias(){
        return alias;
    }

    public String getPower(){
        return power;
    }

    public String getWeak() {
        return weak;
    }

    public String getBio() {
        return bio;
    }

    public Integer getPic() {
        return pic;
    }
}

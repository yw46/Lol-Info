package com.fun.yishuo.lolinfo.Model;

/**
 * Created by Yishuo Wang on 7/31/16.
 */
public class ChampDetail {
    private String name, imageName;
    private String type;
    private int imageDrawable;

    public ChampDetail(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }

    public ChampDetail(String name) {
        this.name = name;
        this.imageDrawable = GlobalFunction.getDrawable(name); //thumbnail.setImageResource(imageDrawable)
    }

    public int getImageDrawable() {
        return imageDrawable;
    }
}

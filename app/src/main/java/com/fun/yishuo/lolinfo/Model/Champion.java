package com.fun.yishuo.lolinfo.Model;

import java.util.ArrayList;

/**
 * Created by Yishuo Wang on 7/21/16.
 */
public class Champion extends GlobalFunction {
    private String name;

    private String skillP, skillQ, skillW, skillE, skillR;
    private String skillDescription;
    private ArrayList<byte []> skillImage;

    public Champion(String name) {
        this.name = name;
        this.skillImage = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

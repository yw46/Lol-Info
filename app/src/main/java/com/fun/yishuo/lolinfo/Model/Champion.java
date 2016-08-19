package com.fun.yishuo.lolinfo.Model;

/**
 * Created by Yishuo Wang on 7/21/16.
 */
public class Champion extends GlobalFunction {
    private String name;

    private String skillP, skillQ, skillW, skillE, skillR;
    private String skillDescription;

    public Champion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.fun.yishuo.lolinfo.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yishuo Wang on 9/17/16.
 */
public class ChampSkill {
    private String champName, p, pname, qname, q, wname, w, ename, e, rname, r, skillOrder;
    private ArrayList<String> itemSetEarly, itemSetMid, itemSetLate0, itemSetLate1;
    private ArrayList<byte []> skillImage;

    public ChampSkill(String champName) {
        this.champName = champName;
        if (champName.equals("noChamp")) {
            noName();
        }
        skillImage = new ArrayList<>();
    }

    public ArrayList<byte[]> getSkillImage() {
        return skillImage;
    }

    public void setSkillImage(ArrayList<byte[]> skillImage) {
        this.skillImage = skillImage;
    }

    public void addSkillImage(byte[] img) {
        this.skillImage.add(img);
    }

    public byte[] getImage(char skill) {
        switch (skill) {
            case 'p':
                return skillImage.get(0);
            case 'q':
                return skillImage.get(1);
            case 'w':
                return skillImage.get(2);
            case 'e':
                return skillImage.get(3);
            case 'r':
                return skillImage.get(4);
            default:
                return null;
        }
    }

    public void noName() {
        this.p = "N/A";
        this.pname = "N/A";
        this.q = "N/A";
        this.qname = "N/A";
        this.w = "N/A";
        this.wname = "N/A";
        this.e = "N/A";
        this.ename = "N/A";
        this.r = "N/A";
        this.rname = "N/A";
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getSkillOrder() {
        return skillOrder;
    }

    public void setSkillOrder(String skillOrder) {
        this.skillOrder = skillOrder;
    }

    public ArrayList<String> getItemSetEarly() {
        return itemSetEarly;
    }

    public void setItemSetEarly(ArrayList<String> itemSetEarly) {
        this.itemSetEarly = itemSetEarly;
    }

    public ArrayList<String> getItemSetMid() {
        return itemSetMid;
    }

    public void setItemSetMid(ArrayList<String> itemSetMid) {
        this.itemSetMid = itemSetMid;
    }

    public ArrayList<String> getItemSetLate0() {
        return itemSetLate0;
    }

    public void setItemSetLate0(ArrayList<String> itemSetLate0) {
        this.itemSetLate0 = itemSetLate0;
    }

    public ArrayList<String> getItemSetLate1() {
        return itemSetLate1;
    }

    public void setItemSetLate1(ArrayList<String> itemSetLate1) {
        this.itemSetLate1 = itemSetLate1;
    }
}

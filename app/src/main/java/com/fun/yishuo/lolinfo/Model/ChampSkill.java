package com.fun.yishuo.lolinfo.Model;

/**
 * Created by Yishuo Wang on 9/17/16.
 */
public class ChampSkill {
    private String champName, p, pname, qname, q, wname, w, ename, e, rname, r;

    public ChampSkill(String champName) {
        this.champName = champName;
        if (champName.equals("noChamp")) {
            noName();
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
}

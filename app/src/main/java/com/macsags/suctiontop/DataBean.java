package com.macsags.suctiontop;

/**
 * @author : 柳湘翎 （Macsags）
 * @date : 2020/6/28 16:26
 * @mail : 670765255@qq.com
 * @description ：吸顶效果
 */
public class DataBean {

    private String data;
    private boolean isShowLable;
    private String spell;
    private int imgLable;

    public DataBean(String data, boolean isShowLable, String spell,int imgLable) {
        this.data = data;
        this.isShowLable = isShowLable;
        this.spell = spell;
        this.imgLable =imgLable;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isShowLable() {
        return isShowLable;
    }

    public void setShowLable(boolean showLable) {
        isShowLable = showLable;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public int getImgLable() {
        return imgLable;
    }

    public void setImgLable(int imgLable) {
        this.imgLable = imgLable;
    }
}

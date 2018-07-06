package com.android.lixiang.homepage.presenter.data.entity;

public class EveryDayPicEntity {
    private String picContentName;

    public EveryDayPicEntity() {
    }

    public EveryDayPicEntity(String picContentName) {
        this.picContentName = picContentName;
    }

    public String getPicContentName() {
        return picContentName;
    }

    public void setPicContentName(String picContentName) {
        this.picContentName = picContentName;
    }
}

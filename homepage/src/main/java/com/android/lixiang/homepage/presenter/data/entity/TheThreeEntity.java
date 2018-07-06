package com.android.lixiang.homepage.presenter.data.entity;

public class TheThreeEntity {

    /**
     * dataType : sceneSearch
     * imageUrl : http://202.111.178.10:28085/upload/image/201712051138000099812_image.png
     * position : 1
     * price : 1000.00
     */

    private String dataType;
    private String imageUrl;
    private String position;
    private String price;

    private int itemType;
    private int spanSize;

    public TheThreeEntity() {
    }

    public TheThreeEntity(String dataType, String imageUrl, String position, String price) {
        this.dataType = dataType;
        this.imageUrl = imageUrl;
        this.position = position;
        this.price = price;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

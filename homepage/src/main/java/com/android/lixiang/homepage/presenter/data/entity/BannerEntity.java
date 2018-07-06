package com.android.lixiang.homepage.presenter.data.entity;

public class BannerEntity {
    private String dataType;
    private String imageUrl;
    private String link;
    private String productId;

    public BannerEntity(String dataType, String imageUrl, String link, String productId) {
        this.dataType = dataType;
        this.imageUrl = imageUrl;
        this.link = link;
        this.productId = productId;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

package com.android.lixiang.emall.presenter.data.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HorizontalEntity {
    private String dataType;
    private String imageUrl;
    private String posDescription;
    private String posMark;
    private String posTitle;
    private String position;
    private String productId;
    private String price;

    public HorizontalEntity() {
    }

    public HorizontalEntity(String dataType, String imageUrl, String posDescription, String posMark, String posTitle, String position, String productId, String price) {
        this.dataType = dataType;
        this.imageUrl = imageUrl;
        this.posDescription = posDescription;
        this.posMark = posMark;
        this.posTitle = posTitle;
        this.position = position;
        this.productId = productId;
        this.price = price;
    }

    public static HorizontalEntity objectFromData(String str) {

        return new Gson().fromJson(str, HorizontalEntity.class);
    }

    public static HorizontalEntity objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), HorizontalEntity.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<HorizontalEntity> arrayHorizontalEntityFromData(String str) {

        Type listType = new TypeToken<ArrayList<HorizontalEntity>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<HorizontalEntity> arrayHorizontalEntityFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<HorizontalEntity>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


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

    public String getPosDescription() {
        return posDescription;
    }

    public void setPosDescription(String posDescription) {
        this.posDescription = posDescription;
    }

    public String getPosMark() {
        return posMark;
    }

    public void setPosMark(String posMark) {
        this.posMark = posMark;
    }

    public String getPosTitle() {
        return posTitle;
    }

    public void setPosTitle(String posTitle) {
        this.posTitle = posTitle;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

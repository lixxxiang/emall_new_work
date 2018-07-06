package com.android.lixiang.homepage.presenter.data.bean;

import com.android.lixiang.homepage.presenter.data.entity.BannerEntity;
import com.android.lixiang.homepage.presenter.data.entity.EveryDayPicEntity;
import com.android.lixiang.homepage.presenter.data.entity.TheThreeEntity;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class HomeEntity implements MultiItemEntity{
    public static final int TYPE_EVERY_DAY_PIC = 1;
    public static final int TYPE_THE_THREE = 2;

    private int itemType;
    private int spanSize;

    public EveryDayPicEntity everyDayPicEntity;
    public List<TheThreeEntity> theThreeEntity;

    @Override
    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public EveryDayPicEntity getEveryDayPicEntity() {
        return everyDayPicEntity;
    }

    public void setEveryDayPicEntity(EveryDayPicEntity everyDayPicEntity) {
        this.everyDayPicEntity = everyDayPicEntity;
    }

    public List<TheThreeEntity> getTheThreeEntity() {
        return theThreeEntity;
    }

    public void setTheThreeEntity(List<TheThreeEntity> theThreeEntity) {
        this.theThreeEntity = theThreeEntity;
    }
}

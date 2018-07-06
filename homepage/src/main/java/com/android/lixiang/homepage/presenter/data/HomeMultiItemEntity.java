package com.android.lixiang.homepage.presenter.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.LinkedHashMap;

public class HomeMultiItemEntity implements MultiItemEntity{

    LinkedHashMap<Object, Object> MULTIPLE_FIELDS = new LinkedHashMap<>();

    public Object getField(Object key) {
        return MULTIPLE_FIELDS.get(key);
    }

    public LinkedHashMap<Object, Object> setField(Object key, Object value){
        MULTIPLE_FIELDS.put(key, value);
        return MULTIPLE_FIELDS;
    }

    @Override
    public int getItemType() {
        return (Integer) MULTIPLE_FIELDS.get("ITEM_TYPE");
//                FIELDS_REFERENCE.get()!![SpecialMultipleFields.ITEM_TYPE] as Int;
    }
}

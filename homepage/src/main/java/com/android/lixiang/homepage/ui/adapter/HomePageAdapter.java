package com.android.lixiang.homepage.ui.adapter;

import com.android.lixiang.homepage.presenter.data.bean.HomePageUnitsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class HomePageAdapter extends BaseQuickAdapter<HomePageUnitsBean, BaseViewHolder> {
    public HomePageAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        test();
    }

    private void test() {
    }


    @Override
    protected void convert(BaseViewHolder helper, HomePageUnitsBean item) {

    }
}


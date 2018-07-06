package com.android.lixiang.classify.ui.adapter;

import com.android.lixiang.base.utils.view.SquareImageView;
import com.android.lixiang.classify.R;
import com.android.lixiang.classify.presenter.data.bean.SceneSearchBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class OpticsAdapter extends BaseQuickAdapter<SceneSearchBean.DataBean.SearchReturnDtoListBean, BaseViewHolder> {
    public OpticsAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SceneSearchBean.DataBean.SearchReturnDtoListBean item) {
        Glide.with(mContext).load(item.getThumbnailUrl()).into((SquareImageView)helper.getView(R.id.mOpticsIv));
    }
}



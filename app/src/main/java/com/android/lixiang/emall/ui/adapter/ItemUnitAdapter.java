package com.android.lixiang.emall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.lixiang.base.utils.view.RoundImageView;
import com.android.lixiang.emall.R;
import com.android.lixiang.emall.presenter.data.entity.HorizontalEntity;
import com.android.lixiang.emall.ui.fragment.HomeFragment;
import com.bumptech.glide.Glide;

import java.util.List;

public class ItemUnitAdapter extends RecyclerView.Adapter<ItemUnitAdapter.ViewHolder> {

    private List<HorizontalEntity> mApps;
    private Context context;
    private HomeFragment delegate;

    public ItemUnitAdapter(List<HorizontalEntity> apps, Context context, HomeFragment delegate) {
        mApps = apps;
        this.context = context;
        this.delegate = delegate;
    }

    public ItemUnitAdapter(List<HorizontalEntity> apps, Context context) {
        mApps = apps;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_unit, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HorizontalEntity app = mApps.get(position);
        holder.unit_title_tv.setText(app.getPosTitle());
        holder.unit_detail_tv.setText(app.getPosDescription());
        holder.unit_description_tv.setText(app.getPosTitle());

        Glide.with(context)
                .load(app.getImageUrl())
                .into(holder.unit_image_iv);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public RoundImageView unit_image_iv;
        public TextView unit_title_tv;
        public TextView unit_detail_tv;
        public TextView unit_description_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            unit_image_iv = itemView.findViewById(R.id.unit_image_iv);
            unit_title_tv = itemView.findViewById(R.id.unit_title_tv);
            unit_detail_tv = itemView.findViewById(R.id.unit_detail_tv);
            unit_description_tv = itemView.findViewById(R.id.unit_description_tv);
        }

        @Override
        public void onClick(View v) {
//            horizontalClick(mApps, getAdapterPosition());
        }
    }

//    private void horizontalClick(List<HorizontalEntity> horizontalList, int position) {
//        EmallLogger.INSTANCE.d(horizontalList.get(position).getType());
//        switch (horizontalList.get(position).getType()) {
//            case "scene": {
//                GoodsDetailDelegate goodsDetailDelegate = new GoodsDetailDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("productId", horizontalList.get(position).getProductId());
//                bundle.putString("type", "1");
//                goodsDetailDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(goodsDetailDelegate);
//                break;
//            }
//            case "night": {
//                GoodsDetailDelegate goodsDetailDelegate = new GoodsDetailDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("productId", horizontalList.get(position).getProductId());
//                bundle.putString("type", "5");
//                goodsDetailDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(goodsDetailDelegate);
//                break;
//            }
//            case "video": {
//                GoodsDetailDelegate goodsDetailDelegate = new GoodsDetailDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("productId", horizontalList.get(position).getProductId());
//                bundle.putString("type", "3");
//                goodsDetailDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(goodsDetailDelegate);
//                break;
//            }
//            case "sceneSearch": {
//                ClassifyDelegate classifyDelegate = new ClassifyDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("TYPE", "SCENE");
//                classifyDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(classifyDelegate);
//                break;
//            }
//            case "nightSearch": {
//                ClassifyDelegate classifyDelegate = new ClassifyDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("TYPE", "NOCTILUCENCE");
//                classifyDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(classifyDelegate);
//                break;
//            }
//            case "videoSearch": {
//                ClassifyDelegate classifyDelegate = new ClassifyDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("TYPE", "VIDEO");
//                classifyDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(classifyDelegate);
//                break;
//            }
//            case "programSearch": {
//                delegate.getParentDelegate().start(new ProgramDelegate().create());
//                break;
//            }
//            case "webview":
//                DiscoverDelegate discoverDelegate = new DiscoverDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("URL", horizontalList.get(position).getLink());
//                discoverDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(discoverDelegate);
//                break;
//
//            default:
//        }
//    }

}


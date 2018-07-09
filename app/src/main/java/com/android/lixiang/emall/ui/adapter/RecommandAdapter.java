package com.android.lixiang.emall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.lixiang.base.utils.view.SquareImageView;
import com.android.lixiang.emall.R;
import com.android.lixiang.emall.presenter.data.entity.HorizontalEntity;
import com.android.lixiang.emall.ui.fragment.HomeFragment;
import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by lixiang on 2018/3/11.
 */

public class RecommandAdapter extends RecyclerView.Adapter<RecommandAdapter.ViewHolder> {

    private List<HorizontalEntity> list;
    private Context context;
    private HomeFragment fragment;

    public RecommandAdapter(List<HorizontalEntity> list, Context context, HomeFragment fragment){
        this.list = list;
        this.context = context;
        this.fragment = fragment;
    }

    public RecommandAdapter(List<HorizontalEntity> list, Context context){
        this.list = list;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommand, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HorizontalEntity guessLikeBean = list.get(position);
        holder.guess_like_type_tv.setText(guessLikeBean.getPosTitle());
        holder.guess_like_title_tv.setText(guessLikeBean.getPosDescription());
        holder.guess_like_price_tv.setText("¥" + guessLikeBean.getPrice());
        Glide.with(context)
                .load(guessLikeBean.getImageUrl())
                .into(holder.guess_like_image_iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public SquareImageView guess_like_image_iv;
        public TextView guess_like_type_tv;
        public TextView guess_like_title_tv;
        public TextView guess_like_price_tv;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            guess_like_image_iv = itemView.findViewById(R.id.item_guess_like_iv);
            guess_like_type_tv = itemView.findViewById(R.id.item_guess_like_type_tv);
            guess_like_title_tv = itemView.findViewById(R.id.item_guess_like_title_tv);
            guess_like_price_tv = itemView.findViewById(R.id.item_guess_like_price_tv);
        }

        @Override
        public void onClick(View v) {
//            guessLikeClick(list, getAdapterPosition());
        }
    }

//    private void guessLikeClick(List<HorizontalEntity> guessLikeList, int position) {
//        EmallLogger.INSTANCE.d(guessLikeList.get(position).getDataType());
//        switch (guessLikeList.get(position).getDataType()) {
//            case "scene": {
//                GoodsDetailDelegate goodsDetailDelegate = new GoodsDetailDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("productId", guessLikeList.get(position).getProductId());
//                bundle.putString("type", "1");
//                goodsDetailDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(goodsDetailDelegate);
//                break;
//            }
//            case "night": {
//                GoodsDetailDelegate goodsDetailDelegate = new GoodsDetailDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("productId", guessLikeList.get(position).getProductId());
//                bundle.putString("type", "5");
//                goodsDetailDelegate.setArguments(bundle);
//                delegate.getParentDelegate().start(goodsDetailDelegate);
//                break;
//            }
//            case "video": {
//                GoodsDetailDelegate goodsDetailDelegate = new GoodsDetailDelegate().create();
//                Bundle bundle = new Bundle();
//                bundle.putString("productId", guessLikeList.get(position).getProductId());
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
////                DiscoverDelegate discoverDelegate = new DiscoverDelegate().create();
////                Bundle bundle = new Bundle();
////                bundle.putString("URL", guessLikeList.get(position).get());
////                discoverDelegate.setArguments(bundle);
////                delegate.getParentDelegate().start(discoverDelegate);
//                Toast.makeText(delegate.getActivity(), "IT CANNOT BE WEBVIEW", Toast.LENGTH_LONG).show();
//                break;
//
//            default:
//        }
//    }
}

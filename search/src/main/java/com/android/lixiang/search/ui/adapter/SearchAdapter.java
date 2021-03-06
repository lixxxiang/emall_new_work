package com.android.lixiang.search.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.lixiang.search.R;

import java.util.List;

public class SearchAdapter extends BaseAdapter {
    private List<String> titleList;
    private List<String> detailList;
    private LayoutInflater inflater;
    private Context context;


    public SearchAdapter() {
    }

    public SearchAdapter(List<String> titleList, List<String> detailList, Context context) {
        this.titleList = titleList;
        this.detailList = detailList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public SearchAdapter(List<String> titleList, Context context) {
        this.titleList = titleList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return titleList == null ? 0 : titleList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(R.layout.item_search_listview, null);
        TextView item_tv = view.findViewById(R.id.mTitleTextView);
        item_tv.setText(titleList.get(position));
        return view;
    }
}

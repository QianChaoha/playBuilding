package com.example.playbuilding.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseAdapter;
import com.example.playbuilding.base.ViewHolder;

import java.util.List;

/**
 * Created by cqian on 2017/5/5.
 */
public class InfoDialogAdapter extends BaseAdapter<Integer> {


    public InfoDialogAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.info_img_item;
    }

    @Override
    protected void onViewCreated(ViewHolder holder, int position) {
        ImageView imageView = holder.get(R.id.imageView);
        imageView.setBackgroundResource(list.get(position));
    }
}

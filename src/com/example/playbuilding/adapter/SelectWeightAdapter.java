package com.example.playbuilding.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseAdapter;
import com.example.playbuilding.base.ViewHolder;

public class SelectWeightAdapter extends BaseAdapter<Integer> {
    boolean[] selects;

    public SelectWeightAdapter(Context context, List<Integer> list) {
        super(context, list);
        if (list != null) {
            selects = new boolean[list.size()];
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.select_weight_item;
    }

    @Override
    protected void onViewCreated(ViewHolder holder, final int position) {
        TextView textView = holder.get(R.id.textView);
        if (getItem(position) != null) {
            textView.setText(getItem(position) + "");
        } else {
            textView.setText("");
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < selects.length; i++) {
                    if (i == position) {
                        selects[i] = true;
                    } else {
                        selects[i] = false;
                    }
                }
                notifyDataSetChanged();
            }
        });

        if (selects[position]) {
            textView.setBackgroundResource(R.drawable.n_butbg_size_l);
        } else {
            textView.setBackgroundResource(R.drawable.n_butbg_size_n);
        }
    }

}

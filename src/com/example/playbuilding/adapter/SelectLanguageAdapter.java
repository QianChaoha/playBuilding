package com.example.playbuilding.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseAdapter;
import com.example.playbuilding.base.ViewHolder;
import com.example.playbuilding.entity.SelectLanguageEntity;

public class SelectLanguageAdapter extends BaseAdapter<SelectLanguageEntity> {

	private boolean[] selects;
	int lastSelected=0;

	public SelectLanguageAdapter(Context context, List<SelectLanguageEntity> list, boolean[] selects) {
		super(context, list);
		this.selects = selects;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.select_language_item;
	}

	@Override
	protected void onViewCreated(final ViewHolder holder, final int position) {
		ImageView imageView = holder.get(R.id.imageView);
		imageView.setBackgroundResource(getItem(position).mImageId);
		TextView textView = holder.get(R.id.textView);
		textView.setText(getItem(position).mcountry);
		final ImageView ivSelect = holder.get(R.id.ivSelect);
		RelativeLayout root = holder.get(R.id.root);
		root.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (lastSelected==position) {
					return;
				}
				selects[position] = !selects[position];
				selects[lastSelected]=false;
				notifyDataSetChanged();
				ivSelect.post(new Runnable() {
					
					@Override
					public void run() {
						lastSelected=position;
					}
				});
			}
		});
		
		if (selects[position]) {
			ivSelect.setBackgroundResource(R.drawable.italiano_state2_30);
  		} else {
			ivSelect.setBackgroundResource(R.drawable.italiano_state1_29);
		}
	}

}

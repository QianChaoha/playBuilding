package com.example.playbuilding.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.bodybuilding.base.BaseActivity;
import com.example.playbuilding.R;

/**
 * Created by cqian on 2017/5/17.
 */
public class SelectManualActivity extends BaseActivity {
	private ImageView mIvGo;

	@Override
	protected void initView() {
		mIvGo = getView(R.id.ivGo);
		mIvGo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(mContext,SelectProgramActivity.class));
			}
		});
	}

	@Override
	protected void getData() {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_select_manual;
	}
}

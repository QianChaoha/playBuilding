package com.example.playbuilding.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.adapter.CustomerWorkoutBottomAdapter;
import com.example.playbuilding.base.BaseFragment;
import com.example.playbuilding.entity.CustomerWorkoutEntity;

public class SelectProgramFragment extends BaseFragment {
	private GridView mGridView;
	private ImageView mIvGo;
	private int[] id=new int[]{R.raw.back_extension,R.raw.bicep_curl,R.raw.shoulder_press,
			R.raw.tricep_extension,R.raw.standing_row,R.raw.chest_press,
			R.raw.chest_flyes,R.raw.rear_cable_lunge,R.raw.lat_pulldown,R.raw.squat,
			R.raw.leg_swing,R.raw.upright_row};
	private TextView mTvReset;
	@Override
	protected void initView() {
		mGridView = getView(R.id.gridView);
		mTvReset = getView(R.id.tvReset);
		List<CustomerWorkoutEntity> list = new ArrayList<CustomerWorkoutEntity>();
		list.add(new CustomerWorkoutEntity(R.drawable.back_extension, "Back Extension"));
		list.add(new CustomerWorkoutEntity(R.drawable.bicep_curl, "Biceps Curl"));
		list.add(new CustomerWorkoutEntity(R.drawable.shoulder_ress, "Shoulder Hilo"));
		list.add(new CustomerWorkoutEntity(R.drawable.tricep_extension, "Tricep Kickback"));
		list.add(new CustomerWorkoutEntity(R.drawable.standing_row, "Standing ROW"));
		list.add(new CustomerWorkoutEntity(R.drawable.chest_press, "Chest Press"));
		list.add(new CustomerWorkoutEntity(R.drawable.chest_flyes, "Chest Flye"));
		list.add(new CustomerWorkoutEntity(R.drawable.rear_cable_lunge, "Cable Crossover"));
		list.add(new CustomerWorkoutEntity(R.drawable.lat_pulldown, "Lat Pull Down"));
		list.add(new CustomerWorkoutEntity(R.drawable.squat, "Squat"));
		list.add(new CustomerWorkoutEntity(R.drawable.leg_swing, "Leg Swing"));
		list.add(new CustomerWorkoutEntity(R.drawable.upright_row, "Upright Row"));
		final CustomerWorkoutBottomAdapter adapter = new CustomerWorkoutBottomAdapter(mContext, list);
		mGridView.setAdapter(adapter);
		mIvGo = getView(R.id.ivGo);
		mIvGo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle bundle=new Bundle();
				bundle.putInt("id",id[adapter.getSelect()]);
				mContext.goPv(bundle);
			}
		});
		mTvReset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mContext.goSw();
			}
		});
	}

	@Override
	protected void getData() {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_select_program;
	}

}

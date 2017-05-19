package com.example.playbuilding.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.playbuilding.R;
import com.example.playbuilding.adapter.CustomerWorkoutBottomAdapter;
import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.entity.CustomerWorkoutEntity;

public class SelectProgramActivity extends BaseActivity {
	private GridView mGridView;
	private ImageView mIvGo;
	private int[] id=new int[]{R.raw.back_extension,R.raw.bicep_curl,R.raw.shoulder_press,
			R.raw.tricep_extension,R.raw.standing_row,R.raw.chest_press,
			R.raw.chest_flyes,R.raw.rear_cable_lunge,R.raw.lat_pulldown,R.raw.squat,};
	@Override
	protected void initView() {
		mGridView = getView(R.id.gridView);
		List<CustomerWorkoutEntity> list = new ArrayList<CustomerWorkoutEntity>();
		list.add(new CustomerWorkoutEntity(R.drawable.j_img_front_01_n, "Back Extension"));
		list.add(new CustomerWorkoutEntity(-1, "Biceps Curl"));
		list.add(new CustomerWorkoutEntity(-1, "Shoulder Hilo"));
		list.add(new CustomerWorkoutEntity(-1, "Tricep Kickback"));
		list.add(new CustomerWorkoutEntity(-1, "Standing ROW"));
		list.add(new CustomerWorkoutEntity(-1, "Chest Press"));
		list.add(new CustomerWorkoutEntity(-1, "Chest Flye"));
		list.add(new CustomerWorkoutEntity(-1, "Cable Crossover"));
		list.add(new CustomerWorkoutEntity(-1, "Lat Pull Down"));
		list.add(new CustomerWorkoutEntity(-1, "Squat"));
		list.add(new CustomerWorkoutEntity(-2, ""));
		list.add(new CustomerWorkoutEntity(-2, ""));
		final CustomerWorkoutBottomAdapter adapter = new CustomerWorkoutBottomAdapter(mContext, list);
		mGridView.setAdapter(adapter);
		mIvGo = getView(R.id.ivGo);
		mIvGo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, PlayVideoActivity.class);
				intent.putExtra("id",id[adapter.getSelect()]);
				startActivity(intent);
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

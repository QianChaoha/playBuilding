package com.example.playbuilding.activity;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.playbuilding.R;
import com.example.playbuilding.adapter.CustomerWorkoutAdapter;
import com.example.playbuilding.adapter.CustomerWorkoutBottomAdapter;
import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.entity.CustomerWorkoutEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomWorkoutActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mIvContinue;
    private GridView mGridView,mGridViewBottom;
    private LinearLayout mLlPoint;

    @Override
    protected void initView() {
        mIvContinue = getView(R.id.ivContinue);
        mIvContinue.setOnClickListener(this);
        mGridView = getView(R.id.gridView);
        mGridViewBottom = getView(R.id.gridViewBottom);
        mLlPoint = getView(R.id.llPoint);
    }

    @Override
    protected void getData() {
        List<CustomerWorkoutEntity> list = new ArrayList<CustomerWorkoutEntity>();
        list.add(new CustomerWorkoutEntity(R.drawable.j_img_front, "FROUNT 5"));
        list.add(new CustomerWorkoutEntity(R.drawable.j_img_back_01_n, "BACK 5"));
        list.add(new CustomerWorkoutEntity(R.drawable.j_img_hybrid_01_n, "HYBRID 5"));
        mGridView.setAdapter(new CustomerWorkoutAdapter(mContext, list));


        List<CustomerWorkoutEntity> list1 = new ArrayList<CustomerWorkoutEntity>();
        list1.add(new CustomerWorkoutEntity(R.drawable.j_img_front_01_n, "BACK EXTENSION"));
        list1.add(new CustomerWorkoutEntity(R.drawable.j_img_front_02_n, "BICEPS CURL"));
        list1.add(new CustomerWorkoutEntity(R.drawable.j_img_front_03_n, "TRICEPS KICKBACK"));
        list1.add(new CustomerWorkoutEntity(R.drawable.j_img_front_04_n, "SHOULDER HI/LO"));
        list1.add(new CustomerWorkoutEntity(R.drawable.j_img_front_05_n, "STATED ROW"));
        mGridViewBottom.setNumColumns(5);
        mGridViewBottom.setAdapter(new CustomerWorkoutBottomAdapter(mContext, list1));

        mLlPoint.removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(mContext);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
            } else {
                imageView.setBackgroundResource(R.drawable.black_stage_1_56);
            }
            mLlPoint.addView(imageView);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_workout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivContinue:
                startActivity(new Intent(mContext,HeartrateActivity.class));
                break;
        }
    }
}

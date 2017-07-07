package com.example.playbuilding.activity;

import android.view.View;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.base.BaseFragment;

/**
 * Created by cqian on 2017/5/19.
 */
public class WorkoutSummaryFragment extends BaseFragment {
    @Override
    protected void initView() {
        ((TextView)findView(R.id.tvHome)).setOnClickListener(new View.OnClickListener() {
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
        return R.layout.activity_workout_summary;
    }
}

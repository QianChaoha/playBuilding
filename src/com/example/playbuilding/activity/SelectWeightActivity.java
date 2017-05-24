package com.example.playbuilding.activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.bodybuilding.base.BaseActivity;
import com.example.playbuilding.adapter.SelectWeightAdapter;

public class SelectWeightActivity extends BaseActivity implements OnClickListener {
    private TextView mTvTitle;
    private GridView mGridView;
    private Button btContinue;
    private ImageView mIvLibs, mIvKg, mIvGo;
    private List<Integer> mList;
    private SelectWeightAdapter mSelectWeightAdapter;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void initView() {

        mIvLibs = getView(R.id.ivLibs);
        mIvLibs.setOnClickListener(this);
        mIvKg = getView(R.id.ivKg);
        mIvGo = getView(R.id.ivGo);
        mIvKg.setOnClickListener(this);
        mIvGo.setOnClickListener(this);
        mTvTitle = getView(R.id.tvTitle);
        mGridView = getView(R.id.gridView);
//      btContinue = getView(R.id.btContinue);
//      btContinue.setOnClickListener(new OnClickListener() {
//
//          @Override
//          public void onClick(View v) {
//              startActivity(new Intent(mContext, CustomWorkoutActivity.class));
//          }
//      });
    }

    @Override
    protected void getData() {
        initListLibs();
    }

    private void initListLibs() {
        mList = new ArrayList<Integer>();
        mList.add(9);
        mList.add(18);
        mList.add(27);
        mList.add(36);
        mList.add(45);
        mList.add(54);
        mList.add(63);
        mList.add(81);
        mList.add(null);
        mList.add(null);
        mSelectWeightAdapter = new SelectWeightAdapter(mContext, mList);
        mGridView.setAdapter(mSelectWeightAdapter);
    }

    private void initListKg() {
        //5,7,9,11,14,16,18,23,27,32
        mList = new ArrayList<Integer>();
        mList.add(5);
        mList.add(7);
        mList.add(9);
        mList.add(11);
        mList.add(14);
        mList.add(16);
        mList.add(18);
        mList.add(50);
        mList.add(60);
        mList.add(70);
        mList.add(null);
        mList.add(null);
        mSelectWeightAdapter = new SelectWeightAdapter(mContext, mList);
        mGridView.setAdapter(mSelectWeightAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_weight;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivLibs:
                mIvLibs.setBackgroundResource(R.drawable.n_but_lbs_l);
                mIvKg.setBackgroundResource(R.drawable.n_but_kg_n);
                initListLibs();
                break;
            case R.id.ivKg:
                mIvLibs.setBackgroundResource(R.drawable.n_but_lbs_n);
                mIvKg.setBackgroundResource(R.drawable.n_but_kg_l);
//                initListKg();
                initListLibs();
                break;
            case R.id.ivGo:
                startActivity(new Intent(mContext, SelectManualActivity.class));
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

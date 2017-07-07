package com.example.playbuilding.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseActivity;

/**
 * Created by cqian on 2017/7/7.
 */

public class MainActivity extends BaseActivity {
    private FrameLayout root;

    @Override
    protected void initView() {
        root = (FrameLayout) findViewById(R.id.root);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.root, new SelectWeightFragment()).commit();
    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void goPv(Bundle bundle) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        PlayVideoFragment fragment=new PlayVideoFragment();
        if (bundle!=null){
            fragment.setArguments(bundle);
        }
        fragmentTransaction.add(R.id.root,fragment).commit();
    }


    public void goSp() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.root, new SelectProgramFragment()).commit();
    }
    public void goSm() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.root, new SelectManualFragment()).commit();
    }
    public void goSf() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.root, new SelectWeightFragment()).commit();
    }
    public void goWs() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.root, new WorkoutSummaryFragment()).commit();
    }
    public void goSw() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.root, new SelectWeightFragment()).commit();
    }
}

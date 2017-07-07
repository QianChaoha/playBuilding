package com.example.playbuilding.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.playbuilding.activity.MainActivity;

/**
 * Created by cqian on 2017/7/7.
 */

public abstract class BaseFragment extends Fragment {
    protected View rootView;
    protected MainActivity mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext= (MainActivity) getActivity();
        rootView= inflater.inflate(getLayoutId(), container, false);
        initView();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    protected <T> T findView(int id) {
        return (T) rootView.findViewById(id);
    }

    protected abstract void initView();

    protected abstract void getData();

    protected abstract int getLayoutId();

    protected <T extends View> T getView(View view, int id) {
        return (T) view.findViewById(id);
    }

    protected <T extends View> T getView(int id) {
        return (T) findView(id);
    }
}

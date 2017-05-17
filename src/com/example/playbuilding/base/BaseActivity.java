package com.example.playbuilding.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by cqian on 2017/5/4.
 */
public abstract class BaseActivity extends Activity{
    protected Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (setNoTitle()){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        super.onCreate(savedInstanceState);
        mContext=this;
        setContentView(getLayoutId());
        initView();
        getData();
    }

    protected abstract void initView();

    protected abstract void getData();

    protected abstract int getLayoutId();
    protected boolean setNoTitle(){
        return true;
    }

    protected <T extends View> T getView(int id){
        return (T)findViewById(id);
    }
    protected <T extends View> T getView(View view,int id){
    	return (T)view.findViewById(id);
    }
}

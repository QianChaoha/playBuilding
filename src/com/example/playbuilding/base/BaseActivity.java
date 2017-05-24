package com.example.bodybuilding.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.playbuilding.activity.SelectWeightActivity;


/**
 * Created by cqian on 2017/5/4.
 */
public abstract class BaseActivity extends Activity {
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (setNoTitle()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        initView();
        getData();
        IntentFilter filter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        registerReceiver(mHomeKeyEventReceiver,filter );
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mHomeKeyEventReceiver);
        super.onDestroy();
    }

    protected abstract void initView();

    protected abstract void getData();

    protected abstract int getLayoutId();

    protected boolean setNoTitle() {
        return true;
    }

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    protected <T extends View> T getView(View view, int id) {
        return (T) view.findViewById(id);
    }
    private BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
        String SYSTEM_REASON = "reason";
        String SYSTEM_HOME_KEY = "homekey";
        String SYSTEM_HOME_KEY_LONG = "recentapps";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) { // 监听home键
                String reason = intent.getStringExtra(SYSTEM_REASON);
                // 表示按了home键,程序到了后台
                startActivity(new Intent(mContext, SelectWeightActivity.class));
            }
        }
    };
}

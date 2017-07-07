package com.example.playbuilding.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.playbuilding.activity.SelectWeightFragment;


/**
 * Created by cqian on 2017/5/12.
 */
public class BootReceiver extends BroadcastReceiver {

    static final String action_boot = "android.intent.action.BOOT_COMPLETED";


    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(intent.getAction()+"    66666666666666");
        if(intent.getAction().equals(action_boot)) {     // boot
            System.out.println("启动。。。");
            Intent intent2 = new Intent(context, SelectWeightFragment.class);
//          intent2.setAction("android.intent.action.MAIN");
//          intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }
    }

}
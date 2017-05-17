package com.example.playbuilding.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.playbuilding.activity.MainActivity;

/**
 * Created by cqian on 2017/5/12.
 */
public class BootReceiver extends BroadcastReceiver {

    static final String action_boot = "android.intent.action.BOOT_COMPLETED";


    @Override

    public void onReceive(Context context, Intent intent) {
        System.out.println("====开机了====");

        Intent bootStartIntent = new Intent(context, MainActivity.class);

        bootStartIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(bootStartIntent);


    }

}
package com.example.playbuilding.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseActivity;

public class PlayVideoActivity extends BaseActivity {
    private VideoView mVideoView;
    private ImageView mIvGo;
    TextView mTvSr, mTvSt, mTvSw;
    int mReCount = 20, mTimeCount = 30, mInitReCount;
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mReCount--;
            mTimeCount--;
            if (mTimeCount >= 0) {
                if (mTimeCount>=10){
                    mTvTime.setText("00:" + mTimeCount);
                }else {
                    mTvTime.setText("00:0" + mTimeCount);
                }

            } else {

            }
            if (mReCount >= 0) {
                mTvReCount.setText(mReCount + "");
            } else {
                //            如果在时间倒计结束前,次数倒计已经结束,则次数那里显示的值是倒计的初始值加上多出来的次数,
//                    以20次倒计为例,20,19,18…..1,0,21,22,…直至时间倒计结束.
                if (mTimeCount >= 0) {
                    mInitReCount++;
                    mTvReCount.setText(mInitReCount + "");
                }
            }
            if (mTimeCount > 0 || mReCount > 0) {
                mHandle.sendEmptyMessageDelayed(0, 1000);
            }

        }
    };
    TextView mTvReCount, mTvTime;

    @Override
    protected void initView() {
        mIvGo = getView(R.id.ivGo);
        mTvReCount = getView(R.id.tvReCount);
        mTvTime = getView(R.id.tvTime);
        mTvSr = getView(R.id.tvSr);
        mTvSt = getView(R.id.tvSt);
        mTvSw = getView(R.id.tvSw);
        Intent intent=getIntent();
        if (intent!=null && intent.getExtras()!=null){
            mReCount=intent.getIntExtra("one", 20);
            String twoStr=intent.getStringExtra("two");
            if (twoStr!=null){
                mTimeCount=Integer.valueOf(twoStr.substring(3,5));
            }
            mTvReCount.setText(mReCount+"");
            if (mTimeCount>=10){
                mTvTime.setText("00:" + mTimeCount);
            }else {
                mTvTime.setText("00:0" + mTimeCount);
            }
        }
        mInitReCount = mReCount;
        mHandle.sendEmptyMessageDelayed(0, 1000);

        mTvSr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SelectManualActivity.class));
            }
        });
        mTvSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SelectManualActivity.class));
            }
        });
        mTvSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SelectWeightActivity.class));
            }
        });
        mIvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WorkoutSummaryActivity.class);
                startActivity(intent);
            }
        });
        final int id = getIntent().getIntExtra("id", -1);
        if (id == -1) {
            return;
        }
        mVideoView = getView(R.id.videoView);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
//        mVideoView.setMediaController(new MediaController(mContext));
        mVideoView.requestFocus();
        mVideoView.start();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);

            }
        });

        mVideoView
                .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
                        mVideoView.start();
                    }
                });
    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_video;
    }

}

package com.example.playbuilding.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.playbuilding.R;
import com.example.bodybuilding.base.BaseActivity;

public class PlayVideoActivity extends BaseActivity {
    private VideoView mVideoView;
    private ImageView mIvGo;

    @Override
    protected void initView() {
        mIvGo = getView(R.id.ivGo);
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

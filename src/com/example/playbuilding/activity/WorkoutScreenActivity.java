package com.example.playbuilding.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.interfaces.DialogCallback;
import com.example.playbuilding.view.WorkoutSummaryDialog;

/**
 * Created by cqian on 2017/5/11.
 */
public class WorkoutScreenActivity extends BaseActivity {
	private TextView mTvStart;
	private RelativeLayout mRlStart;
	private ImageView mIvAnim, mIvPausePlay, mIvStartPlay;
	private AnimationDrawable mAnim;
	private LinearLayout mLlColor;
	Toast mToast;
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (mScaleAnimation!=null) {
				mTvStart.startAnimation(mScaleAnimation);
			}
			for (int i = 0; i < 20; i++) {
				LinearLayout linearLayout = new LinearLayout(mContext);
				linearLayout.setOrientation(LinearLayout.HORIZONTAL);
				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
				layoutParams.weight = 1;
				for (int j = 0; j < 30; j++) {
					TextView textView = new TextView(mContext);
					if (i < 3) {
						textView.setBackgroundColor(Color.RED);
					} else if (i < 7) {
						textView.setBackgroundColor(Color.YELLOW);
					} else {
						textView.setBackgroundColor(Color.GREEN);
					}
					LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
					layoutParams1.weight = 1;
					layoutParams1.setMargins(1, 1, 1, 1);
					linearLayout.addView(textView, layoutParams1);
				}
				mLlColor.addView(linearLayout, layoutParams);
			}
		};
	};
	private ScaleAnimation mScaleAnimation;

	@Override
	protected void initView() {
		mToast = Toast.makeText(mContext, "", Toast.LENGTH_LONG);
		mTvStart = getView(R.id.tvStart);
		mIvPausePlay = getView(R.id.ivPausePlay);
		mIvStartPlay = getView(R.id.ivStartPlay);
		mRlStart = getView(R.id.rlStart);
		mRlStart.setVisibility(View.VISIBLE);
		mLlColor = getView(R.id.llColor);
		mIvAnim = getView(R.id.ivAnim);

		mIvPausePlay.setClickable(false);
		mIvStartPlay.setClickable(false);

		mScaleAnimation = new ScaleAnimation(1, 0.5f, 1, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		mScaleAnimation.setDuration(1000);
		final ScaleAnimation scaleAnimationEnd = new ScaleAnimation(1, 0.2f, 1, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		scaleAnimationEnd.setDuration(1000);
		mScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				try {
					int temp = Integer.valueOf(mTvStart.getText().toString());
					if (temp > 1) {
						temp--;
						mTvStart.setText(temp + "");
						mTvStart.startAnimation(mScaleAnimation);
					} else {
						mTvStart.setTextSize(TypedValue.COMPLEX_UNIT_SP, 120);
						mTvStart.setText("GO");
						mTvStart.startAnimation(scaleAnimationEnd);
					}
				} catch (Exception e) {

				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		scaleAnimationEnd.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				mRlStart.setVisibility(View.GONE);
				mIvAnim.setImageDrawable(mAnim);
				mAnim.start();
				mIvPausePlay.setClickable(true);
				mIvStartPlay.setClickable(true);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		mHandler.sendEmptyMessageDelayed(0, 500);
		mIvPausePlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mAnim != null && mAnim.isRunning()) {
					mAnim.stop();
					mIvPausePlay.setBackgroundResource(R.drawable.workout_screen_pause_selector);

					mToast.setGravity(Gravity.CENTER, 0, 0);

					View view = View.inflate(mContext, R.layout.work_screen_toast, null);
					mToast.setView(view);
					mToast.show();

				} else {
					mToast.cancel();
					WorkoutSummaryDialog dialog = new WorkoutSummaryDialog(mContext, new DialogCallback() {

						@Override
						public void click(View view) {
							startActivity(new Intent(mContext, MainActivity.class));
						}
					});
				}
			}
		});

		mIvStartPlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mAnim != null && !mAnim.isRunning()) {
					mIvPausePlay.setBackgroundResource(R.drawable.workout_screen_end_selector);
					mAnim.start();
				}
			}
		});

		mAnim = new AnimationDrawable();
		for (int i = 1; i <= 6; i++) {
			// k_countdown_middle_img_back
			// k_countdown_middle_img_biceps
			// k_countdown_middle_img_kayak
			// k_countdown_middle_img_seated
			// k_countdown_middle_img_shoulder
			// k_countdown_middle_img_triceps
			mAnim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_back), 500);
			mAnim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_biceps), 500);
			// anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_kayak),
			// 200);
			// anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_seated),
			// 200);
			// anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_shoulder),
			// 200);
			// anim.addFrame(getResources().getDrawable(R.drawable.k_countdown_middle_img_triceps),
			// 200);
		}
		mAnim.setOneShot(false);

	}

	@Override
	protected void getData() {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_workout_screen;
	}
}

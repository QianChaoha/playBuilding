package com.example.playbuilding.activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.interfaces.DialogCallback;
import com.example.playbuilding.util.ScreenUtil;
import com.example.playbuilding.view.CommenDialog;
import com.example.playbuilding.view.LanguageDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {
	private LinearLayout mLinearLayout;
	private ImageView ivQuickStart;
	private int mCurrentItem = 0;
	private int mWhat = 0;
	private int mTotal = 5;
	private TextView mTvSelectText;
	private final long DURATION = 2000;
	private String[] selectTextArr = new String[] { "Select a workout or touch \"Quick Start\" to begin.",
			"Touch the i icon for complete workout descriptions.",
			"Ensure the bike is in the correct position and the Rotary Motion lever is locked down.",
			"Read and understand all safely information before starting workout.",
			"Visit www.avantifitness.com for additional workouts and exercise tips " };
	private boolean mIsFirst = true;
	private RelativeLayout mRl1, mRl2, mRl3, mRl4, mRl5;
	private RelativeLayout[] mRls = new RelativeLayout[5];
	private ImageView iv11, iv22, iv33, iv44, iv55;
	private ImageView iv1, iv2, iv3, iv4, iv5;
	private int[] mInfoImgsCw = new int[] { R.drawable.back_ext_img_32, R.drawable.biceps_curl_img_31, R.drawable.triceps_kb_img_30,
			R.drawable.shoulder_hl_img_29, R.drawable.seated_row_img_28, R.drawable.back_ext_img_32, R.drawable.chest_press_img_25,
			R.drawable.pec_fly_img_24, R.drawable.triceps_ext_img_23, R.drawable.pullover_img_22, R.drawable.ab_crunch_img_21,
			R.drawable.black_img_45 };
	private int[] mInfoImgs12r = new int[] { R.drawable.left_img_43, R.drawable.black_img_45, R.drawable.right_img_44 };
	private int[] mInfoImgsF5 = new int[] { R.drawable.back_ext_img_32, R.drawable.biceps_curl_img_31, R.drawable.triceps_kb_img_30,
			R.drawable.shoulder_hl_img_29, R.drawable.seated_row_img_28 };
	private int[] mInfoImgsB5 = new int[] { R.drawable.chest_press_img_25, R.drawable.pec_fly_img_24, R.drawable.triceps_ext_img_23,
			R.drawable.pullover_img_22, R.drawable.ab_crunch_img_21 };
	private int[] mInfoImgsFs = new int[] { R.drawable.usb_img_8 };
	private RelativeLayout mRlEnglish, mRlGettingStart;
	private Handler mHandle = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			mTvSelectText.setText(selectTextArr[mCurrentItem]);
			mCurrentItem++;
			mCurrentItem = mCurrentItem % mTotal;

			for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
				ImageView imageView = (ImageView) mLinearLayout.getChildAt(i);
				if (i == mCurrentItem) {
					imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
				} else {
					imageView.setBackgroundResource(R.drawable.black_stage_1_56);
				}
			}
			if (mHandle != null) {
				mHandle.sendEmptyMessageDelayed(mWhat, 3000);
			}

		}
	};
	SharedPreferences mSharedPreferences;
	SharedPreferences.Editor mEditor;

	@Override
	protected void initView() {
		// ==================================================
		mSharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
		mEditor = mSharedPreferences.edit();
		boolean temp = mSharedPreferences.getBoolean("isFirst", true);
		
		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
		if (file != null) {
			if (!file.exists()) {
				file.mkdirs();
			}
		}
		File childFile = new File(file, "config.txt");
		if (childFile != null) {
			if (!childFile.exists()) {
				try {
					childFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (temp) {
			FileReader fileReader=null;
			BufferedReader reader=null;
			BufferedWriter writer=null;
			try {
				 fileReader = new FileReader(childFile);
				 reader = new BufferedReader(fileReader);
				String line = reader.readLine();
				//第一次启动
				if (!TextUtils.isEmpty(line)) {
					//之前有安装过
					long time = Long.valueOf(line);
					int dTime = (int) ((System.currentTimeMillis() - time) / (1000 * 60 * 60 * 24));
					if (dTime > 6) {
						finish();
					}
				}else {
					//确实是第一次安装
					writer=new BufferedWriter(new FileWriter(childFile));
					writer.write(System.currentTimeMillis()+"");
					writer.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (fileReader!=null) {
					try {
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (reader!=null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (writer!=null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		if (temp) {
			mEditor.putBoolean("isFirst", false);
			mEditor.putLong("time", System.currentTimeMillis()).commit();
		} else {
			long time = mSharedPreferences.getLong("time", System.currentTimeMillis());
			int dTime = (int) ((System.currentTimeMillis() - time) / (1000 * 60 * 60 * 24));
			if (dTime > 4) {
				finish();
			}
		}
		// ==================================================

		mLinearLayout = getView(R.id.linearLayout);
		mTvSelectText = getView(R.id.tvSelectText);
		mRlEnglish = getView(R.id.rlEnglish);
		mRlGettingStart = getView(R.id.rlGettingStart);
		ivQuickStart = getView(R.id.ivQuickStart);
		ivQuickStart.setOnClickListener(this);
		mRlEnglish.setOnClickListener(this);
		mRlGettingStart.setOnClickListener(this);
		iv11 = getView(R.id.iv11);
		iv11.setOnClickListener(this);
		iv22 = getView(R.id.iv22);
		iv22.setOnClickListener(this);
		iv33 = getView(R.id.iv33);
		iv33.setOnClickListener(this);
		iv44 = getView(R.id.iv44);
		iv44.setOnClickListener(this);
		iv55 = getView(R.id.iv55);
		iv55.setOnClickListener(this);
		iv1 = getView(R.id.iv1);
		iv1.setOnClickListener(this);
		iv2 = getView(R.id.iv2);
		iv2.setOnClickListener(this);
		iv3 = getView(R.id.iv3);
		iv3.setOnClickListener(this);
		iv4 = getView(R.id.iv4);
		iv4.setOnClickListener(this);
		iv5 = getView(R.id.iv5);
		iv5.setOnClickListener(this);
		mRl1 = getView(R.id.rl1);
		mRl2 = getView(R.id.rl2);
		mRl3 = getView(R.id.rl3);
		mRl4 = getView(R.id.rl4);
		mRl5 = getView(R.id.rl5);
		mRls[0] = mRl1;
		mRls[1] = mRl2;
		mRls[2] = mRl3;
		mRls[3] = mRl4;
		mRls[4] = mRl5;
		for (int i = 0; i < mRls.length; i++) {
			mRls[i].setVisibility(View.GONE);
		}
		initList();
		mHandle.sendEmptyMessageAtTime(mWhat, 3000);
	}

	private void initList() {
		mLinearLayout.removeAllViews();
		for (int i = 0; i < 5; i++) {
			ImageView imageView = new ImageView(mContext);
			if (i == 0) {
				imageView.setBackgroundResource(R.drawable.grey_stage_1_64);
			} else {
				imageView.setBackgroundResource(R.drawable.black_stage_1_56);
			}
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ScreenUtil.dip2px(mContext, 10), ScreenUtil.dip2px(mContext, 10));
			mLinearLayout.addView(imageView, layoutParams);
		}

	}

	@Override
	protected void getData() {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.main;
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (mIsFirst) {
			mIsFirst = false;
			// for (int i = 0; i < mRlX.length; i++) {
			// mRlX[i] = (int) mRls[i].getX();
			// mRlY[i] = (int) mRls[i].getY();
			// }
			startAnim();

			for (int i = 0; i < mRls.length; i++) {
				mRls[i].setVisibility(View.VISIBLE);
			}
		}
	}

	private void startAnim() {
		ObjectAnimator moveX = ObjectAnimator.ofFloat(mRls[0], "translationX", -500, 0);
		ObjectAnimator moveY = ObjectAnimator.ofFloat(mRls[0], "translationY", -100, 0);
		AnimatorSet animSet = new AnimatorSet();
		animSet.play(moveX).with(moveY);
		animSet.setDuration(DURATION);
		animSet.start();

		ObjectAnimator moveX1 = ObjectAnimator.ofFloat(mRls[1], "translationX", -200, 0);
		ObjectAnimator moveY1 = ObjectAnimator.ofFloat(mRls[1], "translationY", -400, 0);
		AnimatorSet animSet1 = new AnimatorSet();
		animSet1.play(moveX1).with(moveY1);
		animSet1.setDuration(DURATION);
		animSet1.start();

		ObjectAnimator moveY2 = ObjectAnimator.ofFloat(mRls[2], "translationY", -500, 0);
		AnimatorSet animSet2 = new AnimatorSet();
		animSet2.play(moveY2);
		animSet2.setDuration(DURATION);
		animSet2.start();

		ObjectAnimator moveX3 = ObjectAnimator.ofFloat(mRls[3], "translationX", 200, 0);
		ObjectAnimator moveY3 = ObjectAnimator.ofFloat(mRls[3], "translationY", -400, 0);
		AnimatorSet animSet3 = new AnimatorSet();
		animSet3.play(moveY3).with(moveX3);
		animSet3.setDuration(DURATION);
		animSet3.start();

		ObjectAnimator moveX4 = ObjectAnimator.ofFloat(mRls[4], "translationX", 500, 0);
		ObjectAnimator moveY4 = ObjectAnimator.ofFloat(mRls[4], "translationY", 100, 0);
		AnimatorSet animSet4 = new AnimatorSet();
		animSet4.play(moveY4).with(moveX4);
		animSet4.setDuration(DURATION);
		animSet4.start();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		startAnim();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mHandle != null) {
			mHandle.removeMessages(mWhat);
			mHandle = null;
		}
	}

	@Override
	public void onClick(View v) {
		CommenDialog commenDialog;
		switch (v.getId()) {
		case R.id.iv11:
			commenDialog = new CommenDialog(mContext, mInfoImgsCw, 6, new DialogCallback() {
				@Override
				public void click(View view) {

				}
			});
			break;
		case R.id.iv22:
			commenDialog = new CommenDialog(mContext, mInfoImgs12r, 3, new DialogCallback() {
				@Override
				public void click(View view) {

				}
			});
			break;
		case R.id.iv33:
			commenDialog = new CommenDialog(mContext, mInfoImgsF5, 5, new DialogCallback() {
				@Override
				public void click(View view) {

				}
			});
			break;
		case R.id.iv44:
			commenDialog = new CommenDialog(mContext, mInfoImgsB5, 6, new DialogCallback() {
				@Override
				public void click(View view) {

				}
			});
			break;
		case R.id.iv55:
			commenDialog = new CommenDialog(mContext, mInfoImgsFs, 3, new DialogCallback() {
				@Override
				public void click(View view) {

				}
			});
			break;
		case R.id.rlEnglish:
			LanguageDialog languageDialog = new LanguageDialog(mContext, new DialogCallback() {

				@Override
				public void click(View view) {

				}
			});
			break;
		case R.id.ivQuickStart:
			startActivity(new Intent(mContext, SelectWeightActivity.class));
			break;
		case R.id.iv1:
			startActivity(new Intent(mContext, SelectWeightActivity.class));
			break;
		case R.id.iv2:
			startActivity(new Intent(mContext, SelectWeightActivity.class));
			break;
		case R.id.iv3:
			startActivity(new Intent(mContext, SelectWeightActivity.class));
			break;
		case R.id.iv4:
			startActivity(new Intent(mContext, SelectWeightActivity.class));
			break;
		case R.id.iv5:
			startActivity(new Intent(mContext, SelectWeightActivity.class));
			break;
		case R.id.rlGettingStart:
			startActivity(new Intent(mContext, ClubSettingActivity.class));
			break;
		}
	}
}

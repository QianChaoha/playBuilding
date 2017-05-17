package com.example.playbuilding.view;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.interfaces.DialogCallback;

/**
 * Description: Company: guanghua
 * 
 * @author qianchao
 */
public class WorkoutSummaryDialog {
	private TextView tv_negative;
	private MyDialog mDialog;
	private TextView tv_title, tv_content, tv_ok;
	private DialogCallback mDialogInterface;
	private boolean callBack = false;
	private TextView tv_positive;
	private boolean[] selects;

	public void setmDialogInterface(DialogCallback mDialogInterface) {
		this.mDialogInterface = mDialogInterface;

	}

	public WorkoutSummaryDialog(Context context, final DialogCallback mDialogInterface) {
		this.mDialogInterface = mDialogInterface;
		View view = View.inflate(context, R.layout.workout_summary, null);
		TextView tvHome= (TextView) view.findViewById(R.id.tvHome);
		if (context instanceof Activity) {
			Activity activity = (Activity) context;
			WindowManager m = activity.getWindowManager();
			Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
			mDialog = new MyDialog(context,(int) (d.getWidth() * 0.9), (int) (d.getHeight() * 0.9),view,R.style.dialog);
		}else {
			mDialog = new MyDialog(context, view, R.style.dialog);
		}
		tvHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mDialogInterface.click(v);
			}
		});
		mDialog.show();

	}
}

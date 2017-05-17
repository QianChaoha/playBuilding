package com.example.playbuilding.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.adapter.InfoDialogAdapter;
import com.example.playbuilding.interfaces.DialogCallback;

/**
 * Description: Company: guanghua
 * 
 * @author qianchao
 */
public class CommenDialog {
	private TextView tv_negative;
	private MyDialog mDialog;
	private TextView tv_title, tv_content, tv_ok;
	private DialogCallback mDialogInterface;
	private boolean callBack = false;
	private TextView tv_positive;

	public void setmDialogInterface(DialogCallback mDialogInterface) {
		this.mDialogInterface = mDialogInterface;
	}

	public CommenDialog(Context context, int[] arr, int numColumns, final DialogCallback mDialogInterface) {
		this.mDialogInterface = mDialogInterface;
		View view = View.inflate(context, R.layout.info, null);
		final LinearLayout llRoot=(LinearLayout) view.findViewById(R.id.llRoot);
		GridView gridView = (GridView) view.findViewById(R.id.gridView);
		final RelativeLayout rlBottom = (RelativeLayout) view.findViewById(R.id.rlBottom);
		final RelativeLayout rlHead = (RelativeLayout) view.findViewById(R.id.rlHead);
		final TextView tvContent = (TextView) view.findViewById(R.id.tvContent);
		ImageView ivBottom = (ImageView) view.findViewById(R.id.ivBottom);
		if (arr.length == 1) {
			gridView.setVisibility(View.GONE);
			rlBottom.setVisibility(View.VISIBLE);
			rlBottom.post(new Runnable() {
				
				@Override
				public void run() {
					LinearLayout.LayoutParams layoutParams= (LayoutParams) rlBottom.getLayoutParams();
					layoutParams.height=llRoot.getHeight()-rlHead.getHeight()-tvContent.getHeight();
					rlBottom.setLayoutParams(layoutParams);
				}
			});
//			ivBottom.setBackgroundResource(arr[0]);
		}
		TextView tvClose = (TextView) view.findViewById(R.id.tvClose);
		tvClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mDialogInterface.click(v);
				mDialog.dismiss();
			}
		});
		// 每行numColumns个图片
		gridView.setNumColumns(numColumns);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		gridView.setAdapter(new InfoDialogAdapter(context, list));
		mDialog = new MyDialog(context, view, R.style.dialog);
		// if (context instanceof Activity) {
		// Activity activity = (Activity) context;
		// WindowManager m = activity.getWindowManager();
		// Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		// WindowManager.LayoutParams p = activity.getWindow().getAttributes();
		// // 获取对话框当前的参数值
		// p.height = (int) (d.getHeight() * 0.5); // 高度设置为屏幕的0.5
		// p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
		// mDialog.getWindow().setAttributes(p);
		// }
		mDialog.show();

	}
	/**
	 * 
	 * @param context
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param mDialogInterface
	 *            dialog点击事件 回调接口
	 */
	// public CommenDialog(Context context, String title, String content, final
	// DialogCallback mDialogInterface) {
	// this.mDialogInterface = mDialogInterface;
	// View view = View.inflate(context, R.layout.info, null);
	// mDialog = new MyDialog(context, view, R.style.dialog);
	//
	// tv_title = (TextView) view.findViewById(R.id.tv_title);
	// tv_content = (TextView) view.findViewById(R.id.tv_content);
	// tv_ok = (TextView) view.findViewById(R.id.tv_ok);
	//
	// tv_title.setText(title);
	// tv_content.setText(content);
	//
	// // 确定按钮点击事件的回调
	// tv_ok.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// mDialog.dismiss();
	// if (CommenDialog.this.mDialogInterface != null) {
	// CommenDialog.this.mDialogInterface.ok_click(v);
	// }
	// }
	// });
	// mDialog.show();
	// }
	//
	// public CommenDialog(Context context, final DialogCallback
	// mDialogInterface) {
	// this.mDialogInterface = mDialogInterface;
	// View view = View.inflate(context, R.layout.progress_dialog_layout, null);
	// mDialog = new MyDialog(context, view, R.style.dialog);
	//
	// tv_content = (TextView) view.findViewById(R.id.tv_content);
	// tv_ok = (TextView) view.findViewById(R.id.tv_ok);
	//
	// // 确定按钮点击事件的回调
	// tv_ok.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// mDialog.dismiss();
	// if (callBack) {
	// if (CommenDialog.this.mDialogInterface!=null) {
	// CommenDialog.this.mDialogInterface.ok_click(v);
	// }
	// callBack = false;
	// }
	// }
	// });
	//
	// }
	//
	// public CommenDialog(Context context) {
	// this.mDialogInterface = mDialogInterface;
	// View view = View.inflate(context, R.layout.near_dialog_layout, null);
	// mDialog = new MyDialog(context, view, R.style.dialog);
	// }
	//
	// /**
	// * 2个button
	// *
	// * @param context
	// * @param buttonCallback
	// */
	//
	// public CommenDialog(Context context, final ButtonCallback buttonCallback,
	// String flag) {
	//
	// this.buttonCallback = buttonCallback;
	//
	// View view = View.inflate(context,
	// R.layout.progress_dialog_multiple_layout, null);
	// mDialog = new MyDialog(context, view, R.style.dialog);
	//
	// tv_content = (TextView) view.findViewById(R.id.tv_content);
	// tv_positive = (TextView) view.findViewById(R.id.tv_positive);
	// tv_negative = (TextView) view.findViewById(R.id.tv_negative);
	//
	//
	// tv_positive.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// mDialog.dismiss();
	// if (buttonCallback != null) {
	// buttonCallback.onPositive(mDialog);
	// }
	// }
	// });
	//
	//
	// tv_negative.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// mDialog.dismiss();
	// if (buttonCallback != null) {
	// buttonCallback.onNegative(mDialog);
	// }
	// }
	// });
	//
	// }
	//
	// public void showWithCallBack(String content) {
	// this.callBack = true;
	// tv_content.setText(content);
	// mDialog.show();
	// }
	//
	// public void show(String content) {
	// this.callBack = false;
	// if (tv_content != null) {
	// tv_content.setText(content);
	// }
	// try {
	// mDialog.show();
	// } catch (Exception e) {
	// }
	// }
	//
	// public void dismiss() {
	// mDialog.dismiss();
	// }
	// public boolean isShowing() {
	// return mDialog.isShowing();
	// }
	//
	// public static abstract class ButtonCallback {
	//
	// public void onPositive(MyDialog dialog) {
	//
	// }
	//
	// public void onNegative(MyDialog dialog) {
	// }
	// }
}

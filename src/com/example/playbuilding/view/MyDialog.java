package com.example.playbuilding.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Description: Company: guanghua
 * 
 * @author qianchao
 */
public class MyDialog extends Dialog {
//	private static int default_width = 140; // 默认宽度
//	private static int default_height = 120;// 默认高度

	public MyDialog(Context context, View layout, int style) {
		this(context, 0, 0, layout, style);
	}

	public MyDialog(Context context, int width, int height, View layout, int style) {
		super(context, style);
		setContentView(layout);
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		params.gravity = Gravity.CENTER;
		if (width!=0 && height!=0) {
			params.width=width;
			params.height=height;
		}
		window.setAttributes(params);
	}

}

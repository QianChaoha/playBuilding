package com.example.playbuilding.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.adapter.SelectLanguageAdapter;
import com.example.playbuilding.entity.SelectLanguageEntity;
import com.example.playbuilding.interfaces.DialogCallback;

/**
 * Description: Company: guanghua
 * 
 * @author qianchao
 */
public class LanguageDialog {
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

	public LanguageDialog(Context context, final DialogCallback mDialogInterface) {
		this.mDialogInterface = mDialogInterface;
		View view = View.inflate(context, R.layout.language, null);
		GridView gridView = (GridView) view.findViewById(R.id.gridView);
		List<SelectLanguageEntity> list = new ArrayList<SelectLanguageEntity>();
		list.add(new SelectLanguageEntity(R.drawable.english_48, "English"));
		list.add(new SelectLanguageEntity(R.drawable.german_47, "Deutsch"));
		list.add(new SelectLanguageEntity(R.drawable.french_46, "Francaise"));
		list.add(new SelectLanguageEntity(R.drawable.italian_45, "Italiano"));
		list.add(new SelectLanguageEntity(R.drawable.spanish_44, "Espanol"));
		list.add(new SelectLanguageEntity(R.drawable.dutch_43, "Nederlands"));
		list.add(new SelectLanguageEntity(R.drawable.portuguese_42, "Portugues"));
		list.add(new SelectLanguageEntity(R.drawable.chinese_41, "中文"));
		list.add(new SelectLanguageEntity(R.drawable.japanese_40, "日本"));
		list.add(new SelectLanguageEntity(R.drawable.korean_39, "韩国本"));
		selects=new boolean[list.size()];
		selects[0]=true;
		
		gridView.setAdapter(new SelectLanguageAdapter(context, list,selects));
		TextView tvCancel = (TextView) view.findViewById(R.id.tvCancel);
		tvCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mDialog.dismiss();
			}
		});
		TextView tvOk = (TextView) view.findViewById(R.id.tvOk);
		tvOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mDialog.dismiss();
			}
		});
		mDialog = new MyDialog(context, view, R.style.dialog);
		mDialog.show();

	}
}

package com.example.playbuilding.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseAdapter;
import com.example.playbuilding.base.ViewHolder;
import com.example.playbuilding.entity.CustomerWorkoutEntity;

import java.util.List;

/**
 * Created by cqian on 2017/5/9.
 */
public class CustomerWorkoutBottomAdapter extends BaseAdapter<CustomerWorkoutEntity> {
    private boolean[] select;
    public CustomerWorkoutBottomAdapter(Context context, List<CustomerWorkoutEntity> list) {
        super(context, list);
        select=new boolean[list.size()];
        select[0]=true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.customer_workout_bottom_item;
    }

    @Override
    protected void onViewCreated(ViewHolder holder, final int position) {
        TextView tvContent=holder.get(R.id.tvTop);
        ImageView ivCheckBox=holder.get(R.id.ivCheckBox);
        tvContent.setText(getItem(position).mText);
        ImageView imageView=holder.get(R.id.imageView);
        if (getItem(position).mImageId==-1) {
        	imageView.setBackgroundResource(getItem(0).mImageId);
		}else if (getItem(position).mImageId==-2){
			imageView.setBackgroundResource(R.drawable.default_1);
		}else{
            imageView.setBackgroundResource(getItem(position).mImageId);
        }
        if (select[position]){
            ivCheckBox.setBackgroundResource(R.drawable.italiano_state2_30);
        }else {
            ivCheckBox.setBackgroundResource(R.drawable.italiano_state1_29);
        }
        ivCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < select.length; i++) {
                    if (i==position){
                        select[i]=true;
                    }else {
                        select[i]=false;
                    }
                }
                notifyDataSetChanged();
            }
        });
    }
    public int getSelect(){
        for (int i = 0; i < select.length; i++) {
            if (select[i]){
                return  i;
            }
        }
        return 0;
    }
}

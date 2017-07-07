package com.example.playbuilding.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseFragment;

/**
 * Created by cqian on 2017/5/17.
 */
public class SelectManualFragment extends BaseFragment implements OnClickListener {
    private ImageView mIvGo, mIvOneRightAdd, mIvOneRightReduce, mIvTwoLeftAdd, mIvTwoRightReduce, mIvThreeLeftAdd, mIvThreeRightReduce;
    private EditText mTvOne, mTvTwo, mTvThree;
    private TextView mTvReset;
    private TextView tvOne5, tvOne10, tvOne20, tvTwo10, tvTwo20, tvTwo30, tvThree10, tvThree20, tvThree30;

    @Override
    protected void initView() {

        mIvGo = getView(R.id.ivGo);
        mTvReset = getView(R.id.tvReset);
        mIvTwoLeftAdd = getView(R.id.ivTwoLeftAdd);
        mIvTwoLeftAdd.setOnClickListener(this);
        mIvTwoRightReduce = getView(R.id.ivTwoLeftReduce);
        mIvTwoRightReduce.setOnClickListener(this);

        mIvOneRightAdd = getView(R.id.ivOneRightAdd);
        mIvOneRightAdd.setOnClickListener(this);
        mIvOneRightReduce = getView(R.id.ivOneRightReduce);
        mIvOneRightReduce.setOnClickListener(this);

        mIvThreeRightReduce = getView(R.id.ivThreeLeftReduce);
        mIvThreeRightReduce.setOnClickListener(this);
        mIvThreeLeftAdd = getView(R.id.ivThreeLeftAdd);
        mIvThreeLeftAdd.setOnClickListener(this);
        mIvGo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                int one, two, three;
                try {
                    one = Integer.valueOf(mTvOne.getText().toString());
                } catch (Exception e) {
                    showToast("Repetitions选项输入不合法");
                    return;
                }
                String twoStr = mTvTwo.getText().toString();
                if (twoStr != null && twoStr.length() == 5 && ":".equals(twoStr.charAt(2)+"")) {

                } else {
                    showToast("Time选项输入不合法");
                    return;
                }
                String threeStr = mTvThree.getText().toString();
                if (threeStr != null && threeStr.length() == 5 && ":".equals(threeStr.charAt(2)+"")) {

                } else {
                    showToast("Interval Time选项输入不合法");
                    return;
                }
                bundle.putInt("one", one);
                bundle.putString("two", twoStr);
                bundle.putString("three", threeStr);
                mContext.goPv(bundle);
            }
        });
        mTvReset.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mContext.goSw();
            }
        });
        mTvOne = getView(R.id.tvOne);
        mTvTwo = getView(R.id.tvTwo);
        mTvThree = getView(R.id.tvThree);
        tvOne5 = getView(R.id.tvOne5);
        tvOne10 = getView(R.id.tvOne10);
        tvOne20 = getView(R.id.tvOne20);
        tvOne5.setOnClickListener(this);
        tvOne10.setOnClickListener(this);
        tvOne20.setOnClickListener(this);

        tvTwo20 = getView(R.id.tvTwo20);
        tvTwo10 = getView(R.id.tvTwo10);
        tvTwo30 = getView(R.id.tvTwo30);
        tvTwo20.setOnClickListener(this);
        tvTwo10.setOnClickListener(this);
        tvTwo30.setOnClickListener(this);

        tvThree10 = getView(R.id.tvThree10);
        tvThree20 = getView(R.id.tvThree20);
        tvThree30 = getView(R.id.tvThree30);
        tvThree10.setOnClickListener(this);
        tvThree20.setOnClickListener(this);
        tvThree30.setOnClickListener(this);
    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_manual;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivOneRightAdd:
                int temp1 = Integer.valueOf(mTvOne.getText().toString());
                mTvOne.setText(++temp1 + "");
                break;
            case R.id.ivOneRightReduce:
                int temp2 = Integer.valueOf(mTvOne.getText().toString());
                mTvOne.setText(--temp2 + "");
                break;
            case R.id.ivTwoLeftAdd:
                int temp3 = Integer.valueOf(mTvTwo.getText().toString());
                mTvTwo.setText(++temp3 + "");
                break;
            case R.id.ivTwoLeftReduce:
                int temp4 = Integer.valueOf(mTvTwo.getText().toString());
                mTvTwo.setText(--temp4 + "");
                break;
            case R.id.ivThreeLeftAdd:
                int temp5 = Integer.valueOf(mTvThree.getText().toString());
                mTvThree.setText(++temp5 + "");
                break;
            case R.id.ivThreeLeftReduce:
                int temp6 = Integer.valueOf(mTvThree.getText().toString());
                mTvThree.setText(--temp6 + "");
                break;
            case R.id.tvOne5:
                mTvOne.setText("5");
                setTvBg(tvOne5, tvOne10, tvOne20);
                break;
            case R.id.tvOne10:
                mTvOne.setText("10");
                setTvBg(tvOne10, tvOne5, tvOne20);
                break;
            case R.id.tvOne20:
                mTvOne.setText("20");
                setTvBg(tvOne20, tvOne10, tvOne5);
                break;
            case R.id.tvTwo10:
                mTvTwo.setText("10");
                setTvBg(tvTwo10, tvTwo20, tvTwo30);
                break;
            case R.id.tvTwo20:
                mTvTwo.setText("20");
                setTvBg(tvTwo20, tvTwo10, tvTwo30);
                break;
            case R.id.tvTwo30:
                mTvTwo.setText("30");
                setTvBg(tvTwo30, tvTwo10, tvTwo20);
                break;
            case R.id.tvThree10:
                mTvThree.setText("10");
                setTvBg(tvThree10, tvThree20, tvThree30);
                break;
            case R.id.tvThree20:
                mTvThree.setText("20");
                setTvBg(tvThree20, tvThree10, tvThree30);
                break;
            case R.id.tvThree30:
                mTvThree.setText("30");
                setTvBg(tvThree30, tvThree10, tvThree20);
                break;

        }
    }

    public void setTvBg(TextView tvOne, TextView tvTwo, TextView tvThree) {
        tvOne.setBackgroundResource(R.drawable.bt_blue);
        tvTwo.setBackgroundResource(R.drawable.i_but_sizebg_n);
        tvThree.setBackgroundResource(R.drawable.i_but_sizebg_n);
    }

    public void showToast(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }

}


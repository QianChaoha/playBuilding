package com.example.playbuilding.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.playbuilding.R;
import com.example.playbuilding.base.BaseActivity;
import com.example.playbuilding.base.BaseAdapter;
import com.example.playbuilding.base.ViewHolder;
import com.example.playbuilding.entity.CustomerWorkoutEntity;

/**
 * Created by cqian on 2017/5/9.
 */
public class HeartrateActivity extends BaseActivity {
    private LinearLayout mRoot;
    private FrameLayout mFlHead;
    private ImageView mIvLeftArrow, mIvRightArrow;
    private ViewPager mViewPager;
    private int mCurrentItem = 0;
    private View mViewOne;
    private View mViewThree;
    private View mViewTwo;
    private TextView mTvLeft, mTvRight, mTvCurrentItem, mTvAge, mTvWeight, mTvBottmWeight, mTvBottomAge;
    private ImageView mIvMale, mIvFemale, mIvReduceAge, mIvAddAge, mIvReduceWeight, mIvAddWeight, mIvSex, mIvTopTwo;
    private int[] ivTwoId = new int[]{R.drawable.i_bar_manual, R.drawable.top_pyramid, R.drawable.top_hill_climb, R.drawable.top_interval,
            R.drawable.top_random, R.drawable.i_but_constant_n, R.drawable.top_heartrate};
    private LinearLayout mLlUser, mLlGoal, mLlBikeWorkout;
    private ImageView mIvContinue;

    @Override
    protected void initView() {
        mRoot = getView(R.id.root);
        mFlHead = getView(R.id.flHead);
        mIvLeftArrow = getView(R.id.ivLeftArrow);
        mTvCurrentItem = getView(R.id.tvCurrentItem);
        mViewPager = getView(R.id.viewPager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                mTvCurrentItem.setText("0" + i);
                switch (i) {
                    case 0:
                        setSelectOne();
                        break;
                    case 1:
                        setSelectTwo();
                        break;
                    case 2:
                        setSelectThree();
                        break;
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mTvLeft = getView(R.id.tvLeft);
        mTvRight = getView(R.id.tvRight);
        mIvLeftArrow.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mCurrentItem = mCurrentItem == 0 ? 0 : (--mCurrentItem);
                mViewPager.setCurrentItem(mCurrentItem);
            }
        });
        mIvRightArrow = getView(R.id.ivRightArrow);
        mIvRightArrow.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mCurrentItem = mCurrentItem == 3 ? 3 : (++mCurrentItem);
                mViewPager.setCurrentItem(mCurrentItem);
            }
        });

        setViewHead();
        setViewOne();
        setViewTwo();
        setViewThree();

        List<View> list = new ArrayList<View>();
        list.add(mViewOne);
        list.add(mViewTwo);
        list.add(mViewThree);
        mViewPager.setAdapter(new MyPagerAdapter(mContext, list));
        mIvContinue=getView(R.id.ivContinue);
        mIvContinue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,WorkoutScreenActivity.class));
            }
        });
    }

    private void setSelectOne() {
        mTvLeft.setVisibility(View.GONE);
        mIvLeftArrow.setVisibility(View.GONE);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText("02");
        mIvRightArrow.setVisibility(View.VISIBLE);
    }

    private void setSelectTwo() {
        mTvLeft.setVisibility(View.VISIBLE);
        mIvLeftArrow.setVisibility(View.VISIBLE);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText("03");
        mTvLeft.setText("01");
        mIvRightArrow.setVisibility(View.VISIBLE);
    }

    private void setSelectThree() {
        mTvLeft.setVisibility(View.VISIBLE);
        mIvLeftArrow.setVisibility(View.VISIBLE);
        mTvRight.setVisibility(View.GONE);
        mTvLeft.setText("02");
        mIvRightArrow.setVisibility(View.GONE);
    }

    private void setViewHead() {
        View viewHead = View.inflate(mContext, R.layout.heart_rate_top, null);
        mLlUser = getView(viewHead, R.id.llUser);
        mLlGoal = getView(viewHead, R.id.llGoal);
        mLlBikeWorkout = getView(viewHead, R.id.llBikeWorkout);
        mLlUser.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });
        mLlGoal.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });
        mLlBikeWorkout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });
        mTvAge = getView(viewHead, R.id.tvAge);
        mTvWeight = getView(viewHead, R.id.tvWeight);
        mIvSex = getView(viewHead, R.id.ivSex);
        mIvTopTwo = getView(viewHead, R.id.ivTwo);
        mFlHead.removeAllViews();
        mFlHead.addView(viewHead);
    }

    private void setViewOne() {
        mViewOne = View.inflate(mContext, R.layout.heart_rate_one_view, null);
    }

    private void setViewThree() {

        mViewThree = View.inflate(mContext, R.layout.heart_rate_three_view, null);
        mIvMale = getView(mViewThree, R.id.ivMale);
        mIvFemale = getView(mViewThree, R.id.ivFemale);

        mTvBottmWeight = getView(mViewThree, R.id.tvBottmWeight);
        mTvBottomAge = getView(mViewThree, R.id.tvBottomAge);

        mIvMale.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvMale.setBackgroundResource(R.drawable.italiano_state2_30);
                mIvFemale.setBackgroundResource(R.drawable.italiano_state1_29);
                mIvSex.setBackgroundResource(R.drawable.i_icon_gender_man);
            }
        });
        mIvFemale.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvFemale.setBackgroundResource(R.drawable.italiano_state2_30);
                mIvMale.setBackgroundResource(R.drawable.italiano_state1_29);
                mIvSex.setBackgroundResource(R.drawable.i_icon_gender_women);
            }
        });
        mIvReduceAge = getView(mViewThree, R.id.ivReduceAge);
        mIvAddAge = getView(mViewThree, R.id.ivAddAge);
        mIvReduceWeight = getView(mViewThree, R.id.ivReduceWeight);
        mIvAddWeight = getView(mViewThree, R.id.ivAddWeight);
        mIvReduceAge.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.valueOf(mTvAge.getText().toString()) - 1;
                mTvAge.setText(age + "");
                mTvBottomAge.setText(age + "");
            }
        });
        mIvAddAge.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.valueOf(mTvAge.getText().toString()) + 1;
                mTvAge.setText(age + "");
                mTvBottomAge.setText(age + "");
            }
        });
        mIvReduceWeight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.valueOf(mTvWeight.getText().toString()) - 1;
                mTvWeight.setText(weight + "");
                mTvBottmWeight.setText(weight + "");
            }
        });
        mIvAddWeight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.valueOf(mTvWeight.getText().toString()) + 1;
                mTvWeight.setText(weight + "");
                mTvBottmWeight.setText(weight + "");
            }
        });

    }

    private void setViewTwo() {
        mViewTwo = View.inflate(mContext, R.layout.heart_rate_two_view, null);
        GridView gridView = getView(mViewTwo, R.id.gridView);

        final List<CustomerWorkoutEntity> list1 = new ArrayList<CustomerWorkoutEntity>();
        initList(list1);
        // list1.add(new CustomerWorkoutEntity(R.drawable.i_but_manual_n,
        // "Manual"));
        gridView.setSelector(R.drawable.nothing);
        final HeartRateTwoAdapter adapter = new HeartRateTwoAdapter(mContext, list1);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list1.clear();
                initList(list1);
                mIvTopTwo.setBackgroundResource(ivTwoId[position]);
                switch (position) {
                    case 0:
                        list1.get(position).mImageId = R.drawable.i_but_manual_l;
                        break;
                    case 1:
                        list1.get(position).mImageId = R.drawable.i_but_pyramid_l;
                        break;
                    case 2:
                        list1.get(position).mImageId = R.drawable.i_but_hillclimb_l;
                        break;
                    case 3:
                        list1.get(position).mImageId = R.drawable.i_but_interval_l;
                        break;
                    case 4:
                        list1.get(position).mImageId = R.drawable.i_but_random_l;
                        break;
                    case 5:
                        list1.get(position).mImageId = R.drawable.i_but_constant_l;
                        break;
                    case 6:
                        list1.get(position).mImageId = R.drawable.i_but_heart_l;
                        break;
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initList(List<CustomerWorkoutEntity> list1) {
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_manual_n, "Manual"));
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_pyramid_n, "Pyramid"));
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_hillclimb_n, "Hill Climb"));
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_interval_n, "Interval"));
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_random_n, "Random"));
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_constant_n, "Constant WATTS"));
        list1.add(new CustomerWorkoutEntity(R.drawable.i_but_heart_n, "Heart Rate"));
    }

    @Override
    protected void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_heart_rate;
    }

    class HeartRateTwoAdapter extends BaseAdapter<CustomerWorkoutEntity> {

        public HeartRateTwoAdapter(Context context, List<CustomerWorkoutEntity> list) {
            super(context, list);
        }

        @Override
        protected int getLayoutId() {
            return R.layout.heart_rate_two;
        }

        @Override
        protected void onViewCreated(ViewHolder holder, int position) {
            TextView tvContent = holder.get(R.id.tvContent);
            tvContent.setText(getItem(position).mText);
            ImageView imageView = holder.get(R.id.imageView);
            imageView.setBackgroundResource(getItem(position).mImageId);
        }

    }

    class MyPagerAdapter extends PagerAdapter {
        private List<View> mList;

        public MyPagerAdapter(Context context, List<View> list) {
            mContext = context;
            mList = list;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view.equals(o);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = mList.get(position);
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
            container.addView(view);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager viewPager = (ViewPager) container;
            viewPager.removeViewAt(position);
        }
    }
}

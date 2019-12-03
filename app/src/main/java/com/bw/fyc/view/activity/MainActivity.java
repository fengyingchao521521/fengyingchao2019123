package com.bw.fyc.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.bw.fyc.R;
import com.bw.fyc.base.BaseActivity;
import com.bw.fyc.util.NetUtil;
import com.bw.fyc.view.fragment.HomerFragment;
import com.bw.fyc.view.fragment.MyFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ArrayList<Fragment> list = new ArrayList<>();
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RelativeLayout relativeLayout;

    @Override
    protected void initData() {

        //添加
        list.add(new HomerFragment());
        list.add(new MyFragment());

        //适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //判断有误网络
        if (NetUtil.getInstance().hasNet(this)){
            viewPager.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
        }else {
            viewPager.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initView() {

        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
        //隐藏
        relativeLayout = findViewById(R.id.rl);

        //联动
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.butt01:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.butt02:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    public void toMyModel() {
        viewPager.setCurrentItem(0);
    }

}

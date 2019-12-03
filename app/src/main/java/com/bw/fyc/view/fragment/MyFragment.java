package com.bw.fyc.view.fragment;


import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bw.fyc.R;
import com.bw.fyc.base.BaseFragment;
import com.bw.fyc.contract.IContract;
import com.bw.fyc.model.bean.ShopBean;
import com.bw.fyc.presenter.MyPresenter;
import com.bw.fyc.view.activity.MainActivity;
import com.bw.fyc.view.adapter.MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements IContract.IView {


    private Button butt;
    private GridView gridView;
    private MyPresenter myPresenter;

    @Override
    protected void initView(View inflate) {

        gridView = inflate.findViewById(R.id.gr);
        butt = inflate.findViewById(R.id.but);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.toMyModel();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {
        myPresenter = new MyPresenter();
        myPresenter.getShopData(this);

    }


    @Override
    public void OnMyFuilure(ShopBean shopBean) {
        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
        gridView.setAdapter(new MyAdapter(shopBean.getShopGridData()));
    }

    @Override
    public void OnMysuccess(Throwable throwable) {
        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
    }
}

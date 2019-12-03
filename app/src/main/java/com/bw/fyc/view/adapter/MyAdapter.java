package com.bw.fyc.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.fyc.R;
import com.bw.fyc.model.bean.ShopBean;
import com.bw.fyc.util.NetUtil;

import java.util.List;

/*
 *@auther: 封英超
 *@Date: 2019/12/3
 *@Time:10:15
 *@Description:${DESCRIPTION}
 *
 */public class MyAdapter extends BaseAdapter {

    List<ShopBean.ShopGridDataBean> list;

    public MyAdapter(List<ShopBean.ShopGridDataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodle viewHodle=null;
        if (convertView==null){
            convertView=View.inflate(parent.getContext(), R.layout.item,null);
            viewHodle = new ViewHodle();
            viewHodle.tv_image=convertView.findViewById(R.id.tv_image);
            viewHodle.tv_textview=convertView.findViewById(R.id.tv_textview);
            convertView.setTag(viewHodle);
        }else {
            viewHodle = (ViewHodle) convertView.getTag();
        }
        //绑定
        ShopBean.ShopGridDataBean shopGridDataBean = list.get(position);
        viewHodle.tv_textview.setText(shopGridDataBean.getPrice());
        NetUtil.getInstance().getPhoto(shopGridDataBean.getImageurl(),viewHodle.tv_image);
        return convertView;
    }
    class  ViewHodle{
        ImageView tv_image;
        TextView  tv_textview;
    }
}

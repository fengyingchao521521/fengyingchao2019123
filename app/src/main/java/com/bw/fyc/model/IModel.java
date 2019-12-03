package com.bw.fyc.model;

import com.bw.fyc.contract.IContract;
import com.bw.fyc.model.bean.ShopBean;
import com.bw.fyc.util.NetUtil;
import com.google.gson.Gson;

/*
 *@auther: 封英超
 *@Date: 2019/12/3
 *@Time:9:57
 *@Description:${DESCRIPTION}
 *
 */public class IModel {
    public void getShopData(final IContract.IConent iConent){
        NetUtil.getInstance().getjson("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCallBack() {
            @Override
            public void onGetjson(String json) {
                ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
                iConent.OnMyFuilure(shopBean);
            }
            @Override
            public void Error(Throwable throwable) {
                iConent.OnMysuccess(throwable);
            }
        });
    }
}

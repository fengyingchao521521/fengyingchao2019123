package com.bw.fyc.presenter;

import com.bw.fyc.contract.IContract;
import com.bw.fyc.model.IModel;
import com.bw.fyc.model.bean.ShopBean;

/*
 *@auther: 封英超
 *@Date: 2019/12/3
 *@Time:9:56
 *@Description:${DESCRIPTION}
 *
 */public class MyPresenter {

    private IModel iModel;

    public void getShopData(final IContract.IView iView){
        iModel = new IModel();

        iModel.getShopData(new IContract.IConent() {
            @Override
            public void OnMyFuilure(ShopBean shopBean) {
                iView.OnMyFuilure(shopBean);
            }

            @Override
            public void OnMysuccess(Throwable throwable) {
                iView.OnMysuccess(throwable);
            }
        });

    }
}

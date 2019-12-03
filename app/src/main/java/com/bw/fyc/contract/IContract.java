package com.bw.fyc.contract;

import com.bw.fyc.model.bean.ShopBean;

/*
 *@auther: 封英超
 *@Date: 2019/12/3
 *@Time:10:08
 *@Description:${DESCRIPTION}
 *
 */public interface IContract {

    interface IView {
        void OnMyFuilure(ShopBean shopBean);

        void OnMysuccess(Throwable throwable);
    }

    interface IConent {
        void OnMyFuilure(ShopBean shopBean);

        void OnMysuccess(Throwable throwable);
    }

}

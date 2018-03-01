package com.sumail.shadow.login.presenter;

import com.sumail.shadow.login.model.LoginBean;
import com.sumail.shadow.login.view.ILoginAct;
import com.sumail.shadow.net.HttpUtils;
import com.sumail.shadow.net.helper.RetrofitHelper;
import com.sumail.shadow.net.service.IService;

import rx.Observable;

/**
 * Created by shadow on  2018/1/2.
 */

public class LoginPersenterImpl implements ILoginPersenter {
    private ILoginAct iLoginAct;


    public LoginPersenterImpl(ILoginAct iLoginAct){
        this.iLoginAct = iLoginAct;
    }

    @Override
    public void getUserInfo(String username, String password) {
        Observable<LoginBean> observable = RetrofitHelper.getInstance().getService(IService.class).getLogin(username, password);
        HttpUtils.requestNetByPost(observable, new HttpUtils.OnResultListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iLoginAct.getUserInfoData(loginBean);
            }

            @Override
            public void onError(Throwable error, String msg) {
                    iLoginAct.loginErr();
            }
        });
    }
}

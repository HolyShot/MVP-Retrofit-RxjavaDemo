package com.sumail.shadow.login.view;


import com.sumail.shadow.login.model.LoginBean;

/**
 * Created by Administrator on 2018/1/2.
 */

public interface ILoginAct {

        void getUserInfoData(LoginBean loginBean);
        void loginErr();
}

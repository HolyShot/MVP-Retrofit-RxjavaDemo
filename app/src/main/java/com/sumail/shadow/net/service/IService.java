package com.sumail.shadow.net.service;


import com.sumail.shadow.login.model.LoginBean;
import com.sumail.shadow.net.Urls;


import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface IService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @POST(Urls.UrlOrigin.get_LOGIN)
    Observable<LoginBean> getLogin(@Query("userid") String username, @Query("password") String password);


}

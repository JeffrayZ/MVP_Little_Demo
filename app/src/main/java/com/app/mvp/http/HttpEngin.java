package com.app.mvp.http;

import com.app.mvp.bean.UserInfo;
import com.app.mvp.login.LoginModel;
import com.app.mvp.login.LoginPresenter;

public class HttpEngin<P extends LoginPresenter> {
    // 需要一个Presenter将结果发出去
    private P p;

    public HttpEngin(P p) {
        this.p = p;
    }

    public void post(String name, String pwd) {
        if ("zhan".equalsIgnoreCase(name) && "123".equalsIgnoreCase(pwd)) {
            p.getContract().handleResult(new UserInfo("詹老师", 18));
        } else {
            p.getContract().handleResult(null);
        }
    }
}

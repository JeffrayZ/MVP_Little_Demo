package com.app.mvp.login;

import com.app.mvp.base.BasePresenter;
import com.app.mvp.bean.UserInfo;
import com.app.mvp.http.HttpEngin;

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity, LoginContract.Presenter> {

    public LoginPresenter() {
        super();
    }

    @Override
    public LoginContract.Presenter getContract() {
        return new LoginContract.Presenter<UserInfo>(){

            @Override
            public void requestLogin(String username, String password) {
                // 方式一、只做转发,具体逻辑在LoginModel里面
//                try {
//                    m.getContact().executeLogin(username, password);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                // 方式二、不做转发，自己处理
//                if("zhan".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){
//                    handleResult(new UserInfo("詹老师",18));
//                } else {
//                    handleResult(null);
//                }

                // 方式三、通过工具类处理
                HttpEngin engin = new HttpEngin(LoginPresenter.this);
                engin.post(username, password);
            }

            @Override
            public void handleResult(UserInfo userInfo) {
                getView().getContract().handleResult(userInfo);
            }
        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}

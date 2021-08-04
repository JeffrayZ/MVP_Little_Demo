package com.app.mvp.login;

import com.app.mvp.base.BaseModel;
import com.app.mvp.bean.UserInfo;

public class LoginModel extends BaseModel<LoginPresenter,LoginContract.Model> {
    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String username, String password) throws Exception {
                if("zhan".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){
                    p.getContract().handleResult(new UserInfo("詹老师",18));
                } else {
                    p.getContract().handleResult(null);
                }
            }
        };
    }
}

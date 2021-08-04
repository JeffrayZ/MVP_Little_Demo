package com.app.mvp.login;
import com.app.mvp.bean.BaseEntity;
public interface LoginContract {
    interface Model {
        // 登录具体操作
        void executeLogin(String username, String password) throws Exception;
    }

    interface View<T extends BaseEntity> {
        // 处理登录结果
        void handleResult(T t);
    }

    // 作为中转，主要是做转发作用
    interface Presenter<T extends BaseEntity> {
        // 发起请求
        void requestLogin(String username, String password);
        // 结果处理
        void handleResult(T t);
    }
}

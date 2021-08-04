package com.app.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseView<P extends BasePresenter,CONTRACT> extends Activity {
    // 通过P层去发起请求
    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getPresenter();
        p.bindView(this);
    }

    // 从子类中获取具体的Contract
    public abstract CONTRACT getContract();

    // 从子类中获取具体的Presenter
    public abstract P getPresenter();

    public void onError(Exception e){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.unBindView();
    }
}

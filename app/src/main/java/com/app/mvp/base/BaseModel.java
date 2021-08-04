package com.app.mvp.base;

// 接收到P层的事件
public abstract class BaseModel<P extends BasePresenter,CONTRACT> {
    // model层处理完请求后，需要P层去处理结果，所以我们需要一个P对象
    protected P p;

    public BaseModel(P p) {
        this.p = p;
    }

    // Contract 有很多，请求完成后，需要找到指定的 Contract,并做处理
    public abstract CONTRACT getContract();
}

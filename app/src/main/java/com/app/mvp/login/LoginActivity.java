package com.app.mvp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.mvp.R;
import com.app.mvp.base.BaseView;
import com.app.mvp.bean.BaseEntity;
import com.app.mvp.bean.UserInfo;

import java.util.function.LongFunction;

public class LoginActivity extends BaseView<LoginPresenter,LoginContract.View> {

    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.editTextTextPersonName);
        etPwd = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String pwd = etPwd.getText().toString();
                p.getContract().requestLogin(name, pwd);
            }
        });
    }

    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>(){

            @Override
            public void handleResult(UserInfo userInfo) {
                if(userInfo != null){
                    Toast.makeText(LoginActivity.this,userInfo.toString(),Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this,"登录失败！",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }
}
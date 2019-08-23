package com.example.qa.lianxiti5.presenter;

import com.example.qa.lianxiti5.Main3Activity;
import com.example.qa.lianxiti5.modle.LoginModle;
import com.example.qa.lianxiti5.view.LoginView;

/**
 * Created by QA on 2019/8/22.
 */

public class LoginPresenter implements LoginModle.LoginCallback{
    private LoginView loginView;
    private  LoginModle loginModle=new LoginModle();
    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public  void  login(){
        loginModle.Logindata(loginView.getName(),loginView.getpwd(),this);
    }
    @Override
    public void onSucess(String s) {
      loginView.toActivity(Main3Activity.class,s);
    }

    @Override
    public void OnFail(String s) {
       loginView.toShow("登录失败");
    }


}

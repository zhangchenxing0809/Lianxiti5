package com.example.qa.lianxiti5.modle;

import com.example.qa.lianxiti5.Apiservice;
import com.example.qa.lianxiti5.LoginBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by QA on 2019/8/22.
 */

public class LoginModle {
    public void Logindata(final String name, String pwd, final LoginCallback loginCallback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.loginurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Call<LoginBean> call = apiservice.getLogin(name, pwd);
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

                String ret = response.body().getRet();

                  loginCallback.onSucess(ret);

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                 loginCallback.OnFail(t.getMessage());
            }
        });
    }
    public interface LoginCallback{
        void onSucess(String s);
        void OnFail(String s);
    }
}

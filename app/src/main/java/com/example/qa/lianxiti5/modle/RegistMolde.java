package com.example.qa.lianxiti5.modle;

import com.example.qa.lianxiti5.Apiservice;
import com.example.qa.lianxiti5.RegitsBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by QA on 2019/8/22.
 */

public class RegistMolde {
public  void  registinit(String name, String pwd, String phone, String code, final RegistCallBack registCallBack){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Apiservice.regitsurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Apiservice apiservice = retrofit.create(Apiservice.class);
    final Call<RegitsBean> reginst = apiservice.getReginst(name, pwd, phone, code);
    reginst.enqueue(new Callback<RegitsBean>() {
        @Override
        public void onResponse(Call<RegitsBean> call, Response<RegitsBean> response) {
            String ret = response.body().getRet();
            registCallBack.Sucess(ret);
        }

        @Override
        public void onFailure(Call<RegitsBean> call, Throwable t) {
              registCallBack.onFail(t.getMessage());
        }
    });
}
    public interface  RegistCallBack{
        void Sucess(String s);
        void onFail(String s);
    }

}

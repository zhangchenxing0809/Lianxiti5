package com.example.qa.lianxiti5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by QA on 2019/8/22.
 */

public interface Apiservice {
    String regitsurl="http://yun918.cn/";
   @POST("study/public/index.php/register")
    @FormUrlEncoded
        //像这种post请求 表示form表单，传入参数的接口，表示是form表单，需要此注解
   Call<RegitsBean> getReginst(@Field("username") String uname, @Field("password") String passw,@Field("phone") String phone,@Field("code") String code);
    String loginurl="http://yun918.cn/";
    @POST("study/public/index.php/login")
    @FormUrlEncoded
        //像这种post请求 表示form表单，传入参数的接口，表示是form表单，需要此注解
    Call<LoginBean> getLogin(@Field("username") String uname, @Field("password") String passw);

}

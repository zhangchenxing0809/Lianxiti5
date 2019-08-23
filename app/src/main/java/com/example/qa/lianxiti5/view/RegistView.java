package com.example.qa.lianxiti5.view;

/**
 * Created by QA on 2019/8/22.
 */

public interface RegistView {
    String username() ;
    String password ();
    String phone();
    String code();
    void  toShow(String s);
    void toActivity(Class myclass, Object obj);

}

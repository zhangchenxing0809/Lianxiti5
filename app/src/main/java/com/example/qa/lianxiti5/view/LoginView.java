package com.example.qa.lianxiti5.view;

import android.support.v7.widget.RecyclerView;

/**
 * Created by QA on 2019/8/22.
 */

public interface LoginView {
    String getName();
    String getpwd();
    void toShow(String s);
    void toActivity(Class myclass, Object obj);

}

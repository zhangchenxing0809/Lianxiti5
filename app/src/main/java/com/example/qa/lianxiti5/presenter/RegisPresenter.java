package com.example.qa.lianxiti5.presenter;

import com.example.qa.lianxiti5.MainActivity;
import com.example.qa.lianxiti5.modle.RegistMolde;
import com.example.qa.lianxiti5.view.RegistView;

/**
 * Created by QA on 2019/8/22.
 */

public class RegisPresenter implements RegistMolde.RegistCallBack{
    private RegistView registView;
   private  RegistMolde registMolde=new RegistMolde();
    public RegisPresenter(RegistView registView) {
        this.registView = registView;
    }

    @Override
    public void Sucess(String s) {
        registView.toActivity(MainActivity.class,s);
    }

    @Override
    public void onFail(String s) {
      registView.toShow(s);
    }

    public void regits() {
        registMolde.registinit(registView.username(),registView.password(),registView.phone(),registView.code(),this);
    }
}

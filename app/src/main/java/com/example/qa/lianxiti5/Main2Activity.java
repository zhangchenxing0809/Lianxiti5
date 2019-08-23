package com.example.qa.lianxiti5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qa.lianxiti5.presenter.RegisPresenter;
import com.example.qa.lianxiti5.view.RegistView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener,RegistView {

    /**
     * 请输入账号
     */
    private EditText mEtname;
    /**
     * 请输密码
     */
    private EditText mEtpwd;
    /**
     * 确认密码
     */
    private EditText mEtpwds;
    /**
     * 手机号
     */
    private EditText mEtphone;
    /**
     * 验证码
     */
    private EditText mEtcode;
    /**
     * 注册
     */
    private Button mBtzhuce;
    private RegisPresenter regisPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        regisPresenter = new RegisPresenter(this);
        initView();
    }

    private void initView() {
        mEtname = (EditText) findViewById(R.id.etname);
        mEtpwd = (EditText) findViewById(R.id.etpwd);
        mEtpwds = (EditText) findViewById(R.id.etpwds);
        mEtphone = (EditText) findViewById(R.id.etphone);
        mEtcode = (EditText) findViewById(R.id.etcode);
        mBtzhuce = (Button) findViewById(R.id.btzhuce);
        mBtzhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btzhuce:
            regisPresenter.regits();
                break;
        }
    }

    @Override
    public String username() {
        return mEtname.getText().toString();
    }

    @Override
    public String password() {
        return mEtpwd.getText().toString();
    }

    @Override
    public String phone() {
        return mEtphone.getText().toString();
    }

    @Override
    public String code() {
        return mEtcode.getText().toString();
    }

    @Override
    public void toShow(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toActivity(Class myclass, Object obj) {
            if(obj!=null){
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        Intent intent = new Intent(Main2Activity.this, myclass);
            intent.putExtra("name",mEtname.getText().toString());
            intent.putExtra("pwd",mEtpwd.getText().toString());
            setResult(2,intent);
            finish();
    }
}

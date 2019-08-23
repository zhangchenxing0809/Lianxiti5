package com.example.qa.lianxiti5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.qa.lianxiti5.presenter.LoginPresenter;
import com.example.qa.lianxiti5.presenter.RegisPresenter;
import com.example.qa.lianxiti5.view.LoginView;
import com.example.qa.lianxiti5.view.RegistView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    /**
     * 请输入账号
     */
    private EditText mEtname;
    /**
     * 请输密码
     */
    private EditText mEtpwd;
    /**
     * 登录
     */
    private Button mBtdenglu;
    /**
     * 注册
     */
    private Button mBtzhuce;
    private LoginPresenter loginPresenter;
    private String name;
    private String pwd;
    private String name1;
    private String pwd1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);

        initView();
        name = mEtname.getText().toString();
        pwd = mEtpwd.getText().toString();


    }

    private void initView() {
        mEtname = (EditText) findViewById(R.id.etname);
        mEtpwd = (EditText) findViewById(R.id.etpwd);
        mBtdenglu = (Button) findViewById(R.id.btdenglu);
        mBtdenglu.setOnClickListener(this);
        mBtzhuce = (Button) findViewById(R.id.btzhuce);
        mBtzhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btdenglu:
                loginPresenter.login();

                break;
            case R.id.btzhuce:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public String getName() {
        return name1;
    }

    @Override
    public String getpwd() {
        return pwd1;
    }

    @Override
    public void toShow(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toActivity(Class myclass, Object obj) {
         if(obj!=null){
             Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
         }
        Intent intent = new Intent(MainActivity.this, myclass);
       startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            name1 = data.getStringExtra("name");
            pwd1 = data.getStringExtra("pwd");
        }
    }
}

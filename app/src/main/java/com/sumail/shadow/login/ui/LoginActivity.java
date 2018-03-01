package com.sumail.shadow.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sumail.shadow.MainActivity;
import com.sumail.shadow.R;
import com.sumail.shadow.login.model.LoginBean;
import com.sumail.shadow.login.presenter.LoginPersenterImpl;
import com.sumail.shadow.login.view.ILoginAct;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by shadow on 2018/1/2.
 */

public class LoginActivity extends Activity implements ILoginAct,View.OnClickListener {
    @InjectView(R.id.login_spinner)
    protected Spinner login_spinner;
    @InjectView(R.id.login_username)
    protected EditText login_username;
    @InjectView(R.id.login_password)
    protected EditText login_password;
    @InjectView(R.id.login_cancel)
    protected Button login_cancel;
    @InjectView(R.id.login_confirm)
    protected Button login_confirm;
    @InjectView(R.id.login_progress)
    protected LinearLayout login_progress;
    private int type = 0;

    private LoginPersenterImpl loginPersenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme();
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        login_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("Spinner", "没有进行选择");
            }
        });
        login_confirm.setOnClickListener(this);
        login_cancel.setOnClickListener(this);
    }


    @Override
    public void getUserInfoData(LoginBean loginBean) {
        int code = loginBean.getCode();
        Log.d("1111","" + new Gson().toJson(loginBean));
        if (code == 0)  {
            login_progress.setVisibility(View.GONE);
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            login_progress.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loginErr() {
        login_progress.setVisibility(View.GONE);
        Toast.makeText(LoginActivity.this, "网络异常！", Toast.LENGTH_SHORT).show();
    }

    private void setTheme(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        login_progress.setVisibility(View.VISIBLE);
        ButterKnife.reset(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_cancel: // 取消按钮
                finish();
                break;
            case R.id.login_confirm: // 确定按钮
                String userName = login_username.getText().toString();
                String passWord = login_password.getText().toString();
                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(this,"用户名不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(passWord)){
                    Toast.makeText(this,"密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                login_progress.setVisibility(View.VISIBLE);
                loginPersenter = new LoginPersenterImpl(this);
                loginPersenter.getUserInfo(userName,passWord);
                break;
        }
    }
}

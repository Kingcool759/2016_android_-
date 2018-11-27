package com.kingcool.yiqiyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn1 = findViewById(R.id.btn_submit);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从登录界面activity跳转到主界面mainActivity
                Toast.makeText(LoginActivity.this,"登录成功，正跳转至主界面",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.btn_register);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从登录界面activity跳转到新用户注册界面RegisterActivity
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}

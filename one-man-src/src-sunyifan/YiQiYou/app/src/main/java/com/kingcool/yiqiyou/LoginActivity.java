package com.kingcool.yiqiyou;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.VolumeShaper;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kingcool.yiqiyou.Entity.User;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_password;
    private EditText et_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        et_result = (EditText) findViewById(R.id.et_result);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnGotoRegister = (Button) findViewById(R.id.btn_goto_register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String path="http://10.7.89.253:8080/yiqiyouTest/LoginServlet";
                //验证用户输入用户名和密码
                if (name == null || name.length() <= 5) {
                    et_name.requestFocus();
                    et_name.setError("对不起，用户名不能小于6位!");
                } else if (password == null || password.length() <= 5) {
                    et_password.requestFocus();
                    et_password.setError("对不起，密码不能小于6位!");
                } else {
                    //调用registerTask,把获取到的用户名，密码与路径放入方法中
                    new loginTask().execute(name,password,path);
                }
            }
        });
        //从登录界面activity跳转到新用户注册界面RegisterActivity(此处无需改动)
        btnGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    //异步任务
    public class loginTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            String name = objects[0].toString();
            String password = objects[1].toString();
            String path = objects[2].toString();
            try {
                URL url = new URL(path+"?uname="+name+"&upassword="+password);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                int code = connection.getResponseCode();
                if(code==200){
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String s = br.readLine();
                    return s;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            String s = (String)o;
                if(s.equals("登录成功！")){
                Toast.makeText(LoginActivity.this,s , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        }
    }

    //--------------
}

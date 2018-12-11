package com.kingcool.yiqiyou;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_Username;
    private EditText et_Userpwd;
    private EditText et_Userphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //为注册按钮添加点击监听事件
        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入数据
                et_Username = findViewById(R.id.et_username);
                et_Userpwd = findViewById(R.id.et_userpwd);
                et_Userphone = findViewById(R.id.et_userphone);
                String name = et_Username.getText().toString();
                String password = et_Userpwd.getText().toString();
                String phone = et_Userphone.getText().toString();
                String path="http://10.7.89.253:8080/yiqiyouTest/RegisterServlet";
                //调用registerTask,把获取到的用户名，密码与路径放入方法中
                new registerTask().execute(name,password,phone,path);


                //注册成功后跳转至用户登录界面
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //异步任务
    public class registerTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            String name = objects[0].toString();
            String password = objects[1].toString();
            String phone = objects[2].toString();
            String path = objects[3].toString();
            try {
                URL url = new URL(path+"?uname="+name+"&upassword="+password+"&phone="+phone);
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
            Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    //--------------
}

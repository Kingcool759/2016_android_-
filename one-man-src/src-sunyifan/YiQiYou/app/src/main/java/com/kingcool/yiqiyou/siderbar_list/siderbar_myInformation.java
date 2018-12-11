package com.kingcool.yiqiyou.siderbar_list;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kingcool.yiqiyou.MainActivity;
import com.kingcool.yiqiyou.PickerView;
import com.kingcool.yiqiyou.R;
import com.kingcool.yiqiyou.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class siderbar_myInformation extends AppCompatActivity {

    //----------------
    private Dialog upSex;
    private String selectSex;
    //----------------
    private EditText etNickName;
    private TextView etSex;
    private EditText etAge;
    private EditText etSchool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siderbar_my_information);
        etNickName = findViewById(R.id.my_et_name);
        etSex = findViewById(R.id.my_tv_sex);
        etAge = findViewById(R.id.my_et_age);
        etSchool = findViewById(R.id.my_et_school);
        //获得数据库
        new MyTask().execute();

        LinearLayout ll2 = findViewById(R.id.my_ll_sex);
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSex();
            }
        });
        LinearLayout linearLayout = findViewById(R.id.myinfo_back);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_NickName = etNickName.getText().toString();
                String et_Sex = etSex.getText().toString();
                String et_Age = etAge.getText().toString();
                String et_School = etSchool.getText().toString();
                String path="http://10.7.89.253:8080/yiqiyouTest/MyInformationServlet";
                //保存至数据库
                new MyInformationTask().execute(et_NickName,et_Sex,et_Age,et_School,path);
                Intent intent = new Intent(siderbar_myInformation.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    //获得数据库我的信息的异步任务
    public class MyTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                String path="http://10.7.89.253:8080/yiqiyouTest/GetMyInformationServlet";
                Log.e("MyTask","123");
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                int code = connection.getResponseCode();
                if(code==200){
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String s = br.readLine();
                    Log.e("json",s);
                    JSONObject jo = new JSONObject(s);
                    etNickName.setText(jo.getString("user_nickname"));
                    etSex.setText(jo.getString("user_sex"));
                    etAge.setText(jo.getString("user_age"));
                    etSchool.setText(jo.getString("user_school"));
                    Log.e("jname",jo.getString("user_nickname"));
                    Log.e("jage",jo.getString("user_age"));
                    return s;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    //返回MainActivity时将修改信息保存至数据库的异步任务
    public class MyInformationTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            String name = objects[0].toString();
            String sex = objects[1].toString();
            String age = objects[2].toString();
            String school = objects[3].toString();
            String path = objects[4].toString();
            try {
                URL url = new URL(path+"?unickname="+name+"&usex="+sex+"&uage="+age+"&uschool="+school);
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
    }


    //选择性别
    private void selectSex() {
        upSex = new Dialog(siderbar_myInformation.this, R.style.dialog);
        View defaultView = LayoutInflater.from(this).inflate(
                R.layout.picker_dialog, null);
        PickerView picker = (PickerView) defaultView.findViewById(R.id.pickerView);
        Button finish = (Button) defaultView
                .findViewById(R.id.finish);
        Button cancel = (Button) defaultView
                .findViewById(R.id.cancel);
        List<String> data = new ArrayList<String>();
        data.add("男");
        data.add("女");
        picker.setData(data);

        picker.setOnSelectListener(new PickerView.onSelectListener() {

            @Override
            public void onSelect(String text) {
               selectSex = text;
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upSex.dismiss();
                TextView textView = findViewById(R.id.my_tv_sex);
                    textView.setText(selectSex);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upSex.dismiss();
            }
        });

        upSex.setContentView(defaultView);

        upSex.setCancelable(true);
        upSex.setCanceledOnTouchOutside(true);
        upSex.show();
        WindowManager windowManager = siderbar_myInformation.this.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = upSex.getWindow().getAttributes();
        lp.width = (int) (display.getWidth());
        upSex.getWindow().setAttributes(lp);
        upSex.getWindow().setGravity(Gravity.BOTTOM);
    }




}

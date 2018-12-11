package com.kingcool.yiqiyou.siderbar_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kingcool.yiqiyou.MainActivity;
import com.kingcool.yiqiyou.R;

public class siderbar_set extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siderbar_set);
        LinearLayout linearLayout = findViewById(R.id.set_back);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(siderbar_set.this, MainActivity.class);
                startActivity(intent);
            }
        });
        TextView tv_1 = findViewById(R.id.tv_1);
        TextView tv_2 = findViewById(R.id.tv_2);
        TextView tv_help = findViewById(R.id.tv_help);
        TextView tv_yiqiyou = findViewById(R.id.tv_yiqiyou);
        tv_1.setOnClickListener(onClickListener);
        tv_2.setOnClickListener(onClickListener);
        tv_help.setOnClickListener(onClickListener);
        tv_yiqiyou.setOnClickListener(onClickListener);
    }


    //onClickListener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_1:
                    break;
                case R.id.tv_2:
                    break;
                case R.id.tv_help:
                    break;
                case R.id.tv_yiqiyou:
                    break;
            }
        }
    };
}

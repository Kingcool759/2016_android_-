package com.kingcool.yiqiyou.siderbar_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.kingcool.yiqiyou.MainActivity;
import com.kingcool.yiqiyou.R;

public class siderbar_myComment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siderbar_my_comment);
        LinearLayout linearLayout = findViewById(R.id.mycomment_back);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(siderbar_myComment.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

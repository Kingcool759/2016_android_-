package com.kingcool.yiqiyou.siderbar_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.kingcool.yiqiyou.MainActivity;
import com.kingcool.yiqiyou.R;

public class siderbar_myOrder extends AppCompatActivity {
    //ListView
    private ListView listView;
    private String[] names={"ID1","ID2","ID3","ID4","ID5","ID6","ID7","ID8","ID9","ID10","ID11","ID12"};
    private  int[] icons={R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test,
            R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test};
    private String[] times={"购买时间","购买时间","购买时间","购买时间","购买时间","购买时间",
            "购买时间","购买时间","购买时间","购买时间","购买时间","购买时间"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siderbar_my_order);
        LinearLayout linearLayout = findViewById(R.id.myorder_back);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(siderbar_myOrder.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.btn_order_unpaid);
        Button button2 = findViewById(R.id.btn_order_paid);
        Button button3 = findViewById(R.id.btn_order_all);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

        //ListView
        listView = findViewById(R.id.lv_myorder);
        listView.setAdapter(new MyBaseAdapter());
    }
    //自定义适配器
    class MyBaseAdapter extends BaseAdapter {

        public int getCount(){
            return  names.length;
        }

        public  Object getItem(int mposition){
            return  names [mposition];
        }

        public long getItemId(int mposition) {
            return mposition;
        }

        //重写getView方法
        @Override
        public View getView(int position,View converView,ViewGroup parent){
//            View view=View.inflate(view.getContext(),R.layout.friends_list_item,null);
            View view=getLayoutInflater().inflate(R.layout.myorder_list_item,null);
            TextView mTextView=(TextView)view.findViewById(R.id.Text1);
            ImageView imageView=(ImageView)view.findViewById(R.id.image1);
            TextView nTextView=(TextView)view.findViewById(R.id.Text2);
            mTextView.setText(names[position]);
            nTextView.setText(times[position]);
            imageView.setBackgroundResource(icons[position]);
            return view;
        }
    }


    //onClickListener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_order_unpaid:
                    Log.e("MyOrder","unpaid");
                    break;
                case R.id.btn_order_paid:
                    Log.e("MyOrder","paid");
                    break;
                case R.id.btn_order_all:
                    Log.e("MyOrder","all");
                    break;
            }
        }
    };
}

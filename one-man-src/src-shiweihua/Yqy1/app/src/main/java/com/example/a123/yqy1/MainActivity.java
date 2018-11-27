package com.example.a123.yqy1;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] names={"ID","ID","ID","ID","ID","ID"};
    private String[] times={"上次在线时间","上次在线时间","上次在线时间","上次在线时间","上次在线时间","上次在线时间"};
    private  int[] icons={R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.lv);
        listView.setAdapter(new MyBaseAdapter());
    }

    class MyBaseAdapter extends BaseAdapter{

        public int getCount(){
            return  names.length;
        }

        public  Object getItem(int mposition){
            return  names [mposition];
        }

        public long getItemId(int mposition) {
            return mposition;
        }


        @Override
        public View getView(int position,View converView,ViewGroup parent){
            View view=View.inflate(MainActivity.this,R.layout.list_item,null);
            TextView mTextView=(TextView)view.findViewById(R.id.Text1);
            TextView nTextView=(TextView)view.findViewById(R.id.Text2);
            ImageView imageView=(ImageView)view.findViewById(R.id.image1);
            mTextView.setText(names[position]);
            nTextView.setText(times[position]);
            imageView.setBackgroundResource(icons[position]);
            return view;
        }
    }
}

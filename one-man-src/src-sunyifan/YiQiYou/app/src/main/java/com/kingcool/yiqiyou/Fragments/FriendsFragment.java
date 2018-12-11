package com.kingcool.yiqiyou.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kingcool.yiqiyou.R;

public class FriendsFragment extends Fragment {
    private ListView listView;
    private String[] names={"ID1","ID2","ID3","ID4","ID5","ID6","ID7","ID8","ID9","ID10","ID11","ID12"};
    private String[] times={"上次在线时间","上次在线时间","上次在线时间","上次在线时间","上次在线时间","上次在线时间"
            ,"上次在线时间","上次在线时间","上次在线时间","上次在线时间","上次在线时间","上次在线时间"};
    private  int[] icons={R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a
            ,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_fragment_layout, container, false);
        listView=(ListView)view.findViewById(R.id.lv_friends_fragment);
        listView.setAdapter(new MyBaseAdapter());
        return view;
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
            View view=getActivity().getLayoutInflater().inflate(R.layout.friends_list_item,null);
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

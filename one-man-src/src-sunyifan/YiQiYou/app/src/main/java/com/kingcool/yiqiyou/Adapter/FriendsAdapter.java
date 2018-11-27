package com.kingcool.yiqiyou.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingcool.yiqiyou.Entity.Friends;
import com.kingcool.yiqiyou.R;

import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friends>{
    private int resourceId;
    public FriendsAdapter(Context context, int textViewResourceId, List<Friends>objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View  getView(int position, View convertView, ViewGroup parent){
        //获取当前项的Friends实例
        Friends friends = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView friendsImage = (ImageView)view.findViewById(R.id.friends_image);
        TextView friendsName = (TextView)view.findViewById(R.id.friends_name);
        friendsImage.setImageResource(friends.getImageId());
        friendsName.setText(friends.getName());
        return view;
    }
}

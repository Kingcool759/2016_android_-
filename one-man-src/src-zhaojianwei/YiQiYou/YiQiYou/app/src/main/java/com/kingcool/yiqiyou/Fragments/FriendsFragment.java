package com.kingcool.yiqiyou.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.kingcool.yiqiyou.Adapter.FriendsAdapter;
import com.kingcool.yiqiyou.Entity.Friends;
import com.kingcool.yiqiyou.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {
    private List<Friends> friendsList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_fragment_layout,
                container,
                false);
        private List<Friends> friendsList = new ArrayList<>();
        return view;
    }
    //好友列表
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FriendsAdapter adapter = new FriendsAdapter(getContext(),R.layout.friends_list_item,friendsList);

    }
}

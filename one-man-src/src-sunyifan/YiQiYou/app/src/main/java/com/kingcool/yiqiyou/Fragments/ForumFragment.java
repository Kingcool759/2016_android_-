package com.kingcool.yiqiyou.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.kingcool.yiqiyou.R;

public class ForumFragment extends Fragment {
    private String[] str = {"aa", "bb", "cc"};
    private SearchView searchView;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_fragment_layout, container, false);
        //搜索栏 模糊匹配 输入名称
        searchView = (SearchView)view.findViewById(R.id.search_item);
        listView = (ListView)view.findViewById(R.id.list_item);
        listView.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, str));
        listView.setTextFilterEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listView.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    listView.setFilterText(newText);
                } else {
                    listView.clearTextFilter();
                }
                return false;
            }
        });
        return view;
    }
}

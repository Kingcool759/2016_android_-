package com.kingcool.yiqiyou;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.kingcool.yiqiyou.Fragments.ForumFragment;
import com.kingcool.yiqiyou.Fragments.FriendsFragment;
import com.kingcool.yiqiyou.Fragments.ShopFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private Map<String, View> tabspecViews = new HashMap<>();
    private Map<String, ImageView> imageViewMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取FragmentTabHost对象
        FragmentTabHost fragmentTabHost = findViewById(android.R.id.tabhost);
        //初始化FragmentTabHost对象
        fragmentTabHost.setup(this,
                getSupportFragmentManager(),
                android.R.id.tabhost);

        //创建选项卡对象并添加选项卡
        TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec("tab1")
                .setIndicator(getTabSpecView("好友",R.drawable.friends, "tab1"));
        fragmentTabHost.addTab(tabSpec1, FriendsFragment.class, null);

        //创建选项卡对象并添加选项卡
        TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec("tab2")
                .setIndicator(getTabSpecView("商城",R.drawable.shop, "tab2"));
        fragmentTabHost.addTab(tabSpec2, ShopFragment.class, null);
        //创建选项卡对象并添加选项卡
        TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec("tab3")
                .setIndicator(getTabSpecView("论坛",R.drawable.forum,"tab3"));
        fragmentTabHost.addTab(tabSpec3, ForumFragment.class, null);

        //设置默认选中某个选项卡
        fragmentTabHost.setCurrentTab(1);
        //设置第二个选项卡背景颜色
        tabspecViews.get("tab2").setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        ImageView imageView1 = imageViewMap.get("tab2");
        imageView1.setImageResource(R.drawable.shop_selected);

        //监听选项卡点击事件
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.e("点击了选项卡",tabId);
                Set<String> keys = tabspecViews.keySet();
                for (String str : keys){
                    View view = tabspecViews.get(str);
                    ImageView imageView = imageViewMap.get("tab1");
                    ImageView imageView1 = imageViewMap.get("tab2");
                    ImageView imageView2 = imageViewMap.get("tab3");
                    //改变选项卡的背景颜色
                    if (str.equals(tabId)){
                        view.setBackgroundColor(getResources().
                                getColor(android.R.color.darker_gray));
                    }else {
                        view.setBackgroundColor(getResources().
                                getColor(android.R.color.white));
                    }
                    //改变选项卡中的图片
                    if (tabId.equals("tab1")){
                        imageView.setImageResource(R.drawable.friends_selected);
                        imageView1.setImageResource(R.drawable.shop);
                        imageView2.setImageResource(R.drawable.forum);
                    }else if(tabId.equals("tab2")){
                        imageView.setImageResource(R.drawable.friends);
                        imageView1.setImageResource(R.drawable.shop_selected);
                        imageView2.setImageResource(R.drawable.forum);
                    }else if(tabId.equals("tab3")){
                        imageView.setImageResource(R.drawable.friends);
                        imageView1.setImageResource(R.drawable.shop);
                        imageView2.setImageResource(R.drawable.forum_selected);
                    }
                }
            }
        });
    }

    private View getTabSpecView(String name, int imageId, String tag){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.tabspc_layout,null);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(imageId);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(name);
        tabspecViews.put(tag, view);
        imageViewMap.put(tag, imageView);
        return view;
    }
}

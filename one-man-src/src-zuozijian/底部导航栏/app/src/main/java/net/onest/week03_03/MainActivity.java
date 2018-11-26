package net.onest.week03_03;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import net.onest.week03_03.fragment.FirstFragment;
import net.onest.week03_03.fragment.SecondFragment;
import net.onest.week03_03.fragment.ThirdFragment;

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

        //创建选项卡对象
        TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec("tab1")
//                .setIndicator("首页");
                  .setIndicator(getTabSpecView("好友",R.drawable.friend1, "tab1"));

        //添加选项卡
        fragmentTabHost.addTab(tabSpec1, FirstFragment.class, null);

        //创建选项卡对象
        TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec("tab2")
//                .setIndicator("好友");
                .setIndicator(getTabSpecView("商店",R.drawable.store1, "tab2"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec2, SecondFragment.class, null);
        //创建选项卡对象
        TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec("tab3")
//                .setIndicator("消息");
                .setIndicator(getTabSpecView("动态",R.drawable.forum1,"tab3"));

        //添加选项卡
        fragmentTabHost.addTab(tabSpec3, ThirdFragment.class, null);

        //设置默认选中某个选项卡
        fragmentTabHost.setCurrentTab(1);
        //设置第二个选项卡背景颜色
        tabspecViews.get("tab2").setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        ImageView imageView1 = imageViewMap.get("tab2");
        imageView1.setImageResource(R.drawable.store2);

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
                        imageView.setImageResource(R.drawable.friend2);
                        imageView1.setImageResource(R.drawable.store1);
                        imageView2.setImageResource(R.drawable.forum1);
                    }else if(tabId.equals("tab2")){
                        imageView.setImageResource(R.drawable.friend1);
                        imageView1.setImageResource(R.drawable.store2);
                        imageView2.setImageResource(R.drawable.forum1);
                    }else if(tabId.equals("tab3")){
                        imageView.setImageResource(R.drawable.friend1);
                        imageView1.setImageResource(R.drawable.store1);
                        imageView2.setImageResource(R.drawable.forum2);
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

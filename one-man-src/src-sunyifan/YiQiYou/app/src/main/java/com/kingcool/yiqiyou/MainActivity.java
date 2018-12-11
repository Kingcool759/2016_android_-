package com.kingcool.yiqiyou;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.kingcool.yiqiyou.Fragments.ForumFragment;
import com.kingcool.yiqiyou.Fragments.FriendsFragment;
import com.kingcool.yiqiyou.Fragments.ShopFragment;
import com.kingcool.yiqiyou.siderbar_list.siderbar_myActivities;
import com.kingcool.yiqiyou.siderbar_list.siderbar_myComment;
import com.kingcool.yiqiyou.siderbar_list.siderbar_myInformation;
import com.kingcool.yiqiyou.siderbar_list.siderbar_myOrder;
import com.kingcool.yiqiyou.siderbar_list.siderbar_myRepertory;
import com.kingcool.yiqiyou.siderbar_list.siderbar_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.support.design.widget.NavigationView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Map<String, View> tabspecViews = new HashMap<>();
    private Map<String, ImageView> imageViewMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //软键盘顶起底部导航栏解决方法：
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        setContentView(R.layout.activity_main);



        //----侧边栏siderbar-------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //--------------------------------



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


    //----------侧边栏-----------------------------------
    //返回键触发调用的方法
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    //----@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my) {

            Intent intent = new Intent(MainActivity.this,siderbar_myInformation.class);
            startActivity(intent);
        } else if (id == R.id.nav_repertory) {
            Intent intent = new Intent(MainActivity.this,siderbar_myRepertory.class);
            startActivity(intent);
        } else if (id == R.id.nav_order) {
            Intent intent = new Intent(MainActivity.this,siderbar_myOrder.class);
            startActivity(intent);
        } else if (id == R.id.nav_comment) {
            Intent intent = new Intent(MainActivity.this,siderbar_myComment.class);
            startActivity(intent);
        } else if (id == R.id.nav_activities) {
            Intent intent = new Intent(MainActivity.this,siderbar_myActivities.class);
            startActivity(intent);
        } else if (id == R.id.nav_set) {
            Intent intent = new Intent(MainActivity.this,siderbar_set.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

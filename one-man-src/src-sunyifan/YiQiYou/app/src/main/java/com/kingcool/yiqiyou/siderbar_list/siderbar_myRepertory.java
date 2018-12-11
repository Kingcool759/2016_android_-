package com.kingcool.yiqiyou.siderbar_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.kingcool.yiqiyou.MainActivity;
import com.kingcool.yiqiyou.R;

public class siderbar_myRepertory extends AppCompatActivity {
    //ListView
    private ListView listView;
    private String[] names={"ID1","ID2","ID3","ID4","ID5","ID6","ID7","ID8","ID9","ID10","ID11","ID12"};
    private  int[] icons={R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test,
            R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test, R.drawable.test};

    //切换图片用
    boolean isChanged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siderbar_my_repertory);
        LinearLayout linearLayout = findViewById(R.id.myrepertory_back);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(siderbar_myRepertory.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //popupmenu
        final ImageView iv_select = findViewById(R.id.iv_select);
        iv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),iv_select);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();
//                //点击popupmenu时切换图片
//                if(v == iv_select)
//                {
//                    if(isChanged){
//                        iv_select.setImageDrawable(getResources().getDrawable(R.drawable.myr_down));
//                    }else
//                    {
//                        iv_select.setImageDrawable(getResources().getDrawable(R.drawable.myr_downonclick));
//                    }
//                    isChanged = !isChanged;
//
//                }
            }
        });
//        //有错
//        //重置popupmenu图片
//        LinearLayout ll_repertory = findViewById(R.id.ll_myrepertory);
//        ll_repertory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iv_select.setImageDrawable(getResources().getDrawable(R.drawable.myr_down));
//                isChanged = !isChanged;
//            }
//        });


        //ListView
        listView = findViewById(R.id.lv_game);
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
            View view=getLayoutInflater().inflate(R.layout.myrepertory_list_item,null);
            TextView mTextView=(TextView)view.findViewById(R.id.Text1);
            ImageView imageView=(ImageView)view.findViewById(R.id.image1);
            mTextView.setText(names[position]);
            imageView.setBackgroundResource(icons[position]);
            return view;
        }
    }
}

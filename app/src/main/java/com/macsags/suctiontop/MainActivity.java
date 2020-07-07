package com.macsags.suctiontop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 柳湘翎 （Macsags）
 * @date : 2020/6/28 16:26
 * @mail : 670765255@qq.com
 * @description ：吸顶效果
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final List<DataBean> mList = getList();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this, mList);

        SuctionTop decoration = new SuctionTop(this) {
            @Override
            protected boolean isShowItemLabel(int position) {
                return mList.get(position).isShowLable();
            }

            @Override
            protected String getItemLabelStr(int position) {
                return mList.get(position).getSpell();
            }

            @Override
            protected int getItemLabelImg(int position) {
                return mList.get(position).getImgLable();
            }
        };

        //设置标签颜色
//        decoration.setLabelColor(Color.DKGRAY);
        //设置标签高度
//        decoration.setLabelHeight(30);
        //设置标签字体颜色
//        decoration.setTextColor(Color.RED);
        //设置标签字体大小
//        decoration.setTextSize(50);
//        decoration.setLabelGravity(LABEL_GRAVITY_RIGHT);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);

    }

    private List<DataBean> getList() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("1", true, "张三李四", R.drawable.ic_launcher));
        list.add(new DataBean("2", false, "张三李四", R.drawable.ic_launcher));
        list.add(new DataBean("3", false, "张三李四", R.drawable.ic_launcher));
        list.add(new DataBean("4", true, "C", R.drawable.ic_launcher_round));
        list.add(new DataBean("5", false, "C", R.drawable.ic_launcher));
        list.add(new DataBean("6", false, "C", R.drawable.ic_launcher));
        list.add(new DataBean("7", false, "C", R.drawable.ic_launcher));
        list.add(new DataBean("8", false, "C", R.drawable.ic_launcher));
        list.add(new DataBean("9", false, "C", R.drawable.ic_launcher));
        list.add(new DataBean("10", false, "C", R.drawable.ic_launcher));
        list.add(new DataBean("11", true, "J", R.drawable.ic_launcher));
        list.add(new DataBean("12", false, "J", R.drawable.ic_launcher));
        list.add(new DataBean("13", false, "J", R.drawable.ic_launcher));
        list.add(new DataBean("14", false, "J", R.drawable.ic_launcher));
        list.add(new DataBean("15", false, "J", R.drawable.ic_launcher));
        list.add(new DataBean("16", true, "K", R.drawable.ic_launcher_round));
        list.add(new DataBean("17", false, "K", R.drawable.ic_launcher));
        list.add(new DataBean("18", false, "K", R.drawable.ic_launcher));
        list.add(new DataBean("19", true, "Y", R.drawable.ic_launcher));
        list.add(new DataBean("20", false, "Y", R.drawable.ic_launcher));
        list.add(new DataBean("21", false, "Y", R.drawable.ic_launcher));
        list.add(new DataBean("22", false, "Y", R.drawable.ic_launcher));
        list.add(new DataBean("23", false, "Y", R.drawable.ic_launcher));
        list.add(new DataBean("24", true, "Z", R.drawable.ic_launcher));
        list.add(new DataBean("25", false, "Z", R.drawable.ic_launcher));
        list.add(new DataBean("26", false, "Z", R.drawable.ic_launcher));
        list.add(new DataBean("27", false, "Z", R.drawable.ic_launcher));
        return list;

    }

}

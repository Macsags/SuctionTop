package com.macsags.suctiontop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author : 柳湘翎 （Macsags）
 * @date : 2020/6/28 16:26
 * @mail : 670765255@qq.com
 * @description ：吸顶效果
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    private List<DataBean> mList;

    public Adapter(Context context, List<DataBean> list) {
        this.mList = list;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(com.macsags.suctiontop.R.layout.item_rv, parent, false);

        return new MyHolder(item);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        MyHolder viewHolder = (MyHolder) holder;
        viewHolder.mTextView.setText(mList.get(position).getData());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_item);
        }
    }
}

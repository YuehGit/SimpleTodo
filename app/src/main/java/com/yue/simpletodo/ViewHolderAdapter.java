package com.yue.simpletodo;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ViewHolderAdapter extends BaseAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // using convertView in parent class - mandatory using convertView
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = onCreateViewHolder(position, parent);
            viewHolder.view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // create view holder
        // ViewHolder viewHolder = onCreateViewHolder(position, convertView, parent);
        // bind view
        onBindViewHolder(position, viewHolder);
        return viewHolder.view;
    }

    public static abstract class ViewHolder {
        View view;
        public ViewHolder(View view) {
            this.view = view;
        }
    }

    protected abstract ViewHolder onCreateViewHolder(int position, ViewGroup parent);
    protected abstract ViewHolder onBindViewHolder(int position, ViewHolder viewHolder);

}

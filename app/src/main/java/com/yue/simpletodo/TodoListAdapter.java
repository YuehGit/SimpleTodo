package com.yue.simpletodo;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yue.simpletodo.models.Todo;

import java.util.List;

public class TodoListAdapter extends BaseAdapter {

    private Context context;
    private List<Todo> data;

    public TodoListAdapter(Context context, List<Todo> todos) {
        this.context = context;
        this.data = todos;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView: Recycle view
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.d("new view", "new view for position " + position);
            // check how many views was created
            convertView = LayoutInflater.from(context).inflate(R.layout.todo_list_item, parent, false);

            viewHolder = new ViewHolder();
            // only find once
            viewHolder.todoText = (TextView) convertView.findViewById(R.id.todo_list_item_text);
            // cache the view holder
        } else {
            // convertView is not null, which means it contains a cached view holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Todo todo = data.get(position);

        Log.d("listview", "position " + position);
        // check which view was got by listview

        viewHolder.todoText.setText(todo.text);
        return convertView;
    }

    // static class for high efficiency
    private static class ViewHolder {
        TextView todoText;
    }
}

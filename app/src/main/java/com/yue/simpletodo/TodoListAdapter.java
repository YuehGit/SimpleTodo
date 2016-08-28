package com.yue.simpletodo;


import android.content.Context;
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
        Todo todo = data.get(position);

        View view = LayoutInflater.from(context).inflate(R.layout.todo_list_item, null);
        ((TextView) view.findViewById(R.id.todo_list_item_text)).setText(todo.text);
        return view;
    }
}

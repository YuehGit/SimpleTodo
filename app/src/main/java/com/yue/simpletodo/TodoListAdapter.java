package com.yue.simpletodo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yue.simpletodo.models.Todo;

import java.util.List;

public class TodoListAdapter extends ViewHolderAdapter {

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
    protected ViewHolderAdapter.ViewHolder onCreateViewHolder(int position, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_list_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    protected ViewHolderAdapter.ViewHolder onBindViewHolder(int position, ViewHolderAdapter.ViewHolder viewHolder) {
        Todo todo = data.get(position);
        ((TodoViewHolder) viewHolder).todoText.setText(todo.text);
        return null;
    }

    // static class for high efficiency
    private static class TodoViewHolder extends ViewHolderAdapter.ViewHolder {
        TextView todoText;

        public TodoViewHolder(View view) {
            super(view);
            todoText = (TextView) view.findViewById(R.id.todo_list_item_text);
        }
    }
}

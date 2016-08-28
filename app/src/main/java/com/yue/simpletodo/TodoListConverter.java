package com.yue.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yue.simpletodo.models.Todo;

import java.util.List;

public class TodoListConverter {

    private Context context;
    private List<Todo> data;

    public TodoListConverter(Context context, List<Todo> data) {
        this.context = context;
        this.data = data;
    }

    public View getView(int position) {
        Todo todo = data.get(position);

        View view = LayoutInflater.from(context).inflate(R.layout.todo_list_item, null);
        ((TextView) view.findViewById(R.id.todo_list_item_text)).setText(todo.text);
        return view;
    }
}

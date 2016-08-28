package com.yue.simpletodo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.yue.simpletodo.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI(mockData());
    }

    private void setupUI(@NonNull List<Todo> todos) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.list_container);
        linearLayout.removeAllViews();

        TodoListConverter converter = new TodoListConverter(this, todos);

        for (int i = 0; i < todos.size(); ++i) {
            View view = converter.getView(i);
            linearLayout.addView(view);
        }
    }



    @NonNull
    private List<Todo> mockData() {
        List<Todo> list = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            list.add(new Todo("todo " + i));
        }
        return list;
    }
}

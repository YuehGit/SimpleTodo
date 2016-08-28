package com.yue.simpletodo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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
        ListView listView = (ListView) findViewById(R.id.list_view);
        TodoListAdapter adapter = new TodoListAdapter(this, todos);
        listView.setAdapter(adapter);
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

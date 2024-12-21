package com.example.listviewapp;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        ListView listView = findViewById(R.id.listView);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                list.add(text);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = list.get(position);
            Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            list.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}
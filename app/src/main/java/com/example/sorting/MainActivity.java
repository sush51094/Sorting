package com.example.sorting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
public class MainActivity extends AppCompatActivity {
    EditText name;
    ArrayAdapter arrayAdapter;
    ArrayList<String> array_list;
    Set set = new HashSet();
    private ListView listView;
    @Override
    protected void onCreate(Bundle readdInstanceState) {
        super.onCreate(readdInstanceState);
        setContentView(R.layout.activity_main);
        array_list = new ArrayList<String>();
        name = findViewById(R.id.name);
        listView = findViewById(R.id.listView);
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()) {
                    set.add(name.getText().toString());
                    array_list.clear();
                    array_list.addAll(set);
                    Collections.sort(array_list);
                    arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array_list);
                    listView.setAdapter(arrayAdapter);
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                } else {
                    name.setError("Enter NAME");
                }
            }
        });
    }
}

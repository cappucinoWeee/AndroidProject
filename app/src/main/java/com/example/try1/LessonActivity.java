package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_listview);

        ListView listView = findViewById(R.id.listView);
        ImageView home = findViewById(R.id.home);

        List<String> data = new ArrayList<>();
        data.add("int: Represents integer numbers (e.g., 1, 100, -10).");
        data.add("float: Represents floating-point numbers (e.g., 3.14, -0.001, 2.0).");
        data.add("bool: Represents boolean values True or False.");
        data.add("list: Ordered and mutable collection of items (e.g., [1, 2, 3]).");
        data.add("tuple: Ordered and immutable collection of items (e.g., (1, 2, 3)).");
        data.add("range: Represents a sequence of numbers (e.g., range(5) represents [0, 1, 2, 3, 4]).");
        data.add(("set: Unordered collection of unique items (e.g., {1, 2, 3})."));
        data.add("bytes: Immutable sequence of bytes (e.g., b'hello').");

        LessonListViewAdapter adapter = new LessonListViewAdapter(this, data);
        listView.setAdapter(adapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonActivity.this, LessonFourOpen.class);
                startActivity(intent);
            }
        });
    }
}

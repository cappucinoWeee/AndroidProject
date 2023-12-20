package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroPythonActivity extends AppCompatActivity {
    ImageView imageView1,imageView2,imageView3,imageView4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intropython);


        imageView1 = findViewById(R.id.imageView8);
        imageView2 = findViewById(R.id.imageView16);
        imageView3 = findViewById(R.id.imageView14);
        imageView4 = findViewById(R.id.imageView15);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPythonActivity.this, PythonClass1Activity.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPythonActivity.this, PythonPractice2.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPythonActivity.this, Practice_open.class);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPythonActivity.this, LessonFourOpen.class);
                startActivity(intent);
            }
        });


    }
}

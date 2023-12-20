package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LessonFourOpen extends AppCompatActivity {
    Button openPractice,openQuiz,lecture;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_open);
        openPractice = findViewById(R.id.practice_button);
        openQuiz = findViewById(R.id.quiz_button);
        lecture = findViewById(R.id.lecture);

        lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonFourOpen.this, PythonPractice3.class);
                startActivity(intent);
            }
        });

        openPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonFourOpen.this, LessonActivity.class);
                startActivity(intent);
            }
        });
        openQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonFourOpen.this, Quiz.class);
                startActivity(intent);
            }
        });

    }
}

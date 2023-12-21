package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PythonPractice2_1 extends AppCompatActivity {

    private ImageView nextButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python_practical2_1);


        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveNextLesson();
            }
        });
    }

        public void MoveNextLesson(){
            Intent nextLesson = new Intent(this, Practice_3.class);
            startActivity(nextLesson);
        }

    }


package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PythonPractice2 extends AppCompatActivity {

    private ImageView nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python_practical2);

      nextButton = (ImageView)findViewById(R.id.nextButton);

       nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPythonPractice1();
            }
        });
    }
    public void openPythonPractice1(){
        Intent goToPythonPractice1 = new Intent(this, PythonPractice1.class);
    }
}
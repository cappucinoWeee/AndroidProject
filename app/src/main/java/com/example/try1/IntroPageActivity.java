package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IntroPageActivity extends AppCompatActivity {
    Button introButton;
    Button pythonButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intropage);

        introButton = findViewById(R.id.intro_button);
        pythonButton = findViewById(R.id.python_button);

        introButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPageActivity.this, PythonPage.class);
                startActivity(intent);
            }
        });

        pythonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroPageActivity.this, IntroPythonActivity.class);
                startActivity(intent);
            }
        });
    }
}

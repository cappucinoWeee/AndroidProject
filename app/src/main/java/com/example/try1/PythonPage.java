package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PythonPage extends AppCompatActivity {

    private Button understood_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python_class);

        understood_button = (Button)findViewById(R.id.understoodButton);


        understood_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPythonCourse();
            }
        });
    }
        public void openPythonCourse() {
            Intent goToPythonCourse1Page = new Intent(this, PythonCourse1.class);
            startActivity(goToPythonCourse1Page);
        }
}



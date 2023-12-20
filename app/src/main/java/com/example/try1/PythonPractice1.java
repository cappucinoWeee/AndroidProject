package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PythonPractice1 extends AppCompatActivity {


    private EditText codeInput;
    private TextView outputText;
    private Button check_button;
    private TextView textView;
    private ImageView nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python_practical1);

        codeInput = findViewById(R.id.codeInput);
        outputText = findViewById(R.id.outputText);
        textView = findViewById(R.id.textView);
        nextButton = findViewById(R.id.next_button);

        check_button = (Button) findViewById(R.id.checkButton);

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInput();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveNextLesson();
            }
        });


    }

        public void checkInput() {
            String userCode = codeInput.getText().toString();

            // Check if the code contains "print("Hello World")"

            if (userCode.contains("print(\"Hello\")")) {
                outputText.setText("Hello");
                outputText.setTextSize(24);
                textView.setText("Жарайсың! Келесі сабаққа өтейік!");
                textView.setTextColor(getResources().getColor(R.color.green));
                textView.setTextSize(23);


            } else {
                outputText.setText("Ууупс! Қайта тырысып көр....");
                outputText.setTextSize(11);
                outputText.setTextColor(getResources().getColor(R.color.red));

            }
        }

        public void MoveNextLesson(){
            Intent nextLesson = new Intent(this, PythonPractice2.class);
            startActivity(nextLesson);

        }

    }

package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PythonClass1Activity extends AppCompatActivity {


    private Button helpKitten_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python_class1);

        helpKitten_button = (Button)findViewById(R.id.HelpKittenButton);

helpKitten_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      openPythonPractice1();
    }
});
    }
    public void openPythonPractice1(){
        Intent goToPythonPractice1 = new Intent(this, PythonPractice1.class);
        startActivity(goToPythonPractice1);
    }
}

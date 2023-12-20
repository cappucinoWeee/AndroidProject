package com.example.try1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomePageActivity extends AppCompatActivity {
    private Button login_button;
    private Button register_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button = (Button)findViewById(R.id.loginButton);
        register_button = (Button)findViewById(R.id.registerButton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrationPage();
            }
        });

    }

    public void openLoginPage(){
        Intent goToLoginPage = new Intent(this, LoginPageActivity.class);
                startActivity(goToLoginPage);
    }

    public void openRegistrationPage(){
        Intent goToRegistrationPage=  new Intent(this, RegistrationPageActivity.class);
        startActivity(goToRegistrationPage);
    }
}
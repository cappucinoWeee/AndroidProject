package com.example.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginPageActivity extends AppCompatActivity {
    EditText loginUsername,loginPassword;
    Button loginButton;
    TextView registerRedirectText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        registerRedirectText = findViewById(R.id.registerRedirectText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUserName() | !validatePassword() ){

                } else {
                    checkUser();
                }
            }
        });

        registerRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPageActivity.this, RegistrationPageActivity.class);
                startActivity(intent);
            }
        });

    }
    public Boolean validateUserName(){
        String val = loginUsername.getText().toString();
        if(val.isEmpty()){
            loginUsername.setError("Пайдаланушы аты бос болмауы керек");
            return false;
        }else{
            loginUsername.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if(val.isEmpty()){
            loginPassword.setError("Құпия сөз аты бос болмауы керек");
            return false;
        }else{
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String userUserName = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUserName);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUserName).child("password").getValue(String.class);

                    if(!Objects.equals(passwordFromDB,userPassword)){
                        loginUsername.setError(null);
                        Intent intent = new Intent(LoginPageActivity.this,WelcomePageActivity.class);
                        startActivity(intent);
                    }else{
                        loginPassword.setError("құпия сөз сәйкес келмейді");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("Пайдаланушы жоқ");
                    loginUsername.requestFocus();
                }

//                ////////////////
//                Intent moveToWelcomePage = new Intent(WelcomePageActivity.this);
//                startActivity(moveToWelcomePage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

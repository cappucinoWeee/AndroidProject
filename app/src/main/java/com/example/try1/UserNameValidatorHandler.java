package com.example.try1;

import com.example.try1.Handler;
import com.example.try1.UserData;

public class UserNameValidatorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(UserData userData) {
        if (userData.getUsername().isEmpty()) {
            userData.setError("Пайдаланушы аты бос болмауы керек");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(userData);
        }
    }
}






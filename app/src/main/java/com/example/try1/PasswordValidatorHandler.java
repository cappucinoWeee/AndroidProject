package com.example.try1;


public class PasswordValidatorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }
    @Override
    public void handleRequest(UserData userData) {
        if (userData.getPassword().isEmpty()) {
            userData.setError("Құпия сөз аты бос болмауы керек");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(userData);
        }
    }
}
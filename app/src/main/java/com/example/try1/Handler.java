package com.example.try1;

public interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(UserData userData);
}


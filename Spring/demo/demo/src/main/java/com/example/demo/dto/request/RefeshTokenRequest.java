package com.example.demo.dto.request;

public class RefeshTokenRequest {
    private String refreshToken;

    public RefeshTokenRequest() {
    }

    public RefeshTokenRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}

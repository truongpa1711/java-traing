package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefeshTokenResponse {
    private String accessToken;
    private String refreshToken;

    public RefeshTokenResponse() {
    }

    public RefeshTokenResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}

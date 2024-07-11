package dev.nastiar.portal.auth;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private Long expiresIn;

    public String getToken() {
        return token;
    }
}

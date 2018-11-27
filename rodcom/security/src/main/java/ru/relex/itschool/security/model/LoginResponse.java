package ru.relex.itschool.security.model;

/**
 * @author : sasha
 */
public class LoginResponse {

    private final int id;

    private final String accessToken;

    private final String refreshToken;

    public LoginResponse(int id, String accessToken, String refreshToken) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public int getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}

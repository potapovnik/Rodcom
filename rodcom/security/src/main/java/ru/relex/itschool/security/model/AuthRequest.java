package ru.relex.itschool.security.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

/**
 * @author : sasha
 */
public class AuthRequest {

    private String username;
    private char[] password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    @JsonSerialize(using = StdArraySerializers.CharArraySerializer.class)
    public void setPassword(char[] password) {
        this.password = password;
    }

}

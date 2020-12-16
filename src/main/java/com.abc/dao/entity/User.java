package com.abc.dao.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private int pri;

    public User(String username, String password, int pri) {
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

package com.example.huseyin2023deneme;

public class User_1 {
    private int ID;
    private String username;
    private String password;

    public User_1(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }
    public User_1() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

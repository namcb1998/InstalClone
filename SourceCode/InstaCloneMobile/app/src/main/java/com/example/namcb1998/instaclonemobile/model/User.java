package com.example.namcb1998.instaclonemobile.model;

public class User {
    public static final int ADMIN = 0;
    public static final int USER = 1;
    private String username;
    private int id;
    private String password;
    private String email;
    private String display_name;
    private String link_avatar;
    private long birthday;
    private int gender;
    private long time;
    private int role;

    public User(String username, int id, String password, String email, String display_name, String link_avatar, long birthday, int gender, long time) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.email = email;
        this.display_name = display_name;
        this.link_avatar = link_avatar;
        this.birthday = birthday;
        this.gender = gender;
        this.time = time;
    }

    public User() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLink_avatar() {
        return link_avatar;
    }

    public void setLink_avatar(String link_avatar) {
        this.link_avatar = link_avatar;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

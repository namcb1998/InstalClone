package com.example.namcb1998.instaclonemobile.model;

public class Follow {
    private int id;
    private int idUser;
    private int idUserFollow;  //idUser follow idUserfollow

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserFollow() {
        return idUserFollow;
    }

    public void setIdUserFollow(int idUserFollow) {
        this.idUserFollow = idUserFollow;
    }
}

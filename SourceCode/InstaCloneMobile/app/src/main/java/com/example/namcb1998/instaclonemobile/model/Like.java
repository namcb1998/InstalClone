package com.example.namcb1998.instaclonemobile.model;

public class Like {
    private int id;
    private int idUserOwner;
    private int idPost;
    private String create_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUserOwner() {
        return idUserOwner;
    }

    public void setIdUserOwner(int idUserOwner) {
        this.idUserOwner = idUserOwner;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
}

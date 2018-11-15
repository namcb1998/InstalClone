package com.example.namcb1998.instaclonemobile.model;

public class Comment {
    private int id;
    private int idUserOwner;
    private int idPost;
    private String message;
    private String create_at;


    public Comment(int idUserOwner, int idPost, String message, String create_at) {
        this.idUserOwner = idUserOwner;
        this.idPost = idPost;
        this.message = message;
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comment() {
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

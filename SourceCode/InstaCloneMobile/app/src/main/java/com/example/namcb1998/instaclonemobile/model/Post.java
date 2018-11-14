package com.example.namcb1998.instaclonemobile.model;

public class Post {
    public static final int PRIVACY_PRIVATE = 0;
    public static final int PRIVACY_PUBLIC = 1;
    public static final int PRIVACY_FOLLOW = 2;

    private int id;
    private int id_user;
    private String image_link;
    private String title;
    private int privacy;
    private String created_at;

    public Post(int id, int id_user, String image_link, String title, int privacy, String created_at) {
        this.id = id;
        this.id_user = id_user;
        this.image_link = image_link;
        this.title = title;
        this.privacy = privacy;
        this.created_at = created_at;
    }

    public Post() {
    }

    public static int getPrivacyPrivate() {
        return PRIVACY_PRIVATE;
    }

    public static int getPrivacyPublic() {
        return PRIVACY_PUBLIC;
    }

    public static int getPrivacyFollow() {
        return PRIVACY_FOLLOW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

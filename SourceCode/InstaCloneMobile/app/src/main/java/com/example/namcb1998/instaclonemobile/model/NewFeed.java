package com.example.namcb1998.instaclonemobile.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by User_Pro on 10/20/2018.
 */

public class NewFeed implements Externalizable {
    private String userName;
    private String imageNewFeed;
    private String userAvatar;

    public NewFeed(String userName, String imageNewFeed, String userAvatar) {
        this.userName = userName;
        this.imageNewFeed = imageNewFeed;
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageNewFeed() {
        return imageNewFeed;
    }

    public void setImageNewFeed(String imageNewFeed) {
        this.imageNewFeed = imageNewFeed;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {

    }
}

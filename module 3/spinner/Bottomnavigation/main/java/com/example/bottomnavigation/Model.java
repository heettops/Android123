package com.example.bottomnavigation;

public class Model
{
    String topicname;

    int image;

    public Model(String topicname, int image)
    {
        this.topicname = topicname;
        this.image = image;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

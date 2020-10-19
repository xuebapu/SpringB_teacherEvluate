package com.cqgc.pojo;

public class Question {
    private int Id;
    private String title;
    private String type;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

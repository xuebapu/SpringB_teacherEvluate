package com.cqgc.pojo;

public class User {
    private int Id;
    private String phone;
    private String perms;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", phone='" + phone + '\'' +
                ", perms='" + perms + '\'' +
                '}';
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

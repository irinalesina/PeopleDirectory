package com.irina.data.entity;


import java.sql.Date;

public class UserAccount {
    private int id;
    private String name;
    private String password;
    private Date modifyData;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public Date getModifyData(){
        return modifyData;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setModifyData(Date modifyData){
        this.modifyData = modifyData;
    }

}

package src.com.irina.data.entity;


import java.util.Date;

public class UserAccount {
    private int id;
    private String name;
    private String password;
    private Date modifyDate;

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
        return modifyDate;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setModifyData(Date modifyData){
        this.modifyDate = modifyData;
    }

}

package com.irina.main;


import com.irina.data.entity.User;

// creted to test dao
public class Main {
    public static void main(String[] args){
        User user = new User();

        user.setId(5);
        System.out.println(user.getId());
    }
}

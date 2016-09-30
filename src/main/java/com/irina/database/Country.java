package com.irina.database;


public class Country {
    public int id;
    public String name;

    public Country(){

    }

    public Country(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(" - ");
        sb.append(name);
        return sb.toString();
    }
}

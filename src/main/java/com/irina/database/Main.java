package com.irina.database;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args){
        DBConnector dbConnector = new DBConnector();

        String queryGetCountries = "SELECT * FROM countries";

        try {
            Statement statement = dbConnector.GetConnection().createStatement();
            ResultSet countriesSet = statement.executeQuery(queryGetCountries);
            ArrayList<Country> countries = new ArrayList<Country>();
            while(countriesSet.next()){
                countries.add(new Country(countriesSet.getInt(1), countriesSet.getString(2)));
            }

            for (Country country : countries) {
                System.out.println(country.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

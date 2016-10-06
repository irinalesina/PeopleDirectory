package src.com.irina.data.dao;
import src.com.irina.data.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IDao<User> {

    @Override
    public void create(User entity) throws DaoException {
        try{
            Connection connection = PeopleDbController.getConection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user(first_name, last_name, phone, birthday, sex, address, email) values(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setDate(4, (java.sql.Date)entity.getBirthday());
            preparedStatement.setString(5, entity.getSex());
            preparedStatement.setString(6, entity.getAddress());
            preparedStatement.setString(7, entity.getEmail());

            preparedStatement.executeUpdate();

            if(!connection.isClosed()){
                connection.close();
            }
        }
        catch (Exception ex){

        }
    }

    @Override
    public User read(String pattern) throws DaoException {
        return null;
    }

    @Override
    public void update(User entity) throws DaoException {

    }

    @Override
    public void delete(User entity) throws DaoException {

    }

    @Override
    public List<User> getAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try{
            Connection connection = PeopleDbController.getConection();

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM users");
            while (result.next()) {
                User user = new User();

                user.setId(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setPhone(result.getString("phone"));
                user.setBirthday(result.getDate("birthday"));
                user.setSex(result.getString("sex"));
                user.setAddress(result.getString("address"));
                user.setEmail(result.getString("email"));

                users.add(user);
            }
        }
        catch (Exception ex){

        }
        return users;
    }
}

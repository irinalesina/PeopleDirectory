package com.irina.data.dao;

import com.irina.data.entity.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserController extends AbstractController<User, Integer> {
    private static final String SELECT_ALL_USER = "SELECT * FROM user;";
    private static final String UPDATE_USER = "UPDATE user SET first_name = ?, last_name = ?, phone = ?, birthday = ?, sex = ?, address = ?, email = ? WHERE id = ?";
    private static final String GET_USER_BY_ID = "SELECT DISTINCT * FROM user WHERE id = ?;";
    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
    private static final String CREATE_USER = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)";


    @Override
    public List<User> getAll() {
        List<User> list = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_USER);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPhone(rs.getString("phone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setSex(rs.getString("sex"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    @Override
    public boolean update(User entity) {
        PreparedStatement ps = getPrepareStatement(UPDATE_USER);
        boolean updateResult = false;
        try {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getPhone());
            ps.setDate(4, (Date) entity.getBirthday());
            ps.setString(5, entity.getSex());
            ps.setString(6, entity.getAddress());
            ps.setString(7, entity.getEmail());

            updateResult = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return updateResult;
    }

    @Override
    public User getEntityById(Integer id) {
        User user = new User();
        PreparedStatement ps = getPrepareStatement(GET_USER_BY_ID);
        try {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setPhone(rs.getString("phone"));
            user.setBirthday(rs.getDate("birthday"));
            user.setSex(rs.getString("sex"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement ps = getPrepareStatement(DELETE_USER);
        boolean deleteResult = false;
        try {
            ps.setInt(1, id);

            deleteResult = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return deleteResult;
    }

    @Override
    public boolean create(User entity) {
        PreparedStatement ps = getPrepareStatement(CREATE_USER);
        boolean createResult = false;
        try {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getPhone());
            ps.setDate(4, (Date) entity.getBirthday());
            ps.setString(5, entity.getSex());
            ps.setString(6, entity.getAddress());
            ps.setString(7, entity.getEmail());

            createResult = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return createResult;
    }
}

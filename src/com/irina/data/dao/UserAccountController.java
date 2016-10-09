package src.com.irina.data.dao;

import src.com.irina.data.entity.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserAccountController extends AbstractController<UserAccount, Integer> {
    public static final String SELECT_ALL_USER_ACCOUNT = "SELECT * FROM user_account";


    @Override
    public List<UserAccount> getAll() {
        List<UserAccount> list = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_USER_ACCOUNT);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserAccount userAccount = new UserAccount();
                userAccount.setId(rs.getInt("id"));
                userAccount.setName(rs.getString("name"));
                userAccount.setPassword(rs.getString("password"));
                userAccount.setModifyData(rs.getDate("modify_date"));
                list.add(userAccount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return list;
    }

    @Override
    public UserAccount update(UserAccount entity) {
        throw new NotImplementedException();
    }

    @Override
    public UserAccount getEntityById(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean create(UserAccount entity) {
        throw new NotImplementedException();
    }
}

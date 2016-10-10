package src.com.irina.data.dao;

import src.com.irina.data.entity.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserAccountController extends AbstractController<UserAccount, Integer> {
    private static final String SELECT_ALL_USER_ACCOUNT = "SELECT * FROM user_account;";
    private static final String UPDATE_USER_ACCOUNT = "UPDATE user_account SET name = ?, password = ?, modify_date = ? WHERE id = ?";
    private static final String GET_USER_ACCOUNT_BY_ID = "SELECT DISTINCT * FROM user_account WHERE id = ?;";
    private static final String DELETE_USER_ACCOUNT = "DELETE FROM user_account WHERE id = ?";
    private static final String CREATE_USER_ACCOUNT = "INSERT INTO user_account VALUES (?, ?, ?)";


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
    public boolean update(UserAccount entity) {
        PreparedStatement ps = getPrepareStatement(UPDATE_USER_ACCOUNT);
        boolean updateResult = false;
        try {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPassword());
            ps.setDate(3, (Date) entity.getModifyData());
            ps.setInt(4, entity.getId());

            updateResult = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return updateResult;
    }

    @Override
    public UserAccount getEntityById(Integer id) {
        UserAccount userAccount = new UserAccount();
        PreparedStatement ps = getPrepareStatement(GET_USER_ACCOUNT_BY_ID);
        try {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            userAccount.setId(rs.getInt("id"));
            userAccount.setName(rs.getString("name"));
            userAccount.setPassword(rs.getString("password"));
            userAccount.setModifyData(rs.getDate("modify_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return userAccount;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement ps = getPrepareStatement(DELETE_USER_ACCOUNT);
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
    public boolean create(UserAccount entity) {
        PreparedStatement ps = getPrepareStatement(CREATE_USER_ACCOUNT);
        boolean createResult = false;
        try {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPassword());
            ps.setDate(3, (Date) entity.getModifyData());

            createResult = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return createResult;
    }
}
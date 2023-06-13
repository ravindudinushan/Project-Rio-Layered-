package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User,String> {
    public boolean updatePassword(String username, String newpassword) throws SQLException;

    public User findByUserName(String id) throws SQLException;

}

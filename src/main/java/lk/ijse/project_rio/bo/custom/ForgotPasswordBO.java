package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.dao.SuperDAO;
import lk.ijse.project_rio.dto.UserDTO;

import java.sql.SQLException;

public interface ForgotPasswordBO extends SuperDAO {
    public UserDTO findByUserName(String id) throws SQLException;

    public boolean updatePassword(String username, String newpassword) throws SQLException;
}

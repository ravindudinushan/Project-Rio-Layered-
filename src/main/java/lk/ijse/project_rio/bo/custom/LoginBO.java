package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.UserDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    public UserDTO findByUserName(String id) throws SQLException;
}

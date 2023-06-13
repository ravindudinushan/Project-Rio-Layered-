package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.UserDTO;

import java.sql.SQLException;

public interface SignUpBO extends SuperBO {
    public boolean save(UserDTO dto) throws SQLException, ClassNotFoundException;
}

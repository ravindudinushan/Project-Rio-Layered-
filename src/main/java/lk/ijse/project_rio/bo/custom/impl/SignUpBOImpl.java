package lk.ijse.project_rio.bo.custom.impl;

import lk.ijse.project_rio.bo.custom.SignUpBO;
import lk.ijse.project_rio.dao.DAOFactory;
import lk.ijse.project_rio.dao.custom.UserDAO;
import lk.ijse.project_rio.dto.UserDTO;
import lk.ijse.project_rio.entity.User;

import java.sql.SQLException;

public class SignUpBOImpl implements SignUpBO {
    UserDAO userDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public boolean save(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getName(),dto.getPassword(),dto.getJobTitle(),dto.getEmail()));
    }
}

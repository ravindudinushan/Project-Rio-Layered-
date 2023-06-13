package lk.ijse.project_rio.bo.custom.impl;

import lk.ijse.project_rio.bo.custom.LoginBO;
import lk.ijse.project_rio.dao.DAOFactory;
import lk.ijse.project_rio.dao.custom.UserDAO;
import lk.ijse.project_rio.dto.UserDTO;
import lk.ijse.project_rio.entity.User;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    UserDAO userDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public UserDTO findByUserName(String id) throws SQLException {
        User user = userDAO.findByUserName(id);
        return new UserDTO(user.getUserName(),user.getPassword(),user.getJobTitle(),user.getEmail());
    }

}

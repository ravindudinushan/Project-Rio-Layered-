package lk.ijse.project_rio.bo.custom;
import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public CustomerDTO findByCustomerId(String id) throws SQLException;

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

}

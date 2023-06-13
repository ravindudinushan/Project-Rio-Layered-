package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.CustomerDTO;
import lk.ijse.project_rio.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;

    public EmployeeDTO findByEmployeeId(String id) throws SQLException;

    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

}

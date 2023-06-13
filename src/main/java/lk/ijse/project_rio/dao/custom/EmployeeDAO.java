package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee,String> {
    public Employee findById(String id) throws SQLException;

    public List<String> loadIds() throws SQLException;
}

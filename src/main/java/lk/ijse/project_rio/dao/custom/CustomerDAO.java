package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public Customer findById(String id) throws SQLException;

    public List<String> loadCustomerIds() throws SQLException;

    public String getCustName(String custId) throws SQLException;
}

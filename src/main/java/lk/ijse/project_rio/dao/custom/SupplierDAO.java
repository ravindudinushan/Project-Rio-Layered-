package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier,String> {
    public Supplier findById(String id) throws SQLException;

    public List<String> loadIds() throws SQLException;
}

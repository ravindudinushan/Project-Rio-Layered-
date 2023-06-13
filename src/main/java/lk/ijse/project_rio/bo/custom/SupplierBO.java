package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    public boolean saveSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException;

    public SupplierDTO findBy(String id) throws SQLException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}

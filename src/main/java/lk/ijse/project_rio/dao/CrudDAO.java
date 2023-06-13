package lk.ijse.project_rio.dao;

import lk.ijse.project_rio.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID> extends SuperDAO{
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;


}

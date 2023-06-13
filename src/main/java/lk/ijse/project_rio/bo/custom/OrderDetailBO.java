package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {
    public ArrayList<CustomDTO> getAll() throws SQLException;

    public CustomDTO fillFields(String orderid) throws SQLException;

    public int totalOrdersToday() throws SQLException;

    public int totalOrdersMonth() throws SQLException;

    public ArrayList<CustomDTO> searchbyorderdate(String date) throws SQLException;
}

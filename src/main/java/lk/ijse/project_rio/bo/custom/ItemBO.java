package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.InventoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public boolean saveItem(InventoryDTO dto) throws SQLException, ClassNotFoundException;

    public ArrayList<InventoryDTO> getAllItem() throws SQLException, ClassNotFoundException;

    public InventoryDTO findByItemId(String id) throws SQLException;

    public boolean updateItem(InventoryDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
}

package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.InventoryDTO;
import lk.ijse.project_rio.dto.NewLoadSupplierDTO;
import lk.ijse.project_rio.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.List;

public interface SupplierOrderDetailBO extends SuperBO {
    public List<String> loadSupplierIds() throws SQLException;

    public List<String> loadItemIds() throws SQLException;

    public String getNextSupplyLoadId() throws SQLException;

    public boolean placeLoad(String loadid, String suppid, String totalprice, List<NewLoadSupplierDTO> placeSupplyLoadList) throws SQLException, ClassNotFoundException;

    public SupplierDTO findBySupId(String supp_id) throws SQLException;

    public InventoryDTO findBy(String id) throws SQLException;

}

package lk.ijse.project_rio.bo.custom;

import lk.ijse.project_rio.bo.SuperBO;
import lk.ijse.project_rio.dto.InventoryDTO;
import lk.ijse.project_rio.dto.NewDeliveryDTO;
import lk.ijse.project_rio.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderBO extends SuperBO {
    public String getNextOrderId() throws SQLException;

    public List<String> loadCustomerIds() throws SQLException;

    public List<String> loadItemCodes() throws SQLException;

    public String getCustomerName(String custId) throws SQLException;

    public InventoryDTO findByItemCode(String id) throws SQLException;

    public boolean placeOrder(String orderId, String custId, Boolean delivery, String ordpay, List<OrderDTO> orderList) throws SQLException, ClassNotFoundException;

    public void sendObject(NewDeliveryDTO newDelivery);

    public List<String> loadEmployeeIds() throws SQLException;
}

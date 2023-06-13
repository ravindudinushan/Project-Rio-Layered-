package lk.ijse.project_rio.dao.custom.impl;

import lk.ijse.project_rio.dao.custom.OrderDetailDAO;
import lk.ijse.project_rio.entity.OrderDetail;
import lk.ijse.project_rio.dao.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetail dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orderItemDetail(orderId,itemId,orderQty)" +
                "VALUES(?, ?, ?)";

        return CrudUtil.execute(
                sql,
                dto.getOrderId(),
                dto.getItemId(),
                dto.getOrderQty()

        );
    }

    @Override
    public boolean update(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}

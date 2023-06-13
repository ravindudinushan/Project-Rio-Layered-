package lk.ijse.project_rio.dao.custom;

import javafx.scene.chart.XYChart;
import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.dto.OrderDTO;
import lk.ijse.project_rio.entity.Item;
import lk.ijse.project_rio.entity.OrderDetail;
import lk.ijse.project_rio.entity.SupplierOrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item,String> {
    public lk.ijse.project_rio.entity.Item findById(String id) throws SQLException;

    public List<String> loadItemId() throws SQLException;

    public boolean updateQty(OrderDetail placeorder) throws SQLException;

    public boolean addQty(SupplierOrderDetail supplierOrderDetail) throws SQLException;

    public ArrayList<XYChart.Series<String, Integer>> getDataToBarChart() throws SQLException;

}

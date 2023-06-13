package lk.ijse.project_rio.dao.custom;

import javafx.scene.chart.XYChart;
import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO extends CrudDAO<Order,String> {
    public boolean cancelDelivery(String ordid) throws SQLException;

    public String getNextOrderId() throws SQLException;

    public int totalOrdersToday() throws SQLException;

    public int totalOrdersMonth() throws SQLException;

    public List<XYChart.Data<String, Double>> getDataToAreaChart(String year) throws SQLException;

}

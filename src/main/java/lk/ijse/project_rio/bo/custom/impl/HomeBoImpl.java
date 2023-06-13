package lk.ijse.project_rio.bo.custom.impl;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lk.ijse.project_rio.bo.custom.HomeBO;
import lk.ijse.project_rio.dao.DAOFactory;
import lk.ijse.project_rio.dao.custom.ItemDAO;
import lk.ijse.project_rio.dao.custom.OrderDAO;
import lk.ijse.project_rio.dao.custom.QueryDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeBoImpl implements HomeBO {
    QueryDAO queryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO ordersDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    public ArrayList<PieChart.Data> getDataToPieChart() throws SQLException {
        return queryDAO.getDataToPieChart();
    }

    public ArrayList<XYChart.Series<String, Integer>> getDataToBarChart() throws SQLException {
        return itemDAO.getDataToBarChart();
    }

    public List<XYChart.Data<String, Double>> getDataToAreaChart(String year) throws SQLException {
        return ordersDAO.getDataToAreaChart(year);
    }
}

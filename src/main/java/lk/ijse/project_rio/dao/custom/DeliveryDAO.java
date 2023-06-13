package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryDAO extends CrudDAO<Delivery,String> {
    public Delivery findById(String id) throws SQLException;

    public Delivery findBydeliveryId(String delid) throws SQLException;

    public ArrayList<Delivery> getByDueDate(String duedate) throws SQLException;

    public ArrayList<Delivery> getByDeliveryStatus(String delists) throws SQLException;

}

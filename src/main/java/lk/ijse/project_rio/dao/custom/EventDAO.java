package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.Event;

import java.sql.SQLException;
import java.util.List;

public interface EventDAO extends CrudDAO<Event,String> {
    public Event findById(String id) throws SQLException;

    public List<String> loadIds() throws SQLException;
}

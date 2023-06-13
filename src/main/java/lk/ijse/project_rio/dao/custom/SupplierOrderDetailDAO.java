package lk.ijse.project_rio.dao.custom;

import lk.ijse.project_rio.dao.CrudDAO;
import lk.ijse.project_rio.entity.SupplierOrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierOrderDetailDAO extends CrudDAO<SupplierOrderDetail,String> {

    public String getNextSupplyLoadId() throws SQLException;

}

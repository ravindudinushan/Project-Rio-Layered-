package lk.ijse.project_rio.bo.custom.impl;

import lk.ijse.project_rio.bo.custom.SupplierOrderDetailBO;
import lk.ijse.project_rio.dao.DAOFactory;
import lk.ijse.project_rio.dao.custom.ItemDAO;
import lk.ijse.project_rio.dao.custom.SupplierDAO;
import lk.ijse.project_rio.dao.custom.SupplierOrderDetailDAO;
import lk.ijse.project_rio.db.DBConnection;
import lk.ijse.project_rio.dto.InventoryDTO;
import lk.ijse.project_rio.dto.NewLoadSupplierDTO;
import lk.ijse.project_rio.dto.SupplierDTO;
import lk.ijse.project_rio.dto.SupplierLoadDetailDTO;
import lk.ijse.project_rio.entity.Item;
import lk.ijse.project_rio.entity.Supplier;
import lk.ijse.project_rio.entity.SupplierOrderDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SupplierOrderDetailBOImpl implements SupplierOrderDetailBO {
    SupplierDAO supplierDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    SupplierOrderDetailDAO supplierOrderDetailDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER_ORDER_DETAIL);

    public List<String> loadSupplierIds() throws SQLException {
        return supplierDAO.loadIds();
    }

    public List<String> loadItemIds() throws SQLException {
        return itemDAO.loadItemId();
    }

    public String getNextSupplyLoadId() throws SQLException {
        return supplierOrderDetailDAO.getNextSupplyLoadId();
    }

    public boolean placeLoad(String loadid, String suppid, String totalprice, List<NewLoadSupplierDTO> placeSupplyLoadList) throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            System.out.println(loadid);
            SupplierLoadDetailDTO supplierLoadDetailDTO = new SupplierLoadDetailDTO(loadid,suppid,Double.parseDouble(totalprice));
            System.out.println("1"+supplierLoadDetailDTO.getSupplierOrderId());
            boolean isSaved = save(supplierLoadDetailDTO,placeSupplyLoadList);
            if(isSaved) {
                boolean isUpdated = addQty(placeSupplyLoadList);
                if(isUpdated) {
                    con.commit();
                    return true;
                }
            }
            return false;
        } catch (SQLException er) {
            System.out.println(er);
            con.rollback();
            return false;
        } finally {
            System.out.println("finally");
            con.setAutoCommit(true);
        }
    }

    public boolean save(SupplierLoadDetailDTO sld, List<NewLoadSupplierDTO> newLoadList) throws SQLException, ClassNotFoundException {
        for(NewLoadSupplierDTO dto : newLoadList) {
            System.out.println("2"+sld.getSupplierOrderId());
            SupplierOrderDetail supplierOrderDetail = new SupplierOrderDetail(sld.getSupplierOrderId(),dto.getItemId(),sld.getSupId(),dto.getSupQty(),LocalDate.now(),LocalTime.now(), sld.getPrice());
            if(!supplierOrderDetailDAO.save(supplierOrderDetail)) {
                return false;
            }
        }
        return true;
    }

    public boolean addQty(List<NewLoadSupplierDTO> placeSupplyLoadList) throws SQLException {
        for(NewLoadSupplierDTO sod : placeSupplyLoadList) {
            SupplierOrderDetail supplierOrderDetail = new SupplierOrderDetail(sod.getItemId(),sod.getSupQty());
            if(!itemDAO.addQty(supplierOrderDetail)) {
                return false;
            }
        }
        return true;
    }

    public SupplierDTO findBySupId(String supp_id) throws SQLException {
        Supplier supplier = supplierDAO.findById(supp_id);
        return new SupplierDTO(supplier.getSupId(),supplier.getSupName(),supplier.getAddress(),supplier.getEmail(),supplier.getContact());
    }

    public InventoryDTO findBy(String id) throws SQLException {
        Item itm =  itemDAO.findById(id);
        return new InventoryDTO(itm.getItemId(),itm.getItemName(),itm.getCategory(),itm.getUnitPrice(),itm.getQtyOnHand());
    }
}

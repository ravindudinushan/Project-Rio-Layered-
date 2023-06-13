package lk.ijse.project_rio.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project_rio.bo.BOFactory;
import lk.ijse.project_rio.bo.custom.ItemBO;
import lk.ijse.project_rio.dto.InventoryDTO;
import lk.ijse.project_rio.view.tdm.InventoryTM;
import lk.ijse.project_rio.controller.util.AlertController;
import lk.ijse.project_rio.controller.util.ValidateField;

public class InventoryFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField itemId;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField itemCategory;

    @FXML
    private TableColumn<?, ?> itemColCategory;

    @FXML
    private TableColumn<?, ?> itemColId;

    @FXML
    private TableColumn<?, ?> itemColName;

    @FXML
    private TableColumn<?, ?> itemColQtyOnHand;

    @FXML
    private TableColumn<?, ?> itemColUnitPrice;

    @FXML
    private TextField itemName;

    @FXML
    private TextField itemUnitPrice;

    @FXML
    private Button saveBtn;

    @FXML
    private ImageView searchIcon;

    @FXML
    private TextField itemQtyOnHand;

    @FXML
    private TableView<InventoryTM> tblItem;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button updateBtn;

    @FXML
    private AnchorPane adminChangingPane;

    @FXML
    private Label lblinvaliditemid;

    ItemBO itemBO=  BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ITEM_BO);

    @FXML
    void clickOnActionDelete(ActionEvent event) {
        String id = itemId.getText();

        boolean result = AlertController.okconfirmmessage("Are you sure you want to remove this Inventory?");
        if(result==true) {
            try {
                boolean isDeleted = itemBO.deleteItem(id);
                if (isDeleted) {
                    AlertController.confirmmessage("Inventory Deleted Successfully");
                    itemId.setText("");
                    itemName.setText("");
                    itemCategory.setText("");
                    itemUnitPrice.setText("");
                    itemQtyOnHand.setText("");

                    getAll();
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
                AlertController.errormessage("something went wrong!");
            }
        }
    }

    @FXML
    void clickOnActionSave(ActionEvent event) throws ClassNotFoundException {
        String id = itemId.getText();
        String name = itemName.getText();
        String category = itemCategory.getText();
        Double unitPrice = Double.valueOf(itemUnitPrice.getText());
        String qtyOnHand = itemQtyOnHand.getText();
        if(id.isEmpty() || name.isEmpty() || unitPrice.isNaN() || qtyOnHand.isEmpty()){
            AlertController.errormessage("Item not saved successfully.\nPlease make sure to fill out all the required fields.");
        }else{
            if(ValidateField.itemIdCheck(id)) {
                try {
                    boolean isSaved = itemBO.saveItem(new InventoryDTO(id,name,category,unitPrice,qtyOnHand));
                    if (isSaved) {
                        AlertController.confirmmessage("New Item added successfully");
                        itemId.setText(null);
                        itemName.setText(null);
                        itemCategory.setText(null);
                        itemUnitPrice.setText(null);
                        itemQtyOnHand.setText(null);
                        getAll();
                    }
                }catch(SQLIntegrityConstraintViolationException e){
                    AlertController.errormessage("This Item ID already exists.");
                } catch (SQLException e) {
                    System.out.println(e);
                    new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
                }
            }else{
                lblinvaliditemid.setVisible(true);
                lblinvaliditemid.setStyle("-fx-text-fill: red");
            }
        }
    }

    @FXML
    void clickOnActionUpdate(ActionEvent event) throws ClassNotFoundException {
        String id = itemId.getText();
        String name = itemName.getText();
        String category = itemCategory.getText();
        Double unitPrice = Double.valueOf(itemUnitPrice.getText());
        String qtyOnHand = itemQtyOnHand.getText();

        boolean result = AlertController.okconfirmmessage("Are you sure you want to update this Inventory' details?");
        if(result==true) {

            if(id.isEmpty() || name.isEmpty() || unitPrice.isNaN() || qtyOnHand.isEmpty()){
                AlertController.errormessage("Item not updated successfully.\nPlease make sure to fill out all the required fields.");
            }else{
                if(ValidateField.itemIdCheck(id)) {
                    InventoryDTO inventoryDTO = new InventoryDTO(id,name,category,unitPrice,qtyOnHand);

                    try {
                        boolean isUpdated = itemBO.updateItem(inventoryDTO);
                        if (isUpdated) {
                            AlertController.confirmmessage("New Item added successfully");
                            itemId.setText(null);
                            itemName.setText(null);
                            itemCategory.setText(null);
                            itemUnitPrice.setText(null);
                            itemQtyOnHand.setText(null);
                            getAll();
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        new Alert(Alert.AlertType.ERROR, "something went wrong!");
                    }
                }else{
                    lblinvaliditemid.setVisible(true);
                    lblinvaliditemid.setStyle("-fx-text-fill: red");
                }
            }
        }
    }

    @FXML
    void searchIconOnMousePressed(MouseEvent event) {
        txtSearch.requestFocus();
        txtSearch.selectAll();
        txtSearch.fireEvent(new ActionEvent());
    }

    @FXML
    void txtSearchKeyTyped(KeyEvent event) throws SQLException, ClassNotFoundException {
        String searchValue = txtSearch.getText().trim();
        ObservableList<InventoryTM> obList = FXCollections.observableArrayList();
        ArrayList<InventoryDTO> all = itemBO.getAllItem();

        for (InventoryDTO i : all) {
            obList.add(new InventoryTM(i.getId(),i.getName(),i.getCategory(),i.getUnitPrice(),i.getQtyOnHand()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<InventoryTM> filteredData = obList.filtered(new Predicate<InventoryTM>(){
                @Override
                public boolean test(InventoryTM inventorytm) {
                    return String.valueOf(inventorytm.getId()).toLowerCase().contains(searchValue.toLowerCase());
                }
            });
            tblItem.setItems(filteredData);
        } else {
            tblItem.setItems(obList);
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtSearch.getText();

        itemId.setText("");
        itemName.setText("");
        itemCategory.setText("");
        itemUnitPrice.setText("");
        itemQtyOnHand.setText("");


        InventoryDTO inventoryDTO = itemBO.findByItemId(id);
        if(inventoryDTO !=null) {
            itemId.setText(inventoryDTO.getId());
            itemName.setText(inventoryDTO.getName());
            itemCategory.setText(inventoryDTO.getCategory());
            itemUnitPrice.setText(String.valueOf(inventoryDTO.getUnitPrice()));
            itemQtyOnHand.setText(inventoryDTO.getQtyOnHand());

            txtSearch.setText("");

        }else{
            AlertController.errormessage("Item ID Not Found");
        }
    }

    private void getAll() throws ClassNotFoundException {
        ObservableList<InventoryTM> obList = FXCollections.observableArrayList();
        try {
            ArrayList<InventoryDTO> all = itemBO.getAllItem();

            for (InventoryDTO i : all) {
                obList.add(new InventoryTM(i.getId(),i.getName(),i.getCategory(),i.getUnitPrice(),i.getQtyOnHand()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tblItem.setItems(obList);
    }

    private void setCellValueFactory() {
        itemColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        itemColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemColCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        itemColUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        itemColQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    }

    @FXML
    void initialize() throws ClassNotFoundException {
        itemId.setText(null);
        itemName.setText(null);
        itemCategory.setText(null);
        itemUnitPrice.setText(null);
        itemQtyOnHand.setText(null);
        lblinvaliditemid.setVisible(false);
        setCellValueFactory();
        getAll();
        assert itemId != null : "fx:id=\"ItemId\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemCategory != null : "fx:id=\"itemCategory\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemColCategory != null : "fx:id=\"itemColCategory\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemColId != null : "fx:id=\"itemColId\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemColName != null : "fx:id=\"itemColName\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemColQtyOnHand != null : "fx:id=\"itemColQtyOnHand\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemColUnitPrice != null : "fx:id=\"itemColUnitPrice\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemName != null : "fx:id=\"itemName\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemQtyOnHand != null : "fx:id=\"itemQtyOnHand\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemUnitPrice != null : "fx:id=\"itemUnitPrice\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert saveBtn != null : "fx:id=\"saveBtn\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert searchIcon != null : "fx:id=\"searchIcon\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert itemQtyOnHand != null : "fx:id=\"supContact\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert tblItem != null : "fx:id=\"tblItem\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert txtSearch != null : "fx:id=\"txtSearch\" was not injected: check your FXML file 'inventory_form.fxml'.";
        assert updateBtn != null : "fx:id=\"updateBtn\" was not injected: check your FXML file 'inventory_form.fxml'.";

    }

    public void itemIdOnMousePressed(KeyEvent keyEvent) {
        lblinvaliditemid.setVisible(false);
    }
}

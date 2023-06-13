package lk.ijse.project_rio.controller;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project_rio.controller.util.BtnColorController;
import lk.ijse.project_rio.controller.util.LogOutController;
import lk.ijse.project_rio.controller.util.TimeAndDateController;

public class DashboardCashierFormController {

    @FXML
    private AnchorPane cashierChangingPane;

    @FXML
    private Button customerbtn;

    @FXML
    private Button deliverybtn;

    @FXML
    private Button eventbtn;

    @FXML
    private Button homebtn;

    @FXML
    private Button inventorybtn;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Button orderbtn;

    @FXML
    private AnchorPane cashDashPane;

    @FXML
    private Button supplyLoadbtn;

    @FXML
    void cashierCustomerOnAction(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(customerbtn,cashierChangingPane);
    }

    @FXML
    void initialize() {
        assert lblDate != null : "fx:id=\"lblDate\" was not injected: check your FXML file 'dashboard_cashier_form.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'dashboard_cashier_form.fxml'.";
        TimeAndDateController timeAndDate = new TimeAndDateController();
        timeAndDate.timenow(lblTime,lblDate);
    }

    public void clickOnActionInventory(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/inventory_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(inventorybtn,cashierChangingPane);
    }

    public void cashierOrderOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/order_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(orderbtn,cashierChangingPane);
    }

    public void cashierEventOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/event_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(eventbtn,cashierChangingPane);
    }

    public void logoutbtnOnMousePressed(MouseEvent mouseEvent) throws IOException {
        LogOutController.logout(cashDashPane);
    }

    public void cashierSupplyLoadOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/new_supply_load_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(supplyLoadbtn,cashierChangingPane);
    }

    public void clickOnActionDelivery(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/delivery_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(deliverybtn,cashierChangingPane);
    }

    public void onActionHomeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/home_form.fxml"));
        cashierChangingPane.getChildren().clear();
        cashierChangingPane.getChildren().add(load);
        BtnColorController.btncolor(homebtn,cashierChangingPane);
    }

    public void googleIconOnMouseClicked(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjj6fjShOb9AhX9XmwGHc_XAIEQPAgI"));

    }

    public void fbIconOnMouseClicked(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Facebook"));

    }
}

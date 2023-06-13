package lk.ijse.project_rio.controller;

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

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DashboardController {

    @FXML
    private AnchorPane adminChangingPane;

    @FXML
    private Button employeeBtn;

    @FXML
    private Button homebtn;

    @FXML
    private Button inventorybtn;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Button ordersbtn;

    @FXML
    private Button reportsbtn;

    @FXML
    private Button supplierBtn;

    @FXML
    private AnchorPane adminDashPane;

    @FXML
    void initialize() {
        assert lblDate != null : "fx:id=\"lblDate\" was not injected: check your FXML file 'dashboard_form.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'dashboard_form.fxml'.";

        TimeAndDateController timeAndDate = new TimeAndDateController();
        timeAndDate.timenow(lblTime,lblDate);
    }

    public void adminEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/employee_form.fxml"));
        adminChangingPane.getChildren().clear();
        adminChangingPane.getChildren().add(load);
        BtnColorController.btncolor(employeeBtn,adminChangingPane);
    }

    public void clickOnActionSupplierForm(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/supplier_form.fxml"));
        adminChangingPane.getChildren().clear();
        adminChangingPane.getChildren().add(load);
        BtnColorController.btncolor(supplierBtn,adminChangingPane);

    }

    public void adminInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/inventory_form.fxml"));
        adminChangingPane.getChildren().clear();
        adminChangingPane.getChildren().add(load);
        BtnColorController.btncolor(inventorybtn,adminChangingPane);
    }

    public void adminOrderOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/order_form.fxml"));
        adminChangingPane.getChildren().clear();
        adminChangingPane.getChildren().add(load);
        BtnColorController.btncolor(ordersbtn,adminChangingPane);

    }

    public void logoutbtnOnMousePressed(MouseEvent mouseEvent) throws IOException {
        LogOutController.logout(adminDashPane);
    }

    public void onActionreportsbtn(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/report_form.fxml"));
        adminChangingPane.getChildren().clear();
        adminChangingPane.getChildren().add(load);
        BtnColorController.btncolor(reportsbtn,adminChangingPane);
    }

    public void onActionHomeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/home_form.fxml"));
        adminChangingPane.getChildren().clear();
        adminChangingPane.getChildren().add(load);
        BtnColorController.btncolor(homebtn,adminChangingPane);
    }

    public void googleIconOnMouseClicked(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjj6fjShOb9AhX9XmwGHc_XAIEQPAgI"));
    }

    public void fbIconOnMouseClicked(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Facebook"));
    }
}

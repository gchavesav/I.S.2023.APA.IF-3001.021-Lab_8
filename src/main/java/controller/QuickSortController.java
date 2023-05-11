package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class QuickSortController
{
    @javafx.fxml.FXML
    private TableView tblViewNoSorted;
    @javafx.fxml.FXML
    private TextField txtLow;
    @javafx.fxml.FXML
    private TextField txtPivot;
    @javafx.fxml.FXML
    private TextField txtRecursiveCalls;
    @javafx.fxml.FXML
    private TextField txtHigh;
    @javafx.fxml.FXML
    private TableView tblViewSorted;

    @javafx.fxml.FXML
    public void initialize() {
    }
    @FXML
    void btnRandomizeOnAction(ActionEvent event) {

    }

    @FXML
    void btnStartOnAction(ActionEvent event) {

    }
}
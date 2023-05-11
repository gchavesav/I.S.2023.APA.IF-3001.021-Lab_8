package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BubbleSortController
{
    @javafx.fxml.FXML
    private TableView tableViewTempArray;
    @javafx.fxml.FXML
    private TextField txtLow;
    @javafx.fxml.FXML
    private TextField txtHigh;
    @javafx.fxml.FXML
    private Button btnRandomize;
    @javafx.fxml.FXML
    private TableView tableViewNoSortedArray;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void btnStart(ActionEvent actionEvent) {
    }

    public void tableViewRecursiveCalls(SortEvent<TableView> tableViewSortEvent) {

    }
}
package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

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
    private int array[];

    @javafx.fxml.FXML
    public void initialize() {
//agregamos las columnas al tableview
        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            tblViewNoSorted.getColumns().add(column);
        }
        tblViewNoSorted.setItems(getData());
    }
    private ObservableList getData() {
        this.array= new int[200];
        util.Utility.fill(array);
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(String.valueOf(array[i]));
        }
        data.add(arrayList);
        return data;
    }

    @FXML
    void btnRandomizeOnAction(ActionEvent event) {
        util.Utility.fill(array);
        tblViewNoSorted.setItems(getData());

    }

    @FXML
    void btnStartOnAction(ActionEvent event) {

    }
}
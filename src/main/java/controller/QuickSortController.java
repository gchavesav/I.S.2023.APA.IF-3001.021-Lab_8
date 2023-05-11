package controller;

import domain.Complex;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortController
{
    @FXML
    private TableView tblViewNoSorted;
    @FXML
    private TextField txtLow;
    @FXML
    private TextField txtPivot;
    @FXML
    private TextField txtRecursiveCalls;
    @FXML
    private TextField txtHigh;
    @FXML
    private TableView tblViewSorted;
    private int array[];
    Complex complex = new Complex();
    @FXML
    public void initialize() {

        this.array= new int[200];
        util.Utility.fill(array);
//agregamos las columnas al tableview
        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            tblViewNoSorted.getColumns().add(column);
        }
        txtPivot.setEditable(false);
        txtHigh.setEditable(false);
        txtLow.setEditable(false);
        txtRecursiveCalls.setEditable(false);
        tblViewNoSorted.setItems(getData());
    }
    private ObservableList getData() {

        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(String.valueOf(array[i]));
        }
        data.add(arrayList);
        return data;
    }
    private ObservableList getDataSorted() {

        complex.quickSort(array, 0, array.length-1);

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
        tblViewSorted.getItems().clear();
        txtRecursiveCalls.clear();
        txtLow.clear();
        txtHigh.clear();
        txtPivot.clear();
        complex.setHigh("");
        complex.setPivots("");
        complex.setContador(0);
        complex.setLows("");
    }

    @FXML
    void btnStartOnAction(ActionEvent event) {

        //agregamos las columnas al tableview
        if (txtRecursiveCalls.getText().isEmpty()) {
            for (int i = 0; i < 200; i++) {
                final int colIndex = i;
                TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i));
                column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
                tblViewSorted.getColumns().add(column);
            }
            tblViewSorted.setItems(getDataSorted());
            txtLow.setText((complex.getLows()));
            txtHigh.setText(complex.getHigh());
            txtPivot.setText(complex.getPivots());

            txtRecursiveCalls.setText(String.valueOf(complex.getContador()));
            complex.setContador(0);
        }
    }
}
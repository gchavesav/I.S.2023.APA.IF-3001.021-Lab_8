package controller;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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

public class ShellSortController {

    private int[] sortArray;
    @FXML
    private TableView tblNoSortedArray;

    @FXML
    private TableView tblSortedArray;

    @FXML
    private TextField txtGap1;

    @FXML
    private TextField txtGap2;

    @FXML
    private TextField txtGap3;

    @FXML
    private TextField txtGap4;

    @FXML
    void initialize(){
        sortArray = new int[200];
        setTable(tblNoSortedArray);
        setTable(tblSortedArray);
    }

    private void setTable(TableView table) {
        for (int i = 0; i < sortArray.length; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i + 1));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            table.getColumns().add(column);
        }
    }

    @FXML
    void onActionRandomize(ActionEvent event) {
        util.Utility.fill(sortArray, 200);
        tblNoSortedArray.setItems(getData());
    }

    @FXML
    void onActionStart(ActionEvent event) {

    }

    private ObservableList getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < sortArray.length; i++) {
            arrayList.add(String.valueOf(sortArray[i]));
        }
        data.add(arrayList);
        return data;
    }

}

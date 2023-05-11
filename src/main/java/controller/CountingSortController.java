package controller;

import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class CountingSortController
{
    @javafx.fxml.FXML
    private TableView counterTableView;
    @javafx.fxml.FXML
    private TableView countingSortedTableView;
    @javafx.fxml.FXML
    private TableView notSortedTableView;

    private Elementary elementaryArray;

    private int a[] = new int [200];

    @javafx.fxml.FXML
    public void initialize() {
        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>(""+(i));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            notSortedTableView.getColumns().add(column);
            /*counterTableView.getColumns().add(column);
            countingSortedTableView.getColumns().add(column);*/
        }



    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            info.add(String.valueOf(a[i]));
        }
        data.add(info);
        return data;
    }


    public void randomizeOnAction(ActionEvent actionEvent) {
        util.Utility.fill(a,99);
        notSortedTableView.setItems(getData());
    }

    public void startOnAction(ActionEvent actionEvent) {
        int []o = elementaryArray.getCounterArray();
       elementaryArray.countingSort(a);



    }
}
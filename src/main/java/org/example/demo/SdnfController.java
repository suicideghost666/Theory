package org.example.demo;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;
import java.util.Arrays;

import static javafx.collections.FXCollections.observableArrayList;

public class SdnfController {
    @FXML
    private TableView<TruthTable> tableView;
    @FXML
    private TableColumn<TruthTable, String> x1,x2,x3, res;
    private final ObservableList<TruthTable> obs = FXCollections.observableArrayList();
    private Modal modal;
    int sdnfCount;

    protected void initialize() {
        x1.setCellValueFactory(new PropertyValueFactory<TruthTable,String>("x1"));
        x2.setCellValueFactory(new PropertyValueFactory<TruthTable,String>("x2"));
        x3.setCellValueFactory(new PropertyValueFactory<TruthTable,String>("x3"));
        res.setEditable(true);
        res.setOnEditCommit(
                truthTableStringCellEditEvent -> truthTableStringCellEditEvent.getTableView().getItems().get(
                        truthTableStringCellEditEvent.getTablePosition().getRow()
                ).setRes(truthTableStringCellEditEvent.getNewValue())
        );

        for (int x1 = 0; x1 < 2; x1++) {
            for (int x2 = 0; x2 < 2; x2++) {
                for (int x3 = 0; x3 < 2; x3++) {
                    obs.add(
                            new TruthTable(
                                    String.valueOf(x1),
                                    String.valueOf(x2),
                                    String.valueOf(x3),null
                            )
                    );
                }
            }
        }
        tableView.setItems(obs);
        tableView.setEditable(true);
        res.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    @FXML
    protected void onCountClick() {
        calculateSdnf();
    }

    private void calculateSdnf() {
        if (modal != null) {
            modal.closeWindow();
        }
        String sdnf = "";
        for (int i = 0; i < obs.size(); i++) {
            TruthTable t = obs.get(i);
            System.out.println(t.getRes().get());
            if (t.getRes().get().equals("1")) {
                sdnf += (t.getX1().equals("1") ? "X1" : "!X1") +
                        (t.getX2().equals("1") ? "X2" : "!X2") +
                        (t.getX3().equals("1") ? "X3" : "!X3") + "+";
                sdnfCount++;
            }
        }
        if (sdnf.charAt(sdnf.length()-1) == '+') {
            sdnf = sdnf.substring(0, sdnf.length() - 1);
        }
        modal = new Modal();
        ArrayList<ArrayList<Integer>> ed = new ArrayList<ArrayList<Integer>>();
        ed.add(new ArrayList<>());
        ed.add(new ArrayList<>());
        ed.add(new ArrayList<>());
        ed.add(new ArrayList<>());
        System.out.println(ed.get(0).toString());
        String sdnfChecked = null;//check(sdnf.split("\\+"));
        modal.newWindow(sdnf, sdnfChecked);
    }
}
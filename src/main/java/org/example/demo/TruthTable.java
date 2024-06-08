package org.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TruthTable {
    private String x1, x2, x3;
    private StringProperty res;
    public TruthTable(String x1,String x2,String x3,String res) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.res = new SimpleStringProperty(res);
    }

    @Override
    public String toString() {
        return "TruthTable{" +
                "x1='" + x1 + '\'' +
                ", x2='" + x2 + '\'' +
                ", x3='" + x3 + '\'' +
                ", res='" + res + '\'' +
                '}';
    }

    public String getX1() {
        return x1;
    }

    public String getX2() {
        return x2;
    }

    public String getX3() {
        return x3;
    }

    public StringProperty getRes() {
        return res;
    }
    public void setRes(String res) {
        this.res = new SimpleStringProperty(res);
    }
}

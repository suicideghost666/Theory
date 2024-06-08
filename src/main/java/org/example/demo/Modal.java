package org.example.demo;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Modal {
    Stage win;
    public void newWindow(String unchecked, String checked) {
        win = new Stage();
        Pane pane = new Pane();
        Label lbl1 = new Label(unchecked);
        Label lbl2 = new Label(checked);
        Font font = new Font("Times New Roman",20);
        lbl1.setFont(font);
        lbl2.setFont(font);
        pane.getChildren().add(lbl1);
        lbl2.setLayoutY(lbl1.getLayoutY() + 20);
        pane.getChildren().add(lbl2);

        Scene scene = new Scene(pane,648,100);
        win.setScene(scene);
        win.setTitle("Результат");
        win.setX(436.79998779296875);
        win.setY(500);
        win.show();

    }
    public void closeWindow() {
        if (win != null) {
            win.close();
        }
    }

}

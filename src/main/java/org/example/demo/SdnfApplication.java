package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SdnfApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SdnfApplication.class.getResource("sdnf-view.fxml"));
        Parent root = fxmlLoader.load();
        SdnfController controller = fxmlLoader.getController();
        controller.initialize();
        Scene scene = new Scene(root, 648, 466);
        stage.setScene(scene);
        stage.setTitle("SDNF");
        stage.show();
        System.out.println(stage.getX());
    }
    

    public static void main(String[] args) {
        launch();
    }
}
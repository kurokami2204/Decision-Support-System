package com.example.hetrogiupluachonmonan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class View extends Application{
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        loader.setControllerFactory(clazz -> new ViewController());
        Parent root = loader.load();
        stage.setTitle("Hệ trợ giúp chọn món ăn!");
        Scene scene = new Scene(root);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

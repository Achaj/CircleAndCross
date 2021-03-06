package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PlanszaScene.fxml"));
        stage.setTitle("Kolko i krzyzyk");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }
}

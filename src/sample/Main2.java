package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/HomePage.fxml"));
            Scene scene = new Scene(root, 713, 445);
            primaryStage.setScene(scene);
            primaryStage.show();
            //primaryStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        launch(args);
    }

}

package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MarutiController implements Initializable {
    @FXML
    private JFXButton back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void backAction(javafx.event.ActionEvent actionEvent) {
        back.getScene().getWindow().hide();
        Stage backbutton = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load((getClass().getResource("HomePage.fxml")));
            Scene scene = new Scene(root);
            backbutton.setScene(scene);
            backbutton.show();
            backbutton.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

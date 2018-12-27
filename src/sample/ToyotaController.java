package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ToyotaController implements Initializable {

    @FXML
    private JFXButton back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void backAction(ActionEvent actionEvent) {
        back.getScene().getWindow().hide();
        Stage backbutton2 = new Stage();
        Parent root;
            try {
                root = FXMLLoader.load((getClass().getResource("HomePage.fxml")));
                Scene scene = new Scene(root);
                backbutton2.setScene(scene);
                backbutton2.show();
                backbutton2.setResizable(false);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

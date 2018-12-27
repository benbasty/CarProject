package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane homeAnchor;
    @FXML
    private Button maruti;
    @FXML
    private Button toyota;
    @FXML
    private Button latoya;
    @FXML
    private Button mustang;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void marutiAction(ActionEvent actionEvent) {
        maruti.getScene().getWindow().hide();
        Stage marutibutton = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load((getClass().getResource("Maruti.fxml")));
            Scene scene = new Scene(root);
            marutibutton.setScene(scene);
            marutibutton.show();
            marutibutton.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toyotaAction(ActionEvent actionEvent) {
        toyota.getScene().getWindow().hide();
        Stage toyotabutton = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load((getClass().getResource("Toyota.fxml")));
            Scene scene = new Scene(root);
            toyotabutton.setScene(scene);
            toyotabutton.show();
            toyotabutton.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void latoyaAction(ActionEvent actionEvent){
        latoya.getScene().getWindow().hide();
        Stage latoyabutton = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load((getClass().getResource("Latoya.fxml")));
            Scene scene = new Scene(root);
            latoyabutton.setScene(scene);
            latoyabutton.show();
            latoyabutton.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mustangAction(ActionEvent actionEvent){
        latoya.getScene().getWindow().hide();
        Stage mustangbutton = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load((getClass().getResource("Mustang.fxml")));
            Scene scene = new Scene(root);
            mustangbutton.setScene(scene);
            mustangbutton.show();
            mustangbutton.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

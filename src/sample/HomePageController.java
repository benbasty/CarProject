package sample;


import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.LoginController.getInstance;

public class HomePageController implements Initializable {

    @FXML Pane holderPanePage;
    @FXML private Text welcome;
    @FXML private AnchorPane anchor;
    @FXML private ToolBar toolbar;
    @FXML private VBox toolbarRight;
    @FXML private Label lblMenu;
    @FXML private VBox overflowContainer;
    @FXML private JFXButton btnLogout;
    @FXML private JFXButton btnExit;

    private static HomePageController instance;

    public HomePageController(){
        instance = this;
    }

    public static HomePageController getInstance(){
        return instance;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        createPage();
        setUsername(LoginController.getInstance().username());
    }

    public void setUsername(String user){
        this.welcome.setText("Welcome," + user);
    }







    private void setNode(Node node){
        holderPanePage.getChildren().clear();
        holderPanePage.getChildren().addAll((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }



    private void createPage() {

        try {
            AnchorPane home = FXMLLoader.load(getClass().getResource("/sample/Home.fxml"));
            setNode(home);


        } catch (IOException e) {
            e.printStackTrace();
        }

        }



    @FXML
    public void exit(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void logout(javafx.event.ActionEvent actionEvent) {
        btnLogout.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load((getClass().getResource("loginMain.fxml")));
            Scene scene = new Scene(root);
            login.setScene(scene);
            login.show();
            login.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}



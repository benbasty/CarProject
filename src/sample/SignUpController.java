package sample;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConnection.DBHandler;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private AnchorPane parentPane;

    @FXML
    private Button login;

    @FXML
    private TextField name;

    @FXML
    private Button signup;

    @FXML
    private ToggleGroup genders;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton other;

    @FXML
    private TextField location;

    @FXML
    private ImageView progress;

    @FXML
    private PasswordField password;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;




 @Override
public void initialize(URL arg0, ResourceBundle arg1) {
        progress.setVisible(false);
        name.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
        location.setStyle("-fx-text-inner-color: #a0a2ab;");
        handler = new DBHandler();
 }

    @FXML
    public void signUp(ActionEvent ev1) throws ClassNotFoundException {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(event -> {
            System.out.println("Sign Up successful");
        });
        pt.play();

        // saving data

        connection = handler.getConnection();
        String sql= "INSERT INTO carreview (names,password,gender,location)" + "VALUES (?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.setString(1, name.getText());
            pst.setString(2, password.getText());
            pst.setString(3, getGender());
            pst.setString(4, location.getText());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void loginActionFromSignupPage(ActionEvent ev2) throws IOException {
     signup.getScene().getWindow().hide();
        Stage loginAction = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
        Scene scene = new Scene(root);
        loginAction.setScene(scene);
        loginAction.show();
        loginAction.setResizable(false);
    }

    public String getGender(){

     String gen = "";
     if(male.isSelected()){
         gen = "Male";
     } else if (female.isSelected()){
         gen = "Female";
     } else if (other.isSelected()){
         gen = "Other";
     }
     return gen;
    }



}

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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DBConnection.DBHandler;

public class LoginController implements Initializable {
    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private CheckBox remember;

    @FXML
    private Button login;

    @FXML
    private Button forgotpassword;

    @FXML
    private ImageView progress;

    @FXML
    private PasswordField password;

    private DBHandler handler;
    private Connection connection;
    private PreparedStatement pst;

//    private static LoginController instance;
//
//    public LoginController() {
//        instance = this;
//    }
//
//    public static LoginController getInstance() {
//        return instance;
//    }
//
//    public String username(){
//        return username.getText();
//    }

    @Override
    public void initialize(URL arg1, ResourceBundle arg2) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");

        handler = new DBHandler();
    }

    @FXML
    public void loginAction(ActionEvent e1) throws ClassNotFoundException, SQLException {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(event -> {

            //retrieve username and password data from database
            try {
                connection = handler.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String q1 = "SELECT * from carreview WHERE names=? AND password=?";

            try {
                pst = connection.prepareStatement(q1);

                pst.setString(1,username.getText());
                pst.setString(2,password.getText());
                ResultSet rs = pst.executeQuery();

                int count = 0;

                while(rs.next()) {
                    count = count+1;
                }

                if (count == 1){
                    login.getScene().getWindow().hide();
                    Stage home = new Stage();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                        Scene scene = new Scene(root);
                        home.setScene(scene);
                        home.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Username and Password is not correct");
                    alert.show();
                    progress.setVisible(false);
                }
            }
            catch (SQLException e2) {
                e2.printStackTrace();
            }
            finally {
                try {
                    connection.close();
                } catch (SQLException e2){
                    e2.printStackTrace();
                }
            }
        });
        pt.play();




    }

    @FXML
    public void signUpClick(ActionEvent e2) throws IOException {
        login.getScene().getWindow().hide();
        Stage signUpstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        signUpstage.setScene(scene);
        signUpstage.show();
        signUpstage.setResizable(false);



    }
}


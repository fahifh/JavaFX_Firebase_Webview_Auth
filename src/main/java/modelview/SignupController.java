/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

/**
 *
 * @author forha
 */
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField textField_password;

    @FXML
    private Button button_signup;

    @FXML
    private Button button_login;

    @FXML
    private TextField textField_email1;

    @FXML
    private TextField textField_email2;

    @FXML
    private TextField textField_firstName;

    @FXML
    private TextField textField_lastName;

    @FXML
    private TextField textField_password1;

    @FXML
    private TextField textField_password2;
    private UserRecord userRecord;
    static UserRecord currentUser;

    @FXML
    void handleButton_back(ActionEvent event) throws IOException, FirebaseAuthException {

        App.setRoot("Login.fxml");

    }

    @FXML
    void handleButton_signup(ActionEvent event) throws IOException, FirebaseAuthException {

        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setDisplayName(textField_firstName.getText())
                .setDisplayName(textField_lastName.getText())
                .setEmail(textField_email1.getText())
                .setEmail(textField_email2.getText())
                .setPassword(textField_password1.getText())
                .setPassword(textField_password2.getText());
        try {
            userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());
        } catch (FirebaseAuthException ex) {
            System.err.println("Wrong Information");
        }

        handleButton_back(event);
    }

}

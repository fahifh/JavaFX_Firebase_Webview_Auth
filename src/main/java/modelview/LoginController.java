package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static modelview.SignupController.currentUser;

public class LoginController {

    @FXML
    private Button button_login;

    @FXML
    private Button button_signup;

    @FXML
    private TextField textField_password;

    @FXML
    private TextField textField_email1;

    @FXML
    void handleButton_login(ActionEvent event) throws IOException, FirebaseAuthException {
        try {
            String user = textField_email1.getText();
            String pass = textField_password.getText();

            currentUser = FirebaseAuth.getInstance().getUser(user);
            App.setRoot("AccessFBView.fxml");

        } catch (FirebaseAuthException fe) {
            //System.err.println("Username incomplete ");
            App.setRoot("AccessFBView.fxml");
        }
    }

    @FXML
    void handleButton_signup(ActionEvent event) throws IOException {
        App.setRoot("Signup.fxml");
    }

}

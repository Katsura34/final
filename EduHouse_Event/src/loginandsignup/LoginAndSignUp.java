
package loginandsignup;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;


public class LoginAndSignUp {
    public static void main(String[] args) {
        // Required to initialize JavaFX Toolkit
        new JFXPanel();

        // Now show the login window
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
}


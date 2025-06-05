/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.net.URL;

public class DashboardWindow extends JFrame {

    private final JFXPanel fxPanel = new JFXPanel(); // Embed JavaFX inside Swing

    public DashboardWindow() {
        setTitle("Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel loadingLabel = new JLabel("Loading dashboard...", SwingConstants.CENTER);
        add(loadingLabel);

        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();

            // Wait until HTML is fully loaded
            ChangeListener<Object> readyListener = (obs, oldVal, newVal) -> {
                if (engine.getDocument() != null) {
                    SwingUtilities.invokeLater(() -> {
                        // Replace "Loading..." with the actual content
                        setContentPane(fxPanel);
                        revalidate();
                    });
                }
            };

            engine.documentProperty().addListener(readyListener);

            URL url = getClass().getResource("/html/dashboard.html");
            if (url != null) {
                engine.load(url.toExternalForm());
            } else {
                System.out.println("HTML file not found!");
                JOptionPane.showMessageDialog(this, "dashboard.html not found!");
            }

            fxPanel.setScene(new Scene(webView));
        });
    }
}



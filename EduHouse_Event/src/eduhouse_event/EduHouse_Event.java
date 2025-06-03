package eduhouse_event;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import eduhouse_event.components.qr_scanner; // Correct import based on your structure

public class EduHouse_Event {

    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("QR Scanner Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            qr_scanner qrPanel = new qr_scanner();  // Using the imported class
            
            frame.getContentPane().add(qrPanel);
            frame.pack();  // Adjust frame size to panel's preferred size
            frame.setLocationRelativeTo(null); // Center on screen
            frame.setVisible(true);
        });
    }
}

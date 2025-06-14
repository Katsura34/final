/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.*;
/**
 *
 * @author jeson
 */
public final class qr_scanner extends javax.swing.JPanel {

    private Timer cameraTimer;
    private VideoCapture videoCapture;
    private int currentCameraIndex = 0;
    private boolean scanning = true;
    /**
     * Creates new form qr_scanner
     */
    public qr_scanner() {
         initComponents();           // ✅ Initialize all UI components
         initCameraSystem();         
    }


 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        change_cam = new javax.swing.JComboBox<>();
        camera = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 3, 81));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QR Scanner");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Camera:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(change_cam, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change_cam, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(camera, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initCameraSystem() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        listAvailableCameras();
        startCamera(currentCameraIndex);

        change_cam.addActionListener(e -> {
            stopCamera();
            currentCameraIndex = change_cam.getSelectedIndex();
            startCamera(currentCameraIndex);
        });
    }

    private void listAvailableCameras() {
        change_cam.removeAllItems();
        for (int i = 0; i < 5; i++) {
            VideoCapture testCam = new VideoCapture(i);
            if (testCam.isOpened()) {
                change_cam.addItem("Camera " + i);
                testCam.release();
            }
        }
        if (change_cam.getItemCount() == 0) {
            change_cam.addItem("No Camera Found");
        }
    }

    private void startCamera(int cameraIndex) {
        videoCapture = new VideoCapture(cameraIndex);
        if (!videoCapture.isOpened()) {
            System.out.println("Cannot open camera " + cameraIndex);
            return;
        }

        cameraTimer = new Timer();
        cameraTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!scanning) return;

                Mat frame = new Mat();
                if (videoCapture.read(frame)) {
                    BufferedImage bufferedImage = matToBufferedImage(frame);
                    camera.setIcon(new ImageIcon(bufferedImage.getScaledInstance(camera.getWidth(), camera.getHeight(), Image.SCALE_SMOOTH)));  
                    readQRCode(bufferedImage);
                }
            }
        }, 0, 10); 
    }

    private void stopCamera() {
        if (cameraTimer != null) cameraTimer.cancel();
        if (videoCapture != null && videoCapture.isOpened()) {
            videoCapture.release();
        }
    }

    private BufferedImage matToBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        mat.get(0, 0, targetPixels);
        return image;
    }

    private void readQRCode(BufferedImage image) {
    try {
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = new MultiFormatReader().decode(bitmap);

        if (result != null) {
            String qrText = result.getText();
            System.out.println("QR Code detected: " + qrText);
            scanning = false;

            boolean found = checkQRCodeInDatabase(qrText);

            SwingUtilities.invokeLater(() -> {
                if (found) {
                    JOptionPane pane = new JOptionPane("✅ QR Code recognized: " + qrText, JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = pane.createDialog(this, "Success");
                    dialog.setModal(false);
                    dialog.setVisible(true);

                    // Auto-close after 2 seconds
                    new Timer().schedule(new java.util.TimerTask() {
                        public void run() {
                            dialog.setVisible(false);
                            scanning = true;
                        }
                    }, 2000);
                } else {
                    JOptionPane.showMessageDialog(this, "❌ QR Code not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                    scanning = true;
                }
            });
        }
    } catch (NotFoundException e) {
        // No QR found – ignore
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   
    private boolean checkQRCodeInDatabase(String qrText) {
    boolean exists = false;
    String url = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL"; // Change this
    String user = "root";                            // Change this
    String password = "";                        // Change this

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        String sql = "SELECT * FROM qr_data WHERE qr_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, qrText);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            exists = true;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return exists;
}
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel camera;
    private javax.swing.JComboBox<String> change_cam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandsignup;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JCalendar;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;


import java.sql.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Vector;
import javax.imageio.ImageIO;

import org.jdatepicker.impl.*;  // Make sure jdatepicker JAR is added to your project
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jeson
 */
public class home extends javax.swing.JFrame {
     
 private Timer cameraTimer;
    private VideoCapture videoCapture;
    private int currentCameraIndex = 0;
    private boolean scanning = true;
    private int currentEventId = -1;
    
    

    

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
    
        
        
                      
   jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable2.rowAtPoint(evt.getPoint());
        int column = jTable2.columnAtPoint(evt.getPoint());

        if (column == 5) { // QR column
            Object value = jTable2.getValueAt(row, column);
            if (value instanceof ImageIcon) {
                ImageIcon qrIcon = (ImageIcon) value;

                // Resize QR for popup
                Image resized = qrIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resized);
                JLabel imageLabel = new JLabel(resizedIcon);

                // Download button inside modal
                JButton downloadBtn = new JButton("Save QR");
                downloadBtn.addActionListener(e -> {
                    BufferedImage buffered = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = buffered.createGraphics();
                    g2d.drawImage(resized, 0, 0, null);
                    g2d.dispose();

                    JFileChooser chooser = new JFileChooser();
                    chooser.setSelectedFile(new File("qr-code.png"));
                    int result = chooser.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        try {
                            File file = chooser.getSelectedFile();
                            ImageIO.write(buffered, "png", file);
                            JOptionPane.showMessageDialog(null, "Saved to: " + file.getAbsolutePath());
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                        }
                    }
                });

                // Layout for modal
                JPanel panel = new JPanel(new BorderLayout(10, 10));
                panel.add(imageLabel, BorderLayout.CENTER);
                panel.add(downloadBtn, BorderLayout.SOUTH);

                JOptionPane.showMessageDialog(null, panel, "QR Code", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
});


    
        
        
        
        
     DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        jTable2.setModel(new DefaultTableModel(
            model.getDataVector(),
            new Vector<>(Arrays.asList("Name", "Email", "Password", "Role", "House", "QR"))
        ) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 5) return javax.swing.ImageIcon.class; // QR column index
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
});

jTable2.setRowHeight(100); 

addEvent.setVisible(false);

             String role = LoginUserSession.role;
       if ("admin".equalsIgnoreCase(role)) {
    // Admin can see everything
    dashboardbutton.setVisible(true);
    eventsbutton.setVisible(true);
    accountsbutton.setVisible(true);
    attendancebutton.setVisible(true);
    scanqrbutton.setVisible(false);
    addEvent.setVisible(true);
    
} else if ("committee".equalsIgnoreCase(role)) {
    dashboardbutton.setVisible(true);
    eventsbutton.setVisible(true);
    accountsbutton.setVisible(false);
    attendancebutton.setVisible(true);
    scanqrbutton.setVisible(false);
    
} else if ("student".equalsIgnoreCase(role)) {
    dashboardbutton.setVisible(true);
    eventsbutton.setVisible(true);
    accountsbutton.setVisible(false);
    attendancebutton.setVisible(false);
    scanqrbutton.setVisible(false);
}
   
        loadDashboardData();

    }


   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        navbarpanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dashboardbutton = new javax.swing.JButton();
        eventsbutton = new javax.swing.JButton();
        accountsbutton = new javax.swing.JButton();
        attendancebutton = new javax.swing.JButton();
        scanqrbutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        mainpanel = new javax.swing.JPanel();
        dashboardpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dash = new javax.swing.JPanel();
        eventspanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        calendarPanel = new javax.swing.JPanel();
        eventPanel = new javax.swing.JPanel();
        addEvent = new javax.swing.JButton();
        accountspanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        searchtxt = new javax.swing.JTextField();
        filters = new javax.swing.JComboBox<>();
        seachtxt = new javax.swing.JButton();
        add = new javax.swing.JButton();
        attendancepanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        viewAttendance = new javax.swing.JPanel();
        scanqrpanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        change_cam = new javax.swing.JComboBox<>();
        camera = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("home");
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setResizable(false);

        jPanel2.setLayout(new java.awt.BorderLayout());

        navbarpanel.setBackground(new java.awt.Color(25, 42, 86));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ACLC");
        jLabel6.setAlignmentX(0.2F);

        dashboardbutton.setBackground(new java.awt.Color(25, 42, 86));
        dashboardbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dashboardbutton.setForeground(new java.awt.Color(255, 255, 255));
        dashboardbutton.setText("Dashboard");
        dashboardbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardbuttonActionPerformed(evt);
            }
        });

        eventsbutton.setBackground(new java.awt.Color(25, 42, 86));
        eventsbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eventsbutton.setForeground(new java.awt.Color(255, 255, 255));
        eventsbutton.setText("Events");
        eventsbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventsbuttonActionPerformed(evt);
            }
        });

        accountsbutton.setBackground(new java.awt.Color(25, 42, 86));
        accountsbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accountsbutton.setForeground(new java.awt.Color(255, 255, 255));
        accountsbutton.setText("Accounts");
        accountsbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsbuttonActionPerformed(evt);
            }
        });

        attendancebutton.setBackground(new java.awt.Color(25, 42, 86));
        attendancebutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attendancebutton.setForeground(new java.awt.Color(255, 255, 255));
        attendancebutton.setText("Attendance");
        attendancebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendancebuttonActionPerformed(evt);
            }
        });

        scanqrbutton.setBackground(new java.awt.Color(25, 42, 86));
        scanqrbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scanqrbutton.setForeground(new java.awt.Color(255, 255, 255));
        scanqrbutton.setText("Scan QR");
        scanqrbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanqrbuttonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EDUHOUSE EVENTS");

        Logout.setBackground(new java.awt.Color(25, 42, 86));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navbarpanelLayout = new javax.swing.GroupLayout(navbarpanel);
        navbarpanel.setLayout(navbarpanelLayout);
        navbarpanelLayout.setHorizontalGroup(
            navbarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navbarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navbarpanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dashboardbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventsbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountsbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(attendancebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scanqrbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(navbarpanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navbarpanelLayout.setVerticalGroup(
            navbarpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addComponent(dashboardbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eventsbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountsbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(attendancebutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scanqrbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout)
                .addContainerGap())
        );

        jPanel2.add(navbarpanel, java.awt.BorderLayout.WEST);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setLayout(new java.awt.CardLayout());

        dashboardpanel.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout dashLayout = new javax.swing.GroupLayout(dash);
        dash.setLayout(dashLayout);
        dashLayout.setHorizontalGroup(
            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
        );
        dashLayout.setVerticalGroup(
            dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashboardpanelLayout = new javax.swing.GroupLayout(dashboardpanel);
        dashboardpanel.setLayout(dashboardpanelLayout);
        dashboardpanelLayout.setHorizontalGroup(
            dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardpanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(671, Short.MAX_VALUE))
            .addGroup(dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboardpanelLayout.setVerticalGroup(
            dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(538, Short.MAX_VALUE))
            .addGroup(dashboardpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardpanelLayout.createSequentialGroup()
                    .addGap(0, 43, Short.MAX_VALUE)
                    .addComponent(dash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        mainpanel.add(dashboardpanel, "card6");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Events");

        calendarPanel.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout eventPanelLayout = new javax.swing.GroupLayout(eventPanel);
        eventPanel.setLayout(eventPanelLayout);
        eventPanelLayout.setHorizontalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        eventPanelLayout.setVerticalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        addEvent.setText("ADD");
        addEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eventspanelLayout = new javax.swing.GroupLayout(eventspanel);
        eventspanel.setLayout(eventspanelLayout);
        eventspanelLayout.setHorizontalGroup(
            eventspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventspanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 527, Short.MAX_VALUE)
                .addComponent(addEvent)
                .addGap(34, 34, 34))
            .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(eventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eventspanelLayout.setVerticalGroup(
            eventspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(addEvent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        mainpanel.add(eventspanel, "card5");

        accountspanel.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Accounts");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Email", "Password", "Role", "House", "Qr_code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        searchtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtxtActionPerformed(evt);
            }
        });

        filters.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "CAHEL", "VIERRDY", "AZUL", "GALLIO", "ROXXO" }));
        filters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtersActionPerformed(evt);
            }
        });

        seachtxt.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        seachtxt.setText("Search");
        seachtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seachtxtActionPerformed(evt);
            }
        });

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountspanelLayout = new javax.swing.GroupLayout(accountspanel);
        accountspanel.setLayout(accountspanelLayout);
        accountspanelLayout.setHorizontalGroup(
            accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountspanelLayout.createSequentialGroup()
                .addGroup(accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountspanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(accountspanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(accountspanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seachtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122))
                            .addGroup(accountspanelLayout.createSequentialGroup()
                                .addGroup(accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(accountspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        accountspanelLayout.setVerticalGroup(
            accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountspanelLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add)
                            .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(accountspanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(accountspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seachtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainpanel.add(accountspanel, "card4");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Attendance");

        javax.swing.GroupLayout viewAttendanceLayout = new javax.swing.GroupLayout(viewAttendance);
        viewAttendance.setLayout(viewAttendanceLayout);
        viewAttendanceLayout.setHorizontalGroup(
            viewAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        viewAttendanceLayout.setVerticalGroup(
            viewAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout attendancepanelLayout = new javax.swing.GroupLayout(attendancepanel);
        attendancepanel.setLayout(attendancepanelLayout);
        attendancepanelLayout.setHorizontalGroup(
            attendancepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancepanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(attendancepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
            .addComponent(viewAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        attendancepanelLayout.setVerticalGroup(
            attendancepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendancepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainpanel.add(attendancepanel, "card3");

        scanqrpanel.setBackground(new java.awt.Color(0, 3, 81));

        jPanel3.setBackground(new java.awt.Color(0, 3, 81));

        change_cam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_camActionPerformed(evt);
            }
        });

        camera.setBackground(new java.awt.Color(255, 0, 0));
        camera.setForeground(new java.awt.Color(255, 255, 255));
        camera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("QR Scanner");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select Camera:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(change_cam, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(camera, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(change_cam, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addComponent(camera, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        javax.swing.GroupLayout scanqrpanelLayout = new javax.swing.GroupLayout(scanqrpanel);
        scanqrpanel.setLayout(scanqrpanelLayout);
        scanqrpanelLayout.setHorizontalGroup(
            scanqrpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scanqrpanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        scanqrpanelLayout.setVerticalGroup(
            scanqrpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainpanel.add(scanqrpanel, "card2");

        jPanel2.add(mainpanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eventsbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsbuttonActionPerformed
        // TODO add your handling code here:                                            
            CardLayout cl = (CardLayout) mainpanel.getLayout();
            cl.show(mainpanel, "card5");
                stopCamera();

               setupCalendarAndEvents();
              
    }//GEN-LAST:event_eventsbuttonActionPerformed

    private void dashboardbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardbuttonActionPerformed
        // TODO add your handling code here:                                             
            CardLayout cl = (CardLayout) mainpanel.getLayout();
                cl.show(mainpanel, "card6");
                loadDashboardData();
                            stopCamera();
    }//GEN-LAST:event_dashboardbuttonActionPerformed

    private void attendancebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendancebuttonActionPerformed
        // TODO add your handling code here:                                             
            CardLayout cl = (CardLayout) mainpanel.getLayout();
            cl.show(mainpanel, "card3");  
            loadAttendanceSummary();
            stopCamera();
    }//GEN-LAST:event_attendancebuttonActionPerformed

    private void scanqrbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanqrbuttonActionPerformed
        // TODO add your handling code here:                                  
       // Show the scanner panel
    CardLayout cl = (CardLayout) mainpanel.getLayout();
    cl.show(mainpanel, "card2");

    // Directly initialize the camera
    initCameraSystem();
    }//GEN-LAST:event_scanqrbuttonActionPerformed

    private void accountsbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsbuttonActionPerformed
        // TODO add your handling code here:                                              
            CardLayout cl = (CardLayout) mainpanel.getLayout();
            cl.show(mainpanel, "card4");
           loadUserData();
         stopCamera();

    }//GEN-LAST:event_accountsbuttonActionPerformed

    private void change_camActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_camActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_change_camActionPerformed

    private void searchtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtxtActionPerformed

    private void seachtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seachtxtActionPerformed
      String keyword = searchtxt.getText().trim();
    String filterLabel = (String) filters.getSelectedItem();

   
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0); // Clear existing data

    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
            "root", "jesonmysql"
        );

        String query;
        PreparedStatement stmt;

        if ("ALL".equalsIgnoreCase(filterLabel)) {
            query = "SELECT name, email, password, role, house, qr_code FROM users WHERE name LIKE ? OR email LIKE ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
        } else {
            query = "SELECT name, email, password, role, house, qr_code FROM users WHERE house = ? AND (name LIKE ? OR email LIKE ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, filterLabel);
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String role = rs.getString("role");
            String house = rs.getString("house");
            String qrCode = rs.getString("qr_code");

            // Generate QR code as icon
            ImageIcon qrIcon = null;
            
            try {
                com.google.zxing.Writer writer = new com.google.zxing.qrcode.QRCodeWriter();
                com.google.zxing.common.BitMatrix matrix = writer.encode(qrCode, com.google.zxing.BarcodeFormat.QR_CODE, 100, 100);
                java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(100, 100, java.awt.image.BufferedImage.TYPE_INT_RGB);
                for (int x = 0; x < 100; x++) {
                    for (int y = 0; y < 100; y++) {
                        image.setRGB(x, y, matrix.get(x, y) ? java.awt.Color.BLACK.getRGB() : java.awt.Color.WHITE.getRGB());
                    }
                }
                qrIcon = new javax.swing.ImageIcon(image);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            model.addRow(new Object[]{name, email, password, role, house, qrIcon});
        }

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Search error: " + e.getMessage());
    }
    }//GEN-LAST:event_seachtxtActionPerformed

    private void filtersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtersActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
           JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField passwordField = new JTextField();
    JComboBox<String> roleCombo = new JComboBox<>(new String[]{"admin", "committee", "student"});
    JComboBox<String> houseCombo = new JComboBox<>(new String[]{"CAHEL", "VIERRDY", "AZUL", "GALLIO", "ROXXO"});

    JPanel panel = new JPanel(new java.awt.GridLayout(0, 1));
    panel.add(new JLabel("Name:"));
    panel.add(nameField);
    panel.add(new JLabel("Email:"));
    panel.add(emailField);
    panel.add(new JLabel("Password:"));
    panel.add(passwordField);
    panel.add(new JLabel("Role:"));
    panel.add(roleCombo);
    panel.add(new JLabel("House:"));
    panel.add(houseCombo);

    int result = JOptionPane.showConfirmDialog(null, panel, "Add New Account",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = (String) roleCombo.getSelectedItem();
        String house = (String) houseCombo.getSelectedItem();
        String qrCode = java.util.UUID.randomUUID().toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
                "root", "jesonmysql"
            );
            String insert = "INSERT INTO users (name, email, password, role, house, qr_code) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, role);
            stmt.setString(5, house);
            stmt.setString(6, qrCode);

            int rows = stmt.executeUpdate();
            conn.close();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Account added successfully!");
                loadUserData();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add account.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    }//GEN-LAST:event_addActionPerformed

    private void addEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventActionPerformed
    JTextField nameField = new JTextField();

    // --- Date Picker ---
    UtilDateModel dateModel = new UtilDateModel();
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    // --- Start Time Spinner ---
    SpinnerDateModel startModel = new SpinnerDateModel();
    JSpinner startTimeSpinner = new JSpinner(startModel);
    startTimeSpinner.setEditor(new JSpinner.DateEditor(startTimeSpinner, "HH:mm:ss"));

    // --- End Time Spinner ---
    SpinnerDateModel endModel = new SpinnerDateModel();
    JSpinner endTimeSpinner = new JSpinner(endModel);
    endTimeSpinner.setEditor(new JSpinner.DateEditor(endTimeSpinner, "HH:mm:ss"));

    JTextArea descArea = new JTextArea(3, 20);

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Event Name:"));
    panel.add(nameField);
    panel.add(new JLabel("Event Date:"));
    panel.add(datePicker);
    panel.add(new JLabel("Start Time:"));
    panel.add(startTimeSpinner);
    panel.add(new JLabel("End Time:"));
    panel.add(endTimeSpinner);
    panel.add(new JLabel("Description:"));
    panel.add(new JScrollPane(descArea));

    int result = JOptionPane.showConfirmDialog(null, panel, "Add Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        String name = nameField.getText().trim();
        Date selectedDate = (Date) datePicker.getModel().getValue();
        Date startTime = (Date) startTimeSpinner.getValue();
        Date endTime = (Date) endTimeSpinner.getValue();
        String desc = descArea.getText().trim();

        if (name.isEmpty() || selectedDate == null || startTime == null || endTime == null) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
                "root", "jesonmysql"
            );

            String insertQuery = "INSERT INTO events (event_name, event_date, start_time, end_time, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, name);
            stmt.setString(2, dateFormat.format(selectedDate));
            stmt.setString(3, timeFormat.format(startTime));
            stmt.setString(4, timeFormat.format(endTime));
            stmt.setString(5, desc);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Event added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add event.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
    }

    }//GEN-LAST:event_addEventActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
          int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        // Clear session data (optional)
        LoginUserSession.userId = 0;
        LoginUserSession.qrCode = null;
        LoginUserSession.role = null;

        // Close current window
        this.dispose();

        // Open login form again
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }

    }//GEN-LAST:event_LogoutActionPerformed

  
    
   class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object stringToValue(String text) throws java.text.ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}

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

            boolean found = checkQRCodeInDatabase(qrText, currentEventId);


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
   
    private boolean checkQRCodeInDatabase(String qrText, int eventId) {
    boolean exists = false;

    String url = "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String user = "root";
    String password = "";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        // 1. Get the user by QR
        String sql = "SELECT user_id, house FROM users WHERE qr_code = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, qrText);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int scannedUserId = rs.getInt("user_id");
            String scannedHouse = rs.getString("house");
            exists = true;

            // 2. Get the current user's house (committee/admin)
            String myHouse = "";
            PreparedStatement myStmt = conn.prepareStatement("SELECT house FROM users WHERE user_id = ?");
            myStmt.setInt(1, LoginUserSession.userId);
            ResultSet myRs = myStmt.executeQuery();
            if (myRs.next()) {
                myHouse = myRs.getString("house");
            }

            // 3. Check house match
            if (LoginUserSession.role.equalsIgnoreCase("committee") ||
                LoginUserSession.role.equalsIgnoreCase("admin")) {

                if (scannedHouse.equalsIgnoreCase(myHouse)) {
                    // 4. Check if already attended
                    PreparedStatement checkStmt = conn.prepareStatement(
                        "SELECT * FROM event_attendance WHERE event_id = ? AND user_id = ?");
                    checkStmt.setInt(1, eventId);
                    checkStmt.setInt(2, scannedUserId);
                    ResultSet checkRs = checkStmt.executeQuery();

                    if (!checkRs.next()) {
                        // 5. Insert attendance
                        PreparedStatement insertStmt = conn.prepareStatement(
                            "INSERT INTO event_attendance (event_id, user_id, timestamp) VALUES (?, ?, NOW())");
                        insertStmt.setInt(1, eventId);
                        insertStmt.setInt(2, scannedUserId);
                        insertStmt.executeUpdate();

                        System.out.println("Attendance recorded for user: " + scannedUserId);
                    } else {
                        System.out.println("User already attended.");
                    }

                    checkRs.close();
                    checkStmt.close();
                } else {
                    System.out.println("House does not match.");
                    return false;
                }
            }
        }

        rs.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return exists;
}

    private void loadEventsForDate(Date date) {
          eventPanel.removeAll();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
                    "root", "jesonmysql");  // use your credentials

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String sqlDate = sdf.format(date);

                String query = "SELECT event_id, event_name, start_time, end_time, description FROM events WHERE event_date = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, sqlDate);

                ResultSet rs = stmt.executeQuery();

                String[] columns;
                boolean canScan = LoginUserSession.role.equalsIgnoreCase("admin")
                               || LoginUserSession.role.equalsIgnoreCase("committee");

                if (LoginUserSession.role.equalsIgnoreCase("student")) {
                    columns = new String[]{"Event", "Start Time", "End Time", "Description", "Status", "Event ID"};
                } else if (canScan) {
                    columns = new String[]{"Event", "Start Time", "End Time", "Description", "Action", "Event ID"};
                } else {
                    columns = new String[]{"Event", "Start Time", "End Time", "Description", "Event ID"};
                }

                DefaultTableModel model = new DefaultTableModel(columns, 0);

                while (rs.next()) {
                    int eventId = rs.getInt("event_id");
                    String eventName = rs.getString("event_name");
                    String startTime = rs.getString("start_time");
                    String endTime = rs.getString("end_time");
                    String description = rs.getString("description");

                    if (LoginUserSession.role.equalsIgnoreCase("student")) {
                        String status = "";
                        LocalDate today = LocalDate.now();

                        PreparedStatement checkStmt = conn.prepareStatement(
                            "SELECT * FROM event_attendance ea JOIN events e ON e.event_id = ea.event_id " +
                            "WHERE ea.user_id = ? AND e.event_name = ? AND e.event_date = ?"
                        );
                        checkStmt.setInt(1, LoginUserSession.userId);
                        checkStmt.setString(2, eventName);
                        checkStmt.setString(3, sqlDate);
                        ResultSet checkRs = checkStmt.executeQuery();

                        if (checkRs.next()) {
                            status = "Attended";
                        } else if (LocalDate.parse(sqlDate).isBefore(today)) {
                            status = "Missed";
                        } else {
                            status = "Upcoming";
                        }

                        model.addRow(new Object[]{eventName, startTime, endTime, description, status, eventId});
                        checkRs.close();
                        checkStmt.close();
                    } else if (canScan) {
                        model.addRow(new Object[]{eventName, startTime, endTime, description, "Scan QR", eventId});
                    } else {
                        model.addRow(new Object[]{eventName, startTime, endTime, description, eventId});
                    }
                }

                JTable eventTable = new JTable(model) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        if (canScan) {
                            Object val = getValueAt(row, column);
                            return "Scan QR".equals(val);
                        }
                        return false;
                    }
                };

                // Hide Event ID column from view
                eventTable.getColumnModel().getColumn(eventTable.getColumnCount() - 1).setMinWidth(0);
                eventTable.getColumnModel().getColumn(eventTable.getColumnCount() - 1).setMaxWidth(0);
                eventTable.getColumnModel().getColumn(eventTable.getColumnCount() - 1).setWidth(0);

                // Add click listener for "Scan QR"
               if (canScan) {
                eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = eventTable.rowAtPoint(evt.getPoint());
                        int col = eventTable.columnAtPoint(evt.getPoint());

                        // Check if the clicked cell is the "Scan QR" button column
                        if (col == 4) {
                            // Get event ID from the hidden column
                            int eventId = (int) eventTable.getValueAt(row, eventTable.getColumnCount() - 1);

                            // Store event ID temporarily (so QR scan knows which event to log for)
                            currentEventId = eventId;
                            System.out.println("Selected Event ID set to: " + currentEventId);

                            // Switch to QR Scanner panel
                            CardLayout cl = (CardLayout) mainpanel.getLayout();
                            cl.show(mainpanel, "card2");

                            // Start the camera scanner
                            initCameraSystem();
                        }
                    }
                });
            }


                eventPanel.add(new JScrollPane(eventTable), BorderLayout.CENTER);
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                eventPanel.add(new JLabel("Failed to load events"), BorderLayout.CENTER);
            }

            eventPanel.revalidate();
            eventPanel.repaint();
        }

    private void setupCalendarAndEvents() {
        JCalendar calendar = new JCalendar();
        calendarPanel.setLayout(new BorderLayout());
        calendarPanel.add(calendar, BorderLayout.CENTER);

        eventPanel.setLayout(new BorderLayout());
        eventPanel.add(new JLabel("No event selected", SwingConstants.CENTER), BorderLayout.CENTER);

        calendar.addPropertyChangeListener("calendar", evt -> {
            Date selectedDate = calendar.getDate();
            loadEventsForDate(selectedDate);
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Logout;
    public javax.swing.JButton accountsbutton;
    private javax.swing.JPanel accountspanel;
    private javax.swing.JButton add;
    private javax.swing.JButton addEvent;
    public javax.swing.JButton attendancebutton;
    private javax.swing.JPanel attendancepanel;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JLabel camera;
    private javax.swing.JComboBox<String> change_cam;
    private javax.swing.JPanel dash;
    public javax.swing.JButton dashboardbutton;
    private javax.swing.JPanel dashboardpanel;
    private javax.swing.JPanel eventPanel;
    public javax.swing.JButton eventsbutton;
    private javax.swing.JPanel eventspanel;
    private javax.swing.JComboBox<String> filters;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public javax.swing.JTable jTable2;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel navbarpanel;
    public javax.swing.JButton scanqrbutton;
    private javax.swing.JPanel scanqrpanel;
    private javax.swing.JButton seachtxt;
    private javax.swing.JTextField searchtxt;
    private javax.swing.JPanel viewAttendance;
    // End of variables declaration//GEN-END:variables
private JTable upcomingEventsTable;
private JLabel eventsAttendedLabel;
private JLabel penaltiesLabel;
private JTextArea notificationsArea;


public void loadUserData() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel(); 
    // Define columns including Edit and Delete
    Vector<String> columns = new Vector<>(Arrays.asList("Name", "Email", "Password", "Role", "House", "QR", "Edit", "Delete"));
    model.setColumnIdentifiers(columns);
    model.setRowCount(0); // Clear existing rows

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
            "root", "jesonmysql"  // your password
        );

        String query = "SELECT name, email, password, role, house, qr_code FROM users";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String role = rs.getString("role");
            String house = rs.getString("house");
            String qrCode = rs.getString("qr_code");

            // Generate QR code image as ImageIcon
            ImageIcon qrIcon = null;
            try {
                com.google.zxing.Writer writer = new com.google.zxing.qrcode.QRCodeWriter();
                com.google.zxing.common.BitMatrix matrix = writer.encode(qrCode, com.google.zxing.BarcodeFormat.QR_CODE, 100, 100);
                java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(100, 100, java.awt.image.BufferedImage.TYPE_INT_RGB);
                for (int x = 0; x < 100; x++) {
                    for (int y = 0; y < 100; y++) {
                        image.setRGB(x, y, matrix.get(x, y) ? java.awt.Color.BLACK.getRGB() : java.awt.Color.WHITE.getRGB());
                    }
                }
                qrIcon = new javax.swing.ImageIcon(image);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // Add Edit and Delete buttons text as placeholders – actual buttons are rendered by renderer/editor
            model.addRow(new Object[]{name, email, password, role, house, qrIcon, "Edit", "Delete"});
        }

        // Set row height to fit the QR code image
        jTable2.setRowHeight(100);

        // Set font and colors
        jTable2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTable2.setForeground(new Color(33, 33, 33));
        jTable2.setGridColor(new Color(200, 200, 200));
        jTable2.setShowGrid(true);
        jTable2.setAutoCreateRowSorter(true);

        // Set header font and background color
        JTableHeader header = jTable2.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(25, 42, 86));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        header.setResizingAllowed(true);

        // Set column widths
        int[] columnWidths = {150, 220, 150, 100, 100, 120, 70, 70};
        for (int i = 0; i < columnWidths.length; i++) {
            if (i < jTable2.getColumnModel().getColumnCount()) {
                jTable2.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
            }
        }

        // QR code column renderer - center icon
        jTable2.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if (value instanceof ImageIcon) {
                    JLabel label = new JLabel();
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setIcon((ImageIcon) value);
                    label.setOpaque(true);
                    if (isSelected) {
                        label.setBackground(table.getSelectionBackground());
                    } else {
                        label.setBackground(table.getBackground());
                    }
                    return label;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
        




        // Alternating row colors
        jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245));
                }
                return c;
            }
        });

        conn.close();
        // Add click listener for Edit and Delete buttons
jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable2.rowAtPoint(evt.getPoint());
        int column = jTable2.columnAtPoint(evt.getPoint());

        if (column == 6) { // Edit column
            String email = (String) jTable2.getValueAt(row, 1);
            openEditDialog(email);
        } else if (column == 7) { // Delete column
            String email = (String) jTable2.getValueAt(row, 1);
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete: " + email + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteUser(email);
                loadUserData(); // Refresh table
            }
        }
    }
});

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading user data: " + e.getMessage());
    }
}

private void openEditDialog(String email) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "jesonmysql");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            JTextField nameField = new JTextField(rs.getString("name"));
            JTextField passwordField = new JTextField(rs.getString("password"));
            JComboBox<String> roleCombo = new JComboBox<>(new String[]{"admin", "committee", "student"});
            roleCombo.setSelectedItem(rs.getString("role"));
            JComboBox<String> houseCombo = new JComboBox<>(new String[]{"CAHEL", "VIERRDY", "AZUL", "GALLIO", "ROXXO"});
            houseCombo.setSelectedItem(rs.getString("house"));

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Name:")); panel.add(nameField);
            panel.add(new JLabel("Password:")); panel.add(passwordField);
            panel.add(new JLabel("Role:")); panel.add(roleCombo);
            panel.add(new JLabel("House:")); panel.add(houseCombo);

            int result = JOptionPane.showConfirmDialog(null, panel, "Edit Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                PreparedStatement update = conn.prepareStatement(
                    "UPDATE users SET name=?, password=?, role=?, house=? WHERE email=?"
                );
                update.setString(1, nameField.getText());
                update.setString(2, passwordField.getText());
                update.setString(3, (String) roleCombo.getSelectedItem());
                update.setString(4, (String) houseCombo.getSelectedItem());
                update.setString(5, email);
                update.executeUpdate();

                JOptionPane.showMessageDialog(null, "Account updated!");
                loadUserData();
            }
        }

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

private void deleteUser(String email) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "jesonmysql");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE email = ?");
        stmt.setString(1, email);
        stmt.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "Account deleted.");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting account: " + e.getMessage());
    }
}


private void loadAttendanceSummary() {
    viewAttendance.removeAll();
    viewAttendance.setLayout(new BorderLayout());

    String[] columns = {"Event", "Date", "Attendance"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    JTable attendanceTable = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(attendanceTable);
    attendanceTable.setRowHeight(30);

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
            "root", "jesonmysql"
        );

        // Get the user's house
        String userHouse = LoginUserSession.house;  // Make sure this is set at login

        String query = """
            SELECT e.event_id, e.event_name, e.event_date,
                (SELECT COUNT(*) FROM event_attendance ea 
                    JOIN users u ON ea.user_id = u.user_id 
                    WHERE ea.event_id = e.event_id AND u.house = ?) AS attendees,
                (SELECT COUNT(*) FROM users u WHERE u.role = 'student' AND u.house = ?) AS total_members
            FROM events e
            ORDER BY e.event_date DESC
        """;

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, userHouse);
        stmt.setString(2, userHouse);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String eventName = rs.getString("event_name");
            String eventDate = rs.getString("event_date");
            int attendees = rs.getInt("attendees");
            int total = rs.getInt("total_members");

            model.addRow(new Object[]{
                eventName,
                eventDate,
                attendees + " / " + total
            });
        }

        conn.close();
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = attendanceTable.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            String eventName = attendanceTable.getValueAt(row, 0).toString();
            showAttendanceModal(eventName);
        }
    }
});

        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading attendance: " + e.getMessage());
    }

    viewAttendance.add(scrollPane, BorderLayout.CENTER);
    viewAttendance.revalidate();
    viewAttendance.repaint();
}

private void showAttendanceModal(String eventName) {
    JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Attendance for: " + eventName, true);
    dialog.setLayout(new BorderLayout());

    String[] columns = {"Student Name", "Email", "Status"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    JTable table = new JTable(model);

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL",
                "root", "jesonmysql"
        )) {
            String sql = """
                                         SELECT u.name, u.email, ea.status
                                         FROM event_attendance ea
                                         JOIN users u ON u.user_id = ea.user_id
                                         JOIN events e ON e.event_id = ea.event_id
                                         WHERE e.event_name = ? AND u.house = ?
                                     """;
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eventName);
            stmt.setString(2, LoginUserSession.house); // ensure this is set
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("status")
                });
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching attendees: " + e.getMessage());
    }

    JScrollPane scrollPane = new JScrollPane(table);
    dialog.add(scrollPane, BorderLayout.CENTER);

    // Add a print button
    JButton printBtn = new JButton("Print Attendance");
    printBtn.addActionListener(e -> {
        try {
            boolean complete = table.print();
            if (complete) {
                JOptionPane.showMessageDialog(dialog, "Printing Complete!");
            } else {
                JOptionPane.showMessageDialog(dialog, "Printing Cancelled");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(dialog, "Print Error: " + ex.getMessage());
        }
    });

    JPanel bottomPanel = new JPanel();
    bottomPanel.add(printBtn);
    dialog.add(bottomPanel, BorderLayout.SOUTH);

    dialog.setSize(600, 400);
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}

private void loadDashboardData() {
    dash.removeAll(); // Clear panel
    dash.setLayout(new BorderLayout());

    // Title
    JLabel titleLabel = new JLabel("Upcoming Events");
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
    titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    dash.add(titleLabel, BorderLayout.NORTH);

    // Table
    String[] columns = {"Event Name", "Date", "Time", "Status"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    upcomingEventsTable = new JTable(model);
    upcomingEventsTable.setRowHeight(28);
    JScrollPane tableScroll = new JScrollPane(upcomingEventsTable);
    dash.add(tableScroll, BorderLayout.CENTER);

    // Bottom Panel with Stats and Notifications
    JPanel bottomPanel = new JPanel(new BorderLayout());

    JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    eventsAttendedLabel = new JLabel("0");
    eventsAttendedLabel.setForeground(Color.GREEN);
    penaltiesLabel = new JLabel("0");
    penaltiesLabel.setForeground(Color.RED);

    statsPanel.add(new JLabel("Total Events Attended: "));
    statsPanel.add(eventsAttendedLabel);
    statsPanel.add(Box.createHorizontalStrut(20));
    statsPanel.add(new JLabel("Total Penalties: "));
    statsPanel.add(penaltiesLabel);

    bottomPanel.add(statsPanel, BorderLayout.NORTH);

    notificationsArea = new JTextArea(5, 40);
    notificationsArea.setEditable(false);
    JScrollPane notifScroll = new JScrollPane(notificationsArea);
    notifScroll.setBorder(BorderFactory.createTitledBorder("Notifications"));
    bottomPanel.add(notifScroll, BorderLayout.CENTER);

    dash.add(bottomPanel, BorderLayout.SOUTH);

    // Load data from DB
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_event_db?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "jesonmysql")) {
        String query = """
                SELECT e.event_name, e.event_date, e.start_time,
                    IF(ea.user_id IS NOT NULL, 'Attended',
                    IF(CURDATE() > e.event_date, 'Missed', 'Upcoming')) AS status
                FROM events e
                LEFT JOIN event_attendance ea ON ea.event_id = e.event_id AND ea.user_id = ?
                WHERE e.event_date >= CURDATE()  -- ✅ Show only today and future events
                ORDER BY e.event_date ASC
            """;

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, LoginUserSession.userId);
        ResultSet rs = stmt.executeQuery();

        int attended = 0, penalties = 0;
        model.setRowCount(0);
        notificationsArea.setText("");

        while (rs.next()) {
            String name = rs.getString("event_name");
            String date = rs.getString("event_date");
            String time = rs.getString("start_time");
            String status = rs.getString("status");

            model.addRow(new Object[]{name, date, time, status});

            if ("Attended".equals(status)) attended++;
            else if ("Missed".equals(status)) {
                penalties++;
                notificationsArea.append("• " + name + " - Penalty Pending\n");
            }
        }

        eventsAttendedLabel.setText(String.valueOf(attended));
        penaltiesLabel.setText(String.valueOf(penalties));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading dashboard: " + e.getMessage());
    }

    dash.revalidate();
    dash.repaint();
}


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlLoaderUtility;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tapaswi
 */
public class Dashboard extends javax.swing.JFrame {

    private Connection con;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private List<String> listOfTables;
    private DatabaseMetaData databaseMetaData;
    private File controlFile;
    private File logDirectory;
    private String pass;
    private DefaultListModel<String> listModel;

    public Dashboard() {
        initComponents();
    }
    public Dashboard(Connection con, String password) throws SQLException {
        initComponents();
        setResizable(false);
        this.con = con;
        getTableList();
        databaseMetaData = con.getMetaData();
        this.setTitle("Sql Loader Utility");
        lblUserName.setText("User: " + databaseMetaData.getUserName());
        jTabbedPane1.setFocusable(true);
        this.pass = password;
        getRecords(listOfTables.get(0));
        jListTable.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListTable = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelTable = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelInsert = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnControlFile = new javax.swing.JButton();
        lblControlFile = new javax.swing.JLabel();
        btnLoadData = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        btnLogFile = new javax.swing.JButton();
        lblLogDirectory = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListTable.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListTableValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListTable);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Table", jPanelTable);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Select control file");

        btnControlFile.setText("Choose File");
        btnControlFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlFileActionPerformed(evt);
            }
        });

        lblControlFile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnLoadData.setText("Load Data");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Output", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        txtOutput.setEditable(false);
        txtOutput.setBorder(null);
        jScrollPane4.setViewportView(txtOutput);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Select directory for log file");

        btnLogFile.setText("Choose Directory");
        btnLogFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogFileActionPerformed(evt);
            }
        });

        lblLogDirectory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Choose the control file and destination for log file");

        javax.swing.GroupLayout jPanelInsertLayout = new javax.swing.GroupLayout(jPanelInsert);
        jPanelInsert.setLayout(jPanelInsertLayout);
        jPanelInsertLayout.setHorizontalGroup(
            jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInsertLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInsertLayout.createSequentialGroup()
                            .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInsertLayout.createSequentialGroup()
                                    .addComponent(btnLogFile)
                                    .addGap(30, 30, 30)
                                    .addComponent(lblLogDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInsertLayout.createSequentialGroup()
                                    .addComponent(btnControlFile)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblControlFile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanelInsertLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addComponent(btnLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanelInsertLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6))
        );
        jPanelInsertLayout.setVerticalGroup(
            jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnControlFile)
                        .addComponent(jLabel1))
                    .addComponent(lblControlFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogFile)
                        .addComponent(jLabel3))
                    .addComponent(lblLogDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnLoadData)
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sql Loader", jPanelInsert);

        lblUserName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 204, 0));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setText("USER");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Database Tables");

        jMenu3.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Create Table");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Truncate table");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Drop Table");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem2.setText("Log Out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //============================================================
    //Event for value selection when value gets changed
    //============================================================
    private void jListTableValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListTableValueChanged
        // TODO add your handling code here:
        // This if condition is for avoiding to get value twice
        if (!evt.getValueIsAdjusting()) {
            String tableName = jListTable.getSelectedValue();
            getRecords(tableName);
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jListTableValueChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TableCreation createTableScreen = new TableCreation(con,pass);
        createTableScreen.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out ?");
        if (input == JOptionPane.YES_OPTION) {
            try {
                con.close();
                con = null;
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
                this.dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnLogFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogFileActionPerformed
        JFileChooser directoryChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        directoryChooser.setDialogTitle("Select directory");
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.showDialog(this, "Select");

        if(directoryChooser.getSelectedFile() != null){
            lblLogDirectory.setText(directoryChooser.getSelectedFile().getName());
            logDirectory = directoryChooser.getSelectedFile();
        }
    }//GEN-LAST:event_btnLogFileActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        if (controlFile != null && logDirectory != null) {
            insert(controlFile,logDirectory);
            getRecords(listOfTables.get(0));
        } else {
            JOptionPane.showMessageDialog(null, "Please select the file and directory", "File Not Selected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnControlFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlFileActionPerformed
        JFileChooser controlFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        controlFileChooser.setDialogTitle("Select control file");
        controlFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        controlFileChooser.setAcceptAllFileFilterUsed(false);
        controlFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".ctl", "ctl"));
        controlFileChooser.showDialog(this, "Select");

        if (controlFileChooser.getSelectedFile() != null) {
            lblControlFile.setText(controlFileChooser.getSelectedFile().getName());
            controlFile = controlFileChooser.getSelectedFile();
        }
    }//GEN-LAST:event_btnControlFileActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JDialog dialog = new JDialog(this,"Drop Table");
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Select table to drop");
        panel.setLayout(null);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(150, 10, 200, 30);
        panel.add(label);
        
        JComboBox comboBox = new JComboBox(listModel.toArray());
        comboBox.setBounds(170, 60, 100, 20);
        panel.add(comboBox);
        
        JButton button = new JButton("Drop");
        button.setBounds(170, 100, 70, 20);
        button.addActionListener((ActionEvent ae) -> {
            int retVal = JOptionPane.showConfirmDialog(null, "Confirmation for dropping table "+comboBox.getSelectedItem()
                    , "Confirmation", JOptionPane.YES_NO_OPTION);
            if (retVal == JOptionPane.YES_OPTION) {
                try {
                    Statement st1 = con.createStatement();
                    st1.execute("DROP TABLE "+comboBox.getSelectedItem()+"");
                    getTableList();
                    dialog.dispose();
                    JOptionPane.showMessageDialog(null, "Table dropped");
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(button);
        
        
        dialog.add(panel);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JDialog dialog = new JDialog(this,"Truncate Table");
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Select table to truncate");
        panel.setLayout(null);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(150, 10, 200, 30);
        panel.add(label);
        
        JComboBox comboBox = new JComboBox(listModel.toArray());
        comboBox.setBounds(170, 60, 100, 20);
        panel.add(comboBox);
        
        JButton button = new JButton("Truncate");
        button.setBounds(170, 100, 80, 20);
        button.addActionListener((ActionEvent ae) -> {
            int retVal = JOptionPane.showConfirmDialog(null, "Confirmation for truncating table "+comboBox.getSelectedItem()
                    , "Confirmation", JOptionPane.YES_NO_OPTION);
            if (retVal == JOptionPane.YES_OPTION) {
                try {
                    Statement st1 = con.createStatement();
                    st1.execute("TRUNCATE TABLE "+comboBox.getSelectedItem()+"");
                    getRecords(comboBox.getSelectedItem().toString());
                    dialog.dispose();
                    JOptionPane.showMessageDialog(null, "Table truncated");
                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(button);
        
        dialog.add(panel);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

//=========================================================
//    Sql Loader functionality for inserting records
//=========================================================
    private void insert(File controlFile, File logDirectory) {
        try {
            String nameWithExtension = controlFile.getName();
            String name = nameWithExtension.substring(0, nameWithExtension.lastIndexOf("."));
            
            String command = "sqlldr "+databaseMetaData.getUserName()+"/"+pass+" "
                    + "control='" + controlFile.getPath() + "'"
                    + " log='"+logDirectory.getPath()+"\\"+name+".log'";
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line, output = "";

            while ((line = reader.readLine()) != null) {
                output +=line + "\n";
            }
            txtOutput.setText(output);
            
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //==============================================================
    // Method to retrieve all the records of a selected table
    //==============================================================
    private void getRecords(String tableName) {
        try {
            ResultSet rsLocal = con.prepareStatement("SELECT * FROM " + tableName).executeQuery();
            ResultSetMetaData metaData = rsLocal.getMetaData();

            int columnCount = metaData.getColumnCount();
            String columnNames[] = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(columnNames);

            Object[] arr;
            while (rsLocal.next()) {
                arr = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    arr[i - 1] = rsLocal.getObject(i);
                }
                tableModel.addRow(arr);
            }

            jTable1.setModel(tableModel);
        } catch (SQLException e) {
            if(e.getErrorCode() != 903){ //Checking for particular error
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    
    //=============================================================
    //      Method for retrieving tables of current user
    //=============================================================
    private void getTableList() {
        try {
            ps = con.prepareStatement("SELECT * FROM USER_TABLES");
            rs = ps.executeQuery();
            listOfTables = new ArrayList<>();
            while (rs.next()) {
                listOfTables.add(rs.getString(1));
            }
            listModel = new DefaultListModel<>();
            listOfTables.forEach((str) -> {
                listModel.addElement(str);
            });
            jListTable.setModel(listModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new LoginForm().setVisible(true);
//        });
//
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnControlFile;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnLogFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInsert;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblControlFile;
    private javax.swing.JLabel lblLogDirectory;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextPane txtOutput;
    // End of variables declaration//GEN-END:variables
}

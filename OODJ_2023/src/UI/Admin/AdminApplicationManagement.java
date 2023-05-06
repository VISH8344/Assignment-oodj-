/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Admin;

import Controller.ApplicationController;
import Model.Application;
import Model.Enum.ApplicationStatus;
import UI.WelcomePage;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 */
public class AdminApplicationManagement extends javax.swing.JFrame {

    private ArrayList<Application> applications = new ArrayList<>();

    private static ApplicationStatus status;
    private static AdminApplicationManagement applicationManagementUI;

    public static AdminApplicationManagement activateUI() {
        if (AdminApplicationManagement.applicationManagementUI == null) {
            AdminApplicationManagement.applicationManagementUI = new AdminApplicationManagement();
        }
        return AdminApplicationManagement.applicationManagementUI;
    }

    /**
     * Creates new form Template
     */
    public AdminApplicationManagement() {
        initComponents();
        setLocationRelativeTo(null);

        // get data and generate card component
        resetApplications();
        generateApplicationCard();

        // set initial data
        typeTitleLabel.setText("ALL");
    }

    private void generateApplicationCard() {
        JPanel panel = new JPanel();
        int height = 130 * applications.size();
        panel.setPreferredSize(new Dimension(843, height));

        applications.forEach(ap -> {
            ApplicationCard application = new ApplicationCard(ap);
            panel.add(application);
        });
        applicationCardScrollPane.getViewport().add(panel);
    }

    public void resetApplications() {
        if (status == null) {
            this.applications = ApplicationController.ActivateApplicationController().getApplications();
        } else {
            switch (status) {
                case APPROVED -> applications = ApplicationController.ActivateApplicationController().getApprovedApplications();
                case REJECTED -> applications = ApplicationController.ActivateApplicationController().getRejectedApplications();
                case PENDING -> applications = ApplicationController.ActivateApplicationController().getPendingApplications();
                default -> {
                }
            }
        }
        generateApplicationCard();
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
        logoutBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        applicationCardScrollPane = new javax.swing.JScrollPane();
        pendingFilterBtn = new javax.swing.JButton();
        approvedFilterBtn = new javax.swing.JButton();
        rejectedFilterBtn = new javax.swing.JButton();
        dateTimeArrangeBtn = new javax.swing.JButton();
        typeTitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 255, 255));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(855, 560));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        logoutBtn.setBackground(new java.awt.Color(153, 255, 255));
        logoutBtn.setForeground(new java.awt.Color(0, 0, 0));
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Application Management");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        backBtn.setBackground(new java.awt.Color(255, 204, 204));
        backBtn.setForeground(new java.awt.Color(0, 0, 0));
        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        applicationCardScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        applicationCardScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pendingFilterBtn.setText("Pending");
        pendingFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingFilterBtnActionPerformed(evt);
            }
        });

        approvedFilterBtn.setText("Approved");
        approvedFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvedFilterBtnActionPerformed(evt);
            }
        });

        rejectedFilterBtn.setText("Rejected");
        rejectedFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectedFilterBtnActionPerformed(evt);
            }
        });

        dateTimeArrangeBtn.setBackground(new java.awt.Color(204, 255, 204));
        dateTimeArrangeBtn.setForeground(new java.awt.Color(0, 0, 0));
        dateTimeArrangeBtn.setText("DateTime <-->");
        dateTimeArrangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTimeArrangeBtnActionPerformed(evt);
            }
        });

        typeTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        typeTitleLabel.setForeground(new java.awt.Color(51, 51, 51));
        typeTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeTitleLabel.setText("[Type]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pendingFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(approvedFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rejectedFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateTimeArrangeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(applicationCardScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeTitleLabel)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pendingFilterBtn)
                    .addComponent(approvedFilterBtn)
                    .addComponent(rejectedFilterBtn)
                    .addComponent(dateTimeArrangeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applicationCardScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        WelcomePage wp = new WelcomePage();
        wp.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AdminHomePage ahp = new AdminHomePage();
        ahp.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void pendingFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingFilterBtnActionPerformed
        // TODO add your handling code here:
        typeTitleLabel.setText("Pending applications");
        status = ApplicationStatus.PENDING;
        resetApplications();
    }//GEN-LAST:event_pendingFilterBtnActionPerformed

    private void approvedFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvedFilterBtnActionPerformed
        // TODO add your handling code here
        typeTitleLabel.setText("Approved applications");
        status = ApplicationStatus.APPROVED;
        resetApplications();
    }//GEN-LAST:event_approvedFilterBtnActionPerformed

    private void rejectedFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectedFilterBtnActionPerformed
        // TODO add your handling code here:
        typeTitleLabel.setText("Rejected applications");
        status = ApplicationStatus.REJECTED;
        resetApplications();
    }//GEN-LAST:event_rejectedFilterBtnActionPerformed

    private void dateTimeArrangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTimeArrangeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTimeArrangeBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminApplicationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminApplicationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminApplicationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminApplicationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminApplicationManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane applicationCardScrollPane;
    private javax.swing.JButton approvedFilterBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton dateTimeArrangeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton pendingFilterBtn;
    private javax.swing.JButton rejectedFilterBtn;
    private javax.swing.JLabel typeTitleLabel;
    // End of variables declaration//GEN-END:variables
}

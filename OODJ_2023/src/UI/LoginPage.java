/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import UI.Student.MainPage;
import Model.Enum.UserRole;
import Model.Student;
import Student.Booking_DataIO;
import Student.Student_DataIO;
import javax.swing.JOptionPane;
import oodj_2023.OODJ_2023;
import static oodj_2023.OODJ_2023.rp;

/**
 *
 * @author peterdash
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage(UserRole role) {
        initComponents();
        String roleName = role.name().substring(0, 1).toUpperCase() + role.name().substring(1).toLowerCase();
        loginTitle.setText(roleName + " Login");
        Booking_DataIO.read();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginpage = new javax.swing.JPanel();
        loginTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uname_field = new javax.swing.JTextField();
        pass_field = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        register_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginpage.setBackground(new java.awt.Color(102, 255, 255));

        loginTitle.setText("Student Login");

        jLabel2.setText("username:");

        uname_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uname_fieldActionPerformed(evt);
            }
        });

        jLabel3.setText("password:");

        backBtn.setText("back");

        loginBtn.setText("login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("No Account? Register Here!");

        register_btn.setText("Register");
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginpageLayout = new javax.swing.GroupLayout(loginpage);
        loginpage.setLayout(loginpageLayout);
        loginpageLayout.setHorizontalGroup(
            loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpageLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginpageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(uname_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(pass_field, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(loginpageLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(loginBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(loginpageLayout.createSequentialGroup()
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginpageLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(register_btn))
                    .addGroup(loginpageLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(loginTitle)))
                .addGap(0, 64, Short.MAX_VALUE))
        );
        loginpageLayout.setVerticalGroup(
            loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginpageLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(loginTitle)
                .addGap(27, 27, 27)
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(uname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(loginBtn))
                .addGap(31, 31, 31)
                .addGroup(loginpageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(register_btn))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginpage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginpage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(358, 318));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uname_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uname_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uname_fieldActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        try{
        String student_uname = uname_field.getText();
        String student_pass = pass_field.getText();
        
        Student found = Student_DataIO.checkusername(student_uname);
        
        if (student_uname.isEmpty() || student_pass.isEmpty()) {
                throw new Exception();

            } else {
                if (found != null && student_pass.equals(found.getPassword())) {
//                    OODJ_2023.studentlogin = found;
                    JOptionPane.showMessageDialog(loginpage,"Login Successful!");
                    uname_field.setText("");
                    pass_field.setText("");
                    this.setVisible(false);
                    MainPage mp = new MainPage();
                    mp.setVisible(true);
                } else {
                    throw new Exception();
                }
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(loginpage,
                    "Please ensure that you have entered your username and password correctly.");

        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
        rp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_register_btnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JPanel loginpage;
    private javax.swing.JPasswordField pass_field;
    private javax.swing.JButton register_btn;
    private javax.swing.JTextField uname_field;
    // End of variables declaration//GEN-END:variables
}

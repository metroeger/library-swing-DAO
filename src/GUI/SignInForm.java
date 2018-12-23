package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import javafx.scene.paint.Color;
import javax.swing.JPasswordField;
import model.Client;

public class SignInForm extends javax.swing.JDialog {

    private boolean isEmpty;
    private boolean cancel;
    private boolean username;
    private boolean password;
    private String s;
    private JPasswordField jpf = new JPasswordField("");
    private Color color = Color.GREENYELLOW;
    
   

    public SignInForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(new Dimension(600, 300));
        //this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setLocationRelativeTo(null);
        

        isEmpty = true;  
        cancel = false;
        username = false;
        password = false;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUserName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        pfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 200));
        setSize(new java.awt.Dimension(400, 200));

        jLabel1.setText("Username: ");

        jLabel2.setText("Password: ");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSignIn.setText("Save");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        pfPassword.setText("jPasswordField1");
        pfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPLayout = new javax.swing.GroupLayout(pP);
        pP.setLayout(pPLayout);
        pPLayout.setHorizontalGroup(
            pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pPLayout.createSequentialGroup()
                            .addComponent(btnCancel)
                            .addGap(18, 18, 18)
                            .addComponent(btnSignIn))
                        .addGroup(pPLayout.createSequentialGroup()
                            .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUserName)
                                .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(70, Short.MAX_VALUE)))
        );
        pPLayout.setVerticalGroup(
            pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
            .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pPLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(pPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnSignIn))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
        cancel = true;
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        String u = tfUserName.getText();
         
        System.out.println(password);
        if (u.length()>0){
          username = true; 
          //System.out.println(u.length());

        }
        if (username && password){
            isEmpty();
            setVisible(false);
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void pfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPasswordActionPerformed
        JPasswordField field = (JPasswordField) evt.getSource();
        pP.add(field);
        char[] pass = field.getPassword();
        //field.getText();
 
        if (field.getText().length() <1) {
            System.out.println("Password can't be emtpty!");
        }else{
            password = true;
        }

//        s =  evt.getActionCommand();
//        if (s.length()>0){
//            password = true;
//        }
    }//GEN-LAST:event_pfPasswordActionPerformed

    
    public boolean isEmpty() {
        if (username && password){
            this.setVisible(false);
            return true;
        }else{
            return false;
        }
    }
    public boolean isCancel() {
        return cancel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pP;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}


package GUI;

import javax.swing.JOptionPane;
import model.Author;

public class AuthorForm extends javax.swing.JDialog {

    private Author author;
    private boolean save;
  
    public AuthorForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(parent);

        save = false;

        setTitle("Add new author");
  
    }
    
    public Author getAuthor(){
        return author;
    }
    public boolean isSave(){
        return save;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 74, 58, 0);
        getContentPane().add(btnCancel, gridBagConstraints);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 63, 58, 0);
        getContentPane().add(btnSave, gridBagConstraints);

        jLabel1.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 12, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        tfName.setBackground(new java.awt.Color(255, 255, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 386;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 18, 0, 12);
        getContentPane().add(tfName, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      // try {
            save = true;
            author = new Author();
            author.setName(tfName.getText());
        
            setVisible(false);

//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(rootPane, ex, "Hibas adat", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnSaveActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}

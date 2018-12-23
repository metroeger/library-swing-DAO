package GUI;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.IModel;
import model.Client;

public class ClientD extends javax.swing.JDialog {

    private IModel model;
    private java.awt.Frame parent;

    private void refreshList() {
        try {
            List<Client> clients = model.getAllClient();
            listClient.setListData(clients.toArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ClientD(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        setTitle("Clients");

        this.model = model;
        this.parent = parent;

        refreshList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listClient = new javax.swing.JList<>();
        btnNew = new javax.swing.JButton();
        btnModosit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listClient.setBackground(new java.awt.Color(204, 255, 204));
        listClient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listClient.setForeground(new java.awt.Color(0, 153, 153));
        listClient.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "items..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listClient);

        btnNew.setText("New Client");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnModosit.setText("Edit");
        btnModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModositActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModosit)
                    .addComponent(btnDelete)
                    .addComponent(btnOK)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnModosit, btnNew, btnOK});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnModosit)
                        .addGap(26, 26, 26)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Client selected = (Client) listClient.getSelectedValue();
        if (selected != null) {
            int answer = JOptionPane.showConfirmDialog(rootPane, "Sure, you wanna delete it? " + selected,
                    "Confirmation [delete]", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                try {
                    model.removeClient(selected);
                    refreshList();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a client to delete", "Selection error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModositActionPerformed
       Client selected = (Client) listClient.getSelectedValue();
   
        if (selected != null) {
            
        ClientForm cForm = new ClientForm(parent, true, selected);
        cForm.setVisible(true);
        
            if (cForm.isSave()) {
                try {
                    model.updateClient(selected);
                    refreshList();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a client to edit", "Selection error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnModositActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ClientForm cForm = new ClientForm(parent, true, null);
        cForm.setVisible(true);

        if (cForm.isSave()) {
            Client client = cForm.getClient();
            try {
                model.addClient(client);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
            }
            refreshList();

        }
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Object> listClient;
    // End of variables declaration//GEN-END:variables
}

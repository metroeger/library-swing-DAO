package GUI;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.IModel;
import model.Author;
import model.Book;
import model.Client;

public class SearchByClientD extends javax.swing.JDialog {

    private Client client;
    private IModel model;
    private boolean isAv = false;
    private List<Client> clients;
    
    
    private Client searchClient(String name){
        try{
        client = model.findClientByName(name);
        }catch(SQLException ex){
          JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE); 
        }
        return client;
    }

    private void refreshList() {
        try {
            List<Book> booksOfClient = model.getAllBook(client);
            listBook.setListData(booksOfClient.toArray());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private List<Client> clientList(){
        try{
        clients = model.getAllClient();
         }catch(SQLException ex){
          JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE); 
        }
        return clients;
    }

    public SearchByClientD(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);
        setTitle("Clients: ");

        this.model = model;
        this.clients = clientList();
        comboClients.setModel(new DefaultComboBoxModel<>(clients.toArray()));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBook = new javax.swing.JList<>();
        btnOk = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        tfSearchClientByName = new javax.swing.JTextField();
        lblSearchauthor = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        comboClients = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listBook.setBackground(new java.awt.Color(207, 252, 252));
        listBook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 255, 255)));
        listBook.setEnabled(false);
        jScrollPane1.setViewportView(listBook);

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jProgressBar1.setForeground(new java.awt.Color(0, 153, 153));

        tfSearchClientByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchClientByNameActionPerformed(evt);
            }
        });
        tfSearchClientByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchClientByNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSearchClientByNameKeyTyped(evt);
            }
        });

        lblSearchauthor.setText("Search client by name: ");

        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        comboClients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clients" }));
        comboClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblSearchauthor)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboClients, 0, 195, Short.MAX_VALUE)
                            .addComponent(tfSearchClientByName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(227, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(147, 147, 147)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(comboClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSearchClientByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearchauthor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String name = tfSearchClientByName.getText();
        searchClient(name);
        if (client!=null){
            refreshList();
        }else{
             JOptionPane.showMessageDialog(rootPane, "Ooops, couldn't find this client, try again!",
                    "No client message", JOptionPane.INFORMATION_MESSAGE);
             tfSearchClientByName.setText("");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tfSearchClientByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchClientByNameActionPerformed
    }//GEN-LAST:event_tfSearchClientByNameActionPerformed

    private void tfSearchClientByNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchClientByNameKeyTyped
        refreshList();
    }//GEN-LAST:event_tfSearchClientByNameKeyTyped

    private void tfSearchClientByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchClientByNameKeyReleased
        refreshList();
    }//GEN-LAST:event_tfSearchClientByNameKeyReleased

    private void comboClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientsActionPerformed
       client = (Client)comboClients.getSelectedItem();
       refreshList();

    }//GEN-LAST:event_comboClientsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<Object> comboClients;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchauthor;
    private javax.swing.JList<Object> listBook;
    private javax.swing.JTextField tfSearchClientByName;
    // End of variables declaration//GEN-END:variables
}

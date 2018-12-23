
package GUI;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Author;
import model.Book;
import model.Client;
import model.IModel;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookSearchD extends javax.swing.JDialog {

      private IModel model;
      //private java.awt.Frame parent;
      private boolean isAv = false;
            
    private void refreshList() {
        try {
            List<Book> availableBooks = model.getAllBook();
            listBook.setListData(availableBooks.toArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
       private void refreshListAvailable() {
        try {
            List<Book> availableBooks = model.getAllAvailableBook();
            listBook.setListData(availableBooks.toArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public BookSearchD(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        
        setLocationRelativeTo(null);
        setTitle("Books books boooooks: ");

        this.model = model;
        //this.parent = parent;

        refreshList();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBook = new javax.swing.JList<>();
        btnOk = new javax.swing.JButton();
        cbAvailable = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listBook.setBackground(new java.awt.Color(255, 255, 204));
        listBook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listBook.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "books..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listBook);

        btnOk.setBackground(new java.awt.Color(255, 102, 51));
        btnOk.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnOk.setText("OK");
        btnOk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        cbAvailable.setText("only available");
        cbAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAvailableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cbAvailable)
                .addGap(111, 111, 111)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(cbAvailable))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
       setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed

    private void cbAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAvailableActionPerformed
        if (!isAv){
        refreshListAvailable();
        isAv = !isAv;
        }else{
            refreshList();
             isAv = !isAv;
        }
    }//GEN-LAST:event_cbAvailableActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JCheckBox cbAvailable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Object> listBook;
    // End of variables declaration//GEN-END:variables
}

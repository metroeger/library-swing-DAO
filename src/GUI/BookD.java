package GUI;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.IModel;
import model.Book;
import model.Client;
import model.Author;

public class BookD extends javax.swing.JDialog {

    private IModel model;
    private java.awt.Frame parent;
    
        private void refreshList(){
        try {
            List<Book> books = model.getAllBook();
            listBooks.setListData(books.toArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        } 
    }

    public BookD(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();
        
        //isSave = false;

        setLocationRelativeTo(parent);
        this.model = model;
        this.parent = parent;

        refreshList();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBooks = new javax.swing.JList<>();
        btnNew = new javax.swing.JButton();
        btnModosit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        listBooks.setBackground(new java.awt.Color(232, 240, 237));
        listBooks.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listBooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listBooks.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Books..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listBooks);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 23, 560, 450);

        btnNew.setText("Add book");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew);
        btnNew.setBounds(630, 30, 146, 25);

        btnModosit.setText("Edit");
        btnModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModositActionPerformed(evt);
            }
        });
        getContentPane().add(btnModosit);
        btnModosit.setBounds(630, 70, 146, 25);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(630, 120, 146, 25);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK);
        btnOK.setBounds(630, 500, 146, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agi\\Desktop\\maxresdefault.jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(2280, 1720));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -110, 1000, 940);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        BookForm bForm = new BookForm(parent, true, null);
        bForm.setVisible(true);

        if (bForm.isSave()) {
            Book book = bForm.getBook();
            try {
                model.addBook(book);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
            }
            refreshList();

        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModositActionPerformed
        Book selected = (Book) listBooks.getSelectedValue();

        if (selected != null) {

            BookForm bForm = new BookForm(parent, true, selected);
            bForm.setVisible(true);

            if (bForm.isSave()) {
                try {
                    model.updateBook(selected);
                    refreshList();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a book to edit", "Selection error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnModositActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Book selected = (Book) listBooks.getSelectedValue();
        if (selected != null) {
            int answer = JOptionPane.showConfirmDialog(rootPane, "Sure, you wanna delete it? " + selected,
                "Confirmation [delete]", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                try {
                    model.removeBook(selected);
                    refreshList();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a book to delete", "Selection error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Object> listBooks;
    // End of variables declaration//GEN-END:variables
}

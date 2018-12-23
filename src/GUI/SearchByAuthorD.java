package GUI;

import java.awt.Color;
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

public class SearchByAuthorD extends javax.swing.JDialog {

    private Author author;
    private IModel model;
    private boolean isAv = false;
    
    private Author searchAuthor(String name){
        try{
        author = model.findAuthorByName(name);
        }catch(SQLException ex){
          JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE); 
        }
        return author;
    }

    private void refreshList() {
        try {
            List<Book> booksOfAuthor = model.getAllBook(author);
            listBook.setListData(booksOfAuthor.toArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshListAvailable() {
        try {
            List<Book> availableBooksOfAuthor = model.getAllAvailableBookOfAuthor(author);
            listBook.setListData(availableBooksOfAuthor.toArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }

//     private JComboBox<Author> myTitles ;
//     private void authorList() {
//        try {
//            List<Author> authors = model.getAllAuthor();
//           //cBoxAuthors.setModel(new DefaultComboBoxModel(authors.toArray()));
//            //cBoxAuthors=new JComboBox(authors.toArray());                                  
//            //cBoxAuthors.getSelectedItem();
//            //authors.sort(c);
//            for (Author a : authors) {
//                cBoxAuthors.addItem(a.getName());                
//            }           
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public SearchByAuthorD(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        setTitle("Start searching! ");
        
        this.model = model;
        tfSearchAuthor.setText("rejto");
        setBackground(Color.yellow);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBook = new javax.swing.JList<>();
        btnOk = new javax.swing.JButton();
        cbAvailable = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        tfSearchAuthor = new javax.swing.JTextField();
        lblSearchauthor = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();

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

        cbAvailable.setText("Search only available");
        cbAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAvailableActionPerformed(evt);
            }
        });

        jProgressBar1.setForeground(new java.awt.Color(0, 153, 153));

        lblSearchauthor.setText("Search author: ");

        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
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
                            .addComponent(cbAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSearchAuthor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearchauthor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAvailable)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String name = tfSearchAuthor.getText();
        searchAuthor(name);
        if (author!=null && isAv){
            refreshListAvailable();
        }else if (author!=null){
            refreshList();
        }else{
             JOptionPane.showMessageDialog(rootPane, "Ooops, couldn't find this author, try again!",
                    "No author", JOptionPane.INFORMATION_MESSAGE);
             tfSearchAuthor.setText("");
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox cbAvailable;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchauthor;
    private javax.swing.JList<Object> listBook;
    private javax.swing.JTextField tfSearchAuthor;
    // End of variables declaration//GEN-END:variables
}

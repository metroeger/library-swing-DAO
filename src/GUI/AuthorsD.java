package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableCell;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.IModel;
import model.Author;

public class AuthorsD extends javax.swing.JDialog implements TableModelListener {

    private IModel model;
    private java.awt.Frame parent;
    private DefaultTableModel dtm;
    private List<Author> authors;

    public DefaultTableModel dtm() {
        return (DefaultTableModel) tblAuthor.getModel();
    }

    private void refreshTable() {
        dtm();
        try {
            authors = model.getAllAuthor();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Adatbazis hiba", JOptionPane.ERROR_MESSAGE);
        }

        dtm.getDataVector().clear();

        for (Author a : authors) {
            Vector row = new Vector();
            row.add(a.getId());
            row.add(a.getName());
            dtm.addRow(row);
        }
        dtm.fireTableDataChanged();
    }

    public AuthorsD(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);
        setTitle("Authors");

        this.model = model;
        this.parent = parent;

        dtm = (DefaultTableModel) tblAuthor.getModel();
        dtm.addTableModelListener(this);

        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAuthor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agi\\Desktop\\jd-salinger.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        btnNew.setText("New Author");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
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

        tblAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153)));
        tblAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAuthor);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1074, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOK)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnOK});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnNew)
                        .addGap(34, 34, 34)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            AuthorForm af = new AuthorForm(parent, true);
            af.setVisible(true); // modalis dialogus, ezert a kod tobbi resze csak a kilepes/becsukas utan fut le: 

            if (af.isSave()) {

                Author newAuthor = af.getAuthor();
                model.addAuthor(newAuthor);
                refreshTable();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Adatbazis hiba", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int tableRowIndex = tblAuthor.getSelectedRow();

        if (tableRowIndex > -1) {
            Author selected = (Author) authors.get(tableRowIndex);

            int answer = JOptionPane.showConfirmDialog(rootPane, "Sure, you wanna delete it? " + selected,
                    "Confirmation [delete]", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                try {
                    model.removeAuthor(selected);
                    refreshTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAuthor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
        dtm();
        int rowIndex = e.getFirstRow();
        int colIndex = e.getColumn();

        if (e.getType() == TableModelEvent.UPDATE && rowIndex >= 0 && colIndex >= 0) {

            Object newValue = dtm.getValueAt(rowIndex, colIndex);
            Author author = authors.get(rowIndex);

            switch (colIndex) {
                case 1:
                    author.setName((String) newValue);

            }
            try {
                model.updateAuthor(author);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

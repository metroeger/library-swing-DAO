package GUI;

import java.awt.Color;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DBModel;
import model.IModel;

public class LibraryMain extends javax.swing.JFrame {

    private IModel model;
    //private boolean authenticated;

    public void exitProc() {
        if (model != null) {
            try {
                model.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "DataBaseError", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public LibraryMain() {

        initComponents();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitProc(); // separated method for better readability
                dispose(); // stop JFrame
                System.exit(0); // exit program
            }
        });

        mbMenuBar.setBackground(Color.BLUE);
        setLocationRelativeTo(null);
        setTitle("My Library v0.1"); // call on JFrame
        setSize(1200, 800);

        Connection conn;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("db_data.properties"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {

            conn = DriverManager.getConnection(
                    prop.getProperty("connURL"),
                    prop.getProperty("user"),
                    prop.getProperty("pass"));

            model = new DBModel(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "DB error", JOptionPane.ERROR_MESSAGE);
            System.out.println("3");
            System.exit(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAuthor = new javax.swing.JButton();
        btnAvailability = new javax.swing.JButton();
        btnSearchByClients = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mbMenuBar = new javax.swing.JMenuBar();
        miFiles = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();
        miLibraryItems = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miAuthors = new javax.swing.JMenuItem();
        miBooks = new javax.swing.JMenuItem();
        miClients = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        btnAuthor.setText("Search By Author");
        btnAuthor.setPreferredSize(new java.awt.Dimension(200, 80));
        btnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAuthor);
        btnAuthor.setBounds(42, 148, 200, 80);

        btnAvailability.setText("Search by availability");
        btnAvailability.setPreferredSize(new java.awt.Dimension(200, 80));
        btnAvailability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailabilityActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvailability);
        btnAvailability.setBounds(417, 148, 200, 80);

        btnSearchByClients.setText("Search by Clients");
        btnSearchByClients.setPreferredSize(new java.awt.Dimension(200, 80));
        btnSearchByClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByClientsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchByClients);
        btnSearchByClients.setBounds(801, 148, 200, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Agi\\Desktop\\8-Books-That-Will-Leave-You-Feeling-Amazing-And-On-Top-Of-The-World.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1320, 980);

        mbMenuBar.setBackground(new java.awt.Color(0, 153, 153));

        miFiles.setText("Files");

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        miFiles.add(miExit);

        mbMenuBar.add(miFiles);

        miLibraryItems.setBackground(new java.awt.Color(153, 255, 204));
        miLibraryItems.setForeground(new java.awt.Color(0, 153, 153));
        miLibraryItems.setText("ADMIN");
        miLibraryItems.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        miLibraryItems.add(jSeparator2);

        miAuthors.setText("Authors");
        miAuthors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuthorsActionPerformed(evt);
            }
        });
        miLibraryItems.add(miAuthors);

        miBooks.setText("Books");
        miBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBooksActionPerformed(evt);
            }
        });
        miLibraryItems.add(miBooks);

        miClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miClients.setText("Clients");
        miClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClientsActionPerformed(evt);
            }
        });
        miLibraryItems.add(miClients);
        miLibraryItems.add(jSeparator3);
        miLibraryItems.add(jSeparator1);

        mbMenuBar.add(miLibraryItems);

        setJMenuBar(mbMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBooksActionPerformed
        BookD bD = new BookD(this, true, model);
        bD.setVisible(true);
    }//GEN-LAST:event_miBooksActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void miClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClientsActionPerformed
        ClientD cd = new ClientD(this, true, model);
        cd.setVisible(true);

    }//GEN-LAST:event_miClientsActionPerformed

    private void miAuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuthorsActionPerformed
        AuthorsD ad = new AuthorsD(this, true, model);
        ad.setVisible(true);
    }//GEN-LAST:event_miAuthorsActionPerformed

    private void btnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthorActionPerformed
        SearchByAuthorD sbad = new SearchByAuthorD(this, true, model);
        sbad.setVisible(true);
    }//GEN-LAST:event_btnAuthorActionPerformed

    private void btnAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailabilityActionPerformed
        BookSearchD bs = new BookSearchD(this, true, model);
        bs.setVisible(true);
    }//GEN-LAST:event_btnAvailabilityActionPerformed

    private void btnSearchByClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByClientsActionPerformed
        SearchByClientD sbcd = new SearchByClientD(this, true, model);
        sbcd.setVisible(true);
    }//GEN-LAST:event_btnSearchByClientsActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibraryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryMain().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthor;
    private javax.swing.JButton btnAvailability;
    private javax.swing.JButton btnSearchByClients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar mbMenuBar;
    private javax.swing.JMenuItem miAuthors;
    private javax.swing.JMenuItem miBooks;
    private javax.swing.JMenuItem miClients;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenu miFiles;
    private javax.swing.JMenu miLibraryItems;
    // End of variables declaration//GEN-END:variables
}

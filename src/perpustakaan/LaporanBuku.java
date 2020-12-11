/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import report.fungsicetak;

/**
 *
 * @author Afdhol
 */
public class LaporanBuku extends javax.swing.JFrame {

    /**
     * Creates new form LaporanBuku
     */
    Koneksi koneksi1 = new Koneksi();
    public LaporanBuku() {
        initComponents();
        tampil();
        lebarKolom();
    }
public void tampil() {
        
    DefaultTableModel table1;
        table1 = new DefaultTableModel();
        table1.addColumn("ID BUKU");
        table1.addColumn("JUDUL BUKU");
        table1.addColumn("PENGARANG");
        table1.addColumn("PENERBIT");
        table1.addColumn("KATEGORI");
        table1.addColumn("TAHUN");
        jTable1.setModel(table1);
        try {
            ResultSet res = koneksi1.statement.executeQuery("Select*from tb_buku");
            while (res.next()){
                table1.addRow(new Object[]{
            res.getString("id_buku"),
            res.getString("judul"),
            res.getString("pengarang"),
            res.getString("penerbit"),
            res.getString("kategori"),
            res.getString("tahun"),
            
            
            });
                jTable1.setModel(table1);
            }
            
        }catch(Exception e){
        }
        }
public void lebarKolom(){ 
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(60);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(200); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(125); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(150); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(75);
        column = jTable1.getColumnModel().getColumn(5); 
        column.setPreferredWidth(70);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("SMP NEGERI 1 JATIROTO");

        jLabel2.setText("Jln. Jatiroto - Jatisrono, Jatiroto, Kec. Jatiroto, Kab. Wonogiri");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("LAPORAN DATA BUKU");

        jSeparator1.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Buku", "Judul buku", "Pengarang", "Penerbit", "Kategori", "Tahun Terbit"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_refresh.setText("REFRESH");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        btn_cetak.setText("CETAK");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jLabel3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_refresh)
                        .addGap(38, 38, 38)
                        .addComponent(btn_cetak))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refresh)
                    .addComponent(btn_cetak))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        tampil();
        lebarKolom();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed

        Connection con = null;
    try {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    Class.forName(jdbcDriver);

    String url = "jdbc:mysql://localhost/perpus"; 
    String user = "root";   
    String pass ="";    

    con = DriverManager.getConnection(url, user, pass);
    Statement stm = (Statement) con.createStatement();

    try {

    String path="src/report/ReportBuku.jasper";
    Map parameter = new HashMap();
    JasperPrint print = JasperFillManager.fillReport(path,parameter,stm.getConnection());
    JasperViewer.viewReport(print, false);
    } catch (Exception ex) {
    JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
    }

    } catch (Exception e) {
    System.out.println(e);
    }
    }//GEN-LAST:event_btn_cetakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LaporanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

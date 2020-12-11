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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Afdhol
 */
public class DataPengembalian extends javax.swing.JFrame {

    String pinjam;
    String kembali;   
    private String tgl_pinjam;
    private String tgl_kembali;
    Koneksi koneksi1 = new Koneksi();
    public DataPengembalian() {
        initComponents();
        kode_anggota();
        kode_buku();
        kode_pinjam();
        AutoNumber();
    }
    
     public void kode_buku(){
        try {
        Connection koneksi1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
        Statement stt = koneksi1.createStatement();
        String sql = "select id_buku from tb_buku";      
        ResultSet res = stt.executeQuery(sql);                                
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            cbb2.addItem(ob[0]);                                      
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void kode_anggota(){
        try {
        Connection koneksi1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
        Statement stt = koneksi1.createStatement();
        String sql = "select id_anggota from tb_anggota";      
        ResultSet res = stt.executeQuery(sql);                                
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            cbb3.addItem(ob[0]);                                      
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void kode_pinjam(){
        try {
        Connection koneksi1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
        Statement stt = koneksi1.createStatement();
        String sql = "select id_pinjam from tb_pinjam";      
        ResultSet res = stt.executeQuery(sql);                                
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            cbb1.addItem(ob[0]);                                      
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void tampil(){
        DefaultTableModel table1;
        table1 = new DefaultTableModel();
        table1.addColumn("ID KEMBALI");
        table1.addColumn("ID PINJAM");
        table1.addColumn("ID BUKU");
        table1.addColumn("ID ANGGOTA");
        table1.addColumn("TANGGAL PINJAM");
        table1.addColumn("TANGGAL KEMBALI");
        table1.addColumn("DENDA");
        //table1.addColumn("JUMLAH PINJAM");
        jTable1.setModel(table1);
        try {
            ResultSet res = koneksi1.statement.executeQuery("Select*from tb_kembali");
            while (res.next()){
                table1.addRow(new Object[]{
            res.getString("id_kembali"),
            res.getString("id_pinjam"),
            res.getString("id_buku"),
            res.getString("id_anggota"),
            res.getString("tgl_pinjam"),
            res.getString("tgl_kembali"),
            res.getString("denda"),
            //res.getString("jml_pinjam"),
            
            
            });
                jTable1.setModel(table1);
            }
        }catch(Exception e){
        }
        
    }
    
    private void AutoNumber(){
        
        try {
            Connection koneksi1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
            Statement st = koneksi1.createStatement();
            String sql = "select max(right(id_kembali,4)) as kode from tb_kembali";      
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String no_auto, nol_plus;
                int p; 
                no_auto = Integer.toString(res.getInt(1)+1);
                p = no_auto.length();
                nol_plus = "";
                for(int i=1;i<=4-p;i++){
                nol_plus = nol_plus +"0";
                }
                txt_id_kembali.setText("K"+nol_plus+no_auto);
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void clear(){
        txt_id_kembali.setText("");      
        txt_denda.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_kembali = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_denda = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        tglpinjam = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        tglkembali = new com.toedter.calendar.JDateChooser();
        btn_cek = new javax.swing.JButton();
        cbb1 = new javax.swing.JComboBox();
        cbb2 = new javax.swing.JComboBox();
        cbb3 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_tampil = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRANSAKSI PENGEMBALIAN");

        jLabel2.setText("ID PINJAM");

        txt_id_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_kembaliActionPerformed(evt);
            }
        });

        jLabel4.setText("ID BUKU");

        jLabel6.setText("ID ANGGOTA");

        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel8.setText("TANGGAL PINJAM");

        jLabel9.setText("DENDA");

        jLabel3.setText("ID KEMBALI");

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clear.png"))); // NOI18N
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        tglpinjam.setDateFormatString("yyyy-MM-dd");
        tglpinjam.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglpinjamPropertyChange(evt);
            }
        });

        jLabel12.setText("TANGGAL KEMBALI");

        tglkembali.setDateFormatString("yyyy-MM-dd");
        tglkembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglkembaliPropertyChange(evt);
            }
        });

        btn_cek.setText("CEK");
        btn_cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_denda, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cek))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tglpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(tglkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_id_kembali)
                                    .addComponent(cbb1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbb2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbb3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btn_simpan)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_clear)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_hapus)
                                .addGap(18, 18, 18)
                                .addComponent(btn_update)))))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_denda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cek))
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_hapus)
                    .addComponent(btn_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btn_clear)
                .addGap(31, 31, 31))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btn_tampil.setText("Tampil Data");
        btn_tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tampilActionPerformed(evt);
            }
        });

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_refresh.setText("REFRESH");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel11.setText("Cari ID Kembali");

        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cari.setText("CARI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_refresh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_cari)
                                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_tampil)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(btn_tampil)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_refresh)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGap(18, 18, 18)
                    .addComponent(btn_cari)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        btn_back.setText("KEMBALI BERANDA");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI PENGEMBALIAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(550, 550, 550))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_back))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_kembaliActionPerformed

    private void btn_tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tampilActionPerformed
      tampil();
    }//GEN-LAST:event_btn_tampilActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
      String id_kembali=txt_id_kembali.getText();
      String id_pinjam=cbb1.getSelectedItem().toString();
      String id_buku=cbb2.getSelectedItem().toString();
      String id_anggota=cbb3.getSelectedItem().toString();
      //String jml_kembali=txt_jml_kembali.getText();
      String denda=txt_denda.getText();

       String SQL ="insert into tb_kembali (id_kembali,id_pinjam,id_buku,id_anggota,tgl_pinjam,tgl_kembali,denda)values"
              + "('"+id_kembali+"','"+id_pinjam+"','"+id_buku+"','"+id_anggota+"','"+pinjam+"','"+kembali+"','"+denda+"')";
        System.out.println(SQL);
         try {
          koneksi1.statement.executeUpdate(SQL);
            JOptionPane.showMessageDialog(rootPane, "DATA berhasil ditambahkan");
            AutoNumber();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Data gagal ditambahkan,Mohon Periksa Kembali");
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tglpinjamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglpinjamPropertyChange
      if (tglpinjam.getDate() != null) {
      SimpleDateFormat FormatTanggal = new SimpleDateFormat("yyyy-MM-dd");
      pinjam = FormatTanggal.format(tglpinjam.getDate());
}
    }//GEN-LAST:event_tglpinjamPropertyChange

    private void tglkembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglkembaliPropertyChange
       if(tglkembali.getDate()!=null){
            SimpleDateFormat FormatTanggal = new SimpleDateFormat("yyyy-MM-dd");
            kembali=FormatTanggal.format(tglkembali.getDate());
        }
    }//GEN-LAST:event_tglkembaliPropertyChange

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        tampil();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
         try {
            Class.forName("com.mysql.jdbc.Driver");
          
        Connection koneksi1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
        koneksi1.createStatement().execute("delete from tb_kembali where id_kembali='"+txt_id_kembali.getText()+"'");
        
        JOptionPane.showMessageDialog(rootPane, "DATA berhasil Hapus");
        tampil();
        AutoNumber();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "DATA gagal di hapus,Mohon Periksa Kembali");
        }
    
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        cbb1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
        cbb2.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        cbb3.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        txt_id_kembali.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());       
        txt_denda.setText(jTable1.getValueAt(jTable1.getSelectedRow(),6).toString());
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
      String id_kembali=txt_id_kembali.getText();
      String id_pinjam=cbb1.getSelectedItem().toString();
      String id_buku=cbb2.getSelectedItem().toString();
      String id_anggota=cbb3.getSelectedItem().toString();
      String denda=txt_denda.getText();
      //String jumlah=txt_jumlah.getText();
      
      String SQL = "update tb_kembali set id_kembali='"+id_kembali+"',id_pinjam='"+id_pinjam+"',id_buku='"+id_buku+"',id_anggota='"+id_anggota+"',denda='"+denda+"',tgl_pinjam='"+tgl_pinjam+"',tgl_pinjam='"+tgl_kembali+"'"
              + "where id_kembali='"+id_kembali+"'";
                
        System.out.println("SQL");
      
       try {
          koneksi1.statement.executeUpdate(SQL);
            JOptionPane.showMessageDialog(rootPane, "DATA berhasil diubah");
            tampil();
            AutoNumber();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Data gagal diubah,Mohon Periksa Kembali");
        
      
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        String fromdate =((JTextField)tglpinjam.getDateEditor().getUiComponent()).getText();
        String todate =((JTextField)tglkembali.getDateEditor().getUiComponent()).getText();
        
        
          LocalDate fday=LocalDate.parse(fromdate);
          LocalDate tday=LocalDate.parse(todate);
          
          Long day_gap=ChronoUnit.DAYS.between(fday, tday);
                txt_denda.setText(String.valueOf((day_gap-7)*500));
          
       if(day_gap<=6)
          txt_denda.setText("0");
    }//GEN-LAST:event_btn_cekActionPerformed

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
            java.util.logging.Logger.getLogger(DataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cek;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tampil;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cbb1;
    private javax.swing.JComboBox cbb2;
    private javax.swing.JComboBox cbb3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser tglkembali;
    private com.toedter.calendar.JDateChooser tglpinjam;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_denda;
    private javax.swing.JTextField txt_id_kembali;
    // End of variables declaration//GEN-END:variables
}

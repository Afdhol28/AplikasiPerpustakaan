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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Afdhol
 */
public class DataPeminjaman extends javax.swing.JFrame {
    private String tgl;
    /**
     * Creates new form DataPeminjaman
     */Koneksi koneksi1 = new Koneksi();
     
    public DataPeminjaman() {
      initComponents();
      kode_buku();
      kode_anggota();
      AutoNumber();
      
    }    
    
    private void AutoNumber(){
        
        try {
            Connection koneksi1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
            Statement st = koneksi1.createStatement();
            String sql = "select max(right(id_pinjam,4)) as kode from tb_pinjam";      
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
                txt_id_pinjam.setText("P"+nol_plus+no_auto);
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
            
            cbb1.addItem(ob[0]);                                      
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
            
            cbb2.addItem(ob[0]);                                      
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void lebarKolom(){ 
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(50);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(50); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(55); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(50); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(75);
        column = jTable1.getColumnModel().getColumn(5); 
        column.setPreferredWidth(50);
        column = jTable1.getColumnModel().getColumn(6); 
        column.setPreferredWidth(100);
    }
    public void clear(){
        txt_pengarang.setText("");
        txt_tahun.setText("");
        txt_kelas.setText("");
    }
    public void tampil(){
        DefaultTableModel table1;
        table1 = new DefaultTableModel();
        table1.addColumn("ID PINJAM");
        table1.addColumn("ID BUKU");
        table1.addColumn("PENGARANG");
        table1.addColumn("TAHUN");
        table1.addColumn("ID ANGGOTA");
        table1.addColumn("KELAS");
        table1.addColumn("TANGGAL");
        
        jTable1.setModel(table1);
        try {
            ResultSet res = koneksi1.statement.executeQuery("Select *from tb_pinjam");
            while (res.next()){
                table1.addRow(new Object[]{
            res.getString("id_pinjam"),
            res.getString("id_buku"),
            res.getString("pengarang"),
            res.getString("tahun"),
            res.getString("id_anggota"),
            res.getString("kelas"),
            res.getString("tgl_pinjam"),
            
            
            
            });
                jTable1.setModel(table1);
            }
        }catch(Exception e){
        }
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
        txt_id_pinjam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_pengarang = new javax.swing.JTextField();
        txt_tahun = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        txt_kelas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        btn_clear = new javax.swing.JButton();
        cbb1 = new javax.swing.JComboBox();
        cbb2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_tampil = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRANSAKSI PEMINJAMAN");

        jLabel2.setText("ID PINJAM");

        txt_id_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pinjamActionPerformed(evt);
            }
        });

        jLabel3.setText("ID BUKU");

        jLabel4.setText("PENGARANG");

        jLabel5.setText("TAHUN TERBIT");

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

        jLabel7.setText("KELAS");

        jLabel8.setText("TANGGAL PINJAM");

        tanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalPropertyChange(evt);
            }
        });

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clear.png"))); // NOI18N
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pengarang, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(txt_id_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbb2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btn_simpan)
                        .addGap(35, 35, 35)
                        .addComponent(btn_hapus)
                        .addGap(31, 31, 31)
                        .addComponent(btn_update))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btn_clear)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_hapus)
                    .addComponent(btn_update))
                .addGap(18, 18, 18)
                .addComponent(btn_clear)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI PEMINJAMAN");

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

        jLabel11.setText("Cari ID Pinjam");

        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tampil)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_cari)
                                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btn_refresh)
                    .addContainerGap(743, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_tampil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(btn_cari)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(344, 344, 344)
                    .addComponent(btn_refresh)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home.png"))); // NOI18N
        btn_back.setText("KEMBALI BERANDA");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(473, 473, 473)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_back)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pinjamActionPerformed

    private void btn_tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tampilActionPerformed
        tampil();
      //  lebarKolom();
    }//GEN-LAST:event_btn_tampilActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
      
      String id=txt_id_pinjam.getText();
      String id_buku=cbb1.getSelectedItem().toString();
      String pengarang=txt_pengarang.getText();
      String th_terbit=txt_tahun.getText();
      String id_anggota=cbb2.getSelectedItem().toString();
      String kelas=txt_kelas.getText();
      //String jumlah=txt_jumlah.getText();
      
      String SQL ="insert into tb_pinjam (id_pinjam,id_buku,pengarang,tahun,id_anggota,kelas,tgl_pinjam)values"
              + "('"+id+"','"+id_buku+"','"+pengarang+"','"+th_terbit+"','"+id_anggota+"','"+kelas+"','"+tgl+"')";
        System.out.println(SQL);
         try {
          koneksi1.statement.executeUpdate(SQL);
            JOptionPane.showMessageDialog(rootPane, "DATA berhasil ditambahkan");
           AutoNumber();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Data gagal ditambahkan,Mohon Periksa Kembali");
        }
         tampil();
         //lebarKolom();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void tanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalPropertyChange
        if(tanggal.getDate()!=null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tgl=format.format(tanggal.getDate());
        }
    }//GEN-LAST:event_tanggalPropertyChange

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
          
        Connection koneksi1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus","root","");
        koneksi1.createStatement().execute("delete from tb_pinjam where id_pinjam='"+txt_id_pinjam.getText()+"'");
        JOptionPane.showMessageDialog(rootPane, "DATA berhasil Hapus");
        AutoNumber();
        tampil();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "DATA gagal di hapus,Mohon Periksa Kembali");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
      String id=txt_id_pinjam.getText();
      String id_buku=cbb1.getSelectedItem().toString();
      String pengarang=txt_pengarang.getText();
      String th_terbit=txt_tahun.getText();
      String id_anggota=cbb2.getSelectedItem().toString();
      String kelas=txt_kelas.getText();
      //String jumlah=txt_jumlah.getText();
      
      String SQL = "update tb_pinjam set id_buku='"+id_buku+"',pengarang='"+pengarang+"',tahun='"+th_terbit+"',id_anggota='"+id_anggota+"',kelas='"+kelas+"',tgl_pinjam='"+tgl+"'where id_pinjam='"+id+"'";
                
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

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
      tampil();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clear();
}//GEN-LAST:event_btn_clearActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
     DefaultTableModel table1;
        table1 = new DefaultTableModel();
        table1.addColumn("ID PINJAM");
        table1.addColumn("ID BUKU");
        table1.addColumn("PENGARANG");
        table1.addColumn("TAHUN");
        table1.addColumn("ID ANGGOTA");
        table1.addColumn("KELAS");
        table1.addColumn("TANGGAL");
        try
        {
            Statement st = koneksi1.statement;
            String search = txt_cari.getText();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_pinjam WHERE id_pinjam like '%"+search+"%' or id_anggota like '%"+search+"%' " );
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setRowCount(0);
            String [] data = new String[7];
            int i = 1;

            while(rs.next())
            {
                data[0] = rs.getString("id_pinjam");
                data[1] = rs.getString("id_buku");
                data[2] = rs.getString("pengarang");
                data[3] = rs.getString("tahun");
                data[4] = rs.getString("id_anggota");
                data[5] = rs.getString("kelas");
                data[6] = rs.getString("tgl_pinjam");
                dtm.addRow(data);
                i++;
            }
            rs.close();
            txt_cari.setText("");
        }
        catch(Exception ex)  {
            JOptionPane.showMessageDialog(null,"Data yang Anda cari Tidak dapat Ditemukan");
            System.err.println("error (search) : " +ex);
        }   
    }//GEN-LAST:event_btn_cariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txt_id_pinjam.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
        cbb1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
        txt_pengarang.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        cbb2.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
        txt_tahun.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        txt_kelas.setText(jTable1.getValueAt(jTable1.getSelectedRow(),5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tampil;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cbb1;
    private javax.swing.JComboBox cbb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_id_pinjam;
    private javax.swing.JTextField txt_kelas;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_tahun;
    // End of variables declaration//GEN-END:variables
}

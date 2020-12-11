/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Afdhol
 */
public class Koneksi {
    public Connection connection;
    public Statement statement;

            
    public Koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "JDBC Not Found");
        }
        connection = null;
       try {
           connection = DriverManager.getConnection("jdbc:mysql://localhost/perpus","root","");
           statement = connection.createStatement();
       }  catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Koneksi Gagal");
       }
        if (connection!=null) {
           JOptionPane.showMessageDialog(null, "Koneksi Sukses");
       }
       
    }
}

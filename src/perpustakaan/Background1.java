/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Afdhol
 */
public class Background1 extends JPanel {
    Image gambar;
    public Background1(){
        gambar = new ImageIcon(getClass().getResource("/gambar/wtf.png")).getImage();
    }
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        Graphics2D gd = (Graphics2D) grphcs.create();
        gd.drawImage(gambar, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
    
}

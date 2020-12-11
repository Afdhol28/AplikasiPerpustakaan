/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.File;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Afdhol
 */
public class fungsicetak {
    public fungsicetak (String namareport){
        try{
            conneksi objconneksi=new conneksi();
            Connection con=objconneksi.bukakoneksi();
            File report_File=new File(namareport);
            JasperReport jasperReport=(JasperReport)JRLoader.loadObject(report_File.getPath());
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, null,con);
            JasperViewer.viewReport(jasperPrint,false);
        }
          catch (Exception e){
             System.out.println(e.getMessage());
    }
    }
}

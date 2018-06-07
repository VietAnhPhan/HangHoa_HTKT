/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author HaiTruong
 */
public class BUS_Report {
    public static void ReportBanHang(String MaHD, String TenCH, String TenKH,String DiaChiKH, String SoHD, String TaiKhoan, String MaSoThueKH,
             String LyDo, Date NgayThanhToan, String SoSeri, String ThueSuat, String TongTien, String TienThue, String TongTong, String TienRaChu){
        
        String link ="D:\\SUBJECT OF UNIVERSITY\\GitHub\\HangHoa\\HeThongKeToan\\HangHoa\\src\\Report\\rpLapHoaDon.jrxml";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "jdbc:sqlserver://localhost:1433;database=HTKT";
            String us = "sa";
            String pa = "123409";
            
            Hashtable hash = new Hashtable();
                hash.put("MaHD", MaHD);
                hash.put("TenCH", TenCH);
                hash.put("TenKH", TenKH);
                hash.put("DiaChiKH", DiaChiKH);
                hash.put("SoHD", SoHD);
                hash.put("TaiKhoan", TaiKhoan);
                hash.put("MaSoThueKH", MaSoThueKH);
                hash.put("LyDo", LyDo);
                hash.put("NgayThanhToan", NgayThanhToan);
                hash.put("SoSeri", SoSeri);
                hash.put("ThueSuat", ThueSuat);
                hash.put("TongTien", TongTien);
                hash.put("TienThue", TienThue);
                hash.put("TongTong", TongTong);
                hash.put("TienRaChu", TienRaChu);
                
            Connection con = DriverManager.getConnection(database, us, pa);

            JasperReport jr = JasperCompileManager.compileReport(link);
            //tao Jasper Print
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, con);
            //de hien thi tieng Viet khi save PDF
            JRStyle[] styles= jp.getStyles();
            for(int i=0; i<styles.length; i++){
                styles[i].setPdfFontName("C:/Windows/Fonts/arial.ttf");
            }
            //tao Jasper View   
            JasperViewer.viewReport(jp,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void ReportNKBH(String tenCH, Date thang){
        
        String link ="D:\\SUBJECT OF UNIVERSITY\\GitHub\\HangHoa\\HeThongKeToan\\HangHoa\\src\\Report\\rpNKBH.jrxml";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "jdbc:sqlserver://localhost:1433;database=HTKT";
            String us = "sa";
            String pa = "123409";
//            String queryN131="select sum(TongTien) from HoaDon where MaTK='N131'";
//            String queryC551="select sum(TongTien) from HoaDon where MaTK='C551'";
//            String queryC512="select sum(TongTien) from HoaDon where MaTK='C512'";
//            String queryC5115="select sum(TongTien) from HoaDon where MaTK='C5115'";
//            String query="select sum(TongTien) from HoaDon where MaTK='N131'";
            Connection con = DriverManager.getConnection(database, us, pa);
            conDB conn=new conDB();
//            ResultSet rs=conn.executeQuery(query);
            java.sql.Date sqldate=new java.sql.Date(thang.getTime());
            int month=thang.getMonth()+1;
           // System.out.println(month);
            HashMap hash=new HashMap();
            hash.put("TEN_CH", tenCH);
            hash.put("THANG_TRONG_NAM",month);
            JasperReport jr = JasperCompileManager.compileReport(link);
            //tao Jasper Print
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, con);
            //de hien thi tieng Viet khi save PDF
            JRStyle[] styles= jp.getStyles();
            for(int i=0; i<styles.length; i++){
                styles[i].setPdfFontName("C:/Windows/Fonts/arial.ttf");
            }
            //tao Jasper View   
            JasperViewer.viewReport(jp,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void ReportNKMH(String tenCH, Date thang){
         String link ="D:\\SUBJECT OF UNIVERSITY\\GitHub\\HangHoa\\HeThongKeToan\\HangHoa\\src\\Report\\rpNKMH.jrxml";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "jdbc:sqlserver://localhost:1433;database=HTKT";
            String us = "sa";
            String pa = "123409";
            Connection con = DriverManager.getConnection(database, us, pa);
            conDB conn=new conDB();        
           // java.sql.Date sqldate=new java.sql.Date(thang.getTime());
            int month=thang.getMonth()+1;
           // System.out.println(month);
            HashMap hash=new HashMap();
            hash.put("TEN_CH", tenCH);
            hash.put("THANG_TRONG_NAM",month);
            hash.put("DATE",thang );
            JasperReport jr = JasperCompileManager.compileReport(link);
            //tao Jasper Print
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, con);
            //de hien thi tieng Viet khi save PDF
            JRStyle[] styles= jp.getStyles();
            for(int i=0; i<styles.length; i++){
                styles[i].setPdfFontName("C:/Windows/Fonts/arial.ttf");
            }
            //tao Jasper View   
            JasperViewer.viewReport(jp,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
      public static void ReportBQGQ(String maCH, Date ngaybd, Date ngaykt){
         String link ="D:\\SUBJECT OF UNIVERSITY\\GitHub\\HangHoa\\HeThongKeToan\\HangHoa\\src\\Report\\rpNKMH.jrxml";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "jdbc:sqlserver://localhost:1433;database=HTKT";
            String us = "sa";
            String pa = "123409";
            Connection con = DriverManager.getConnection(database, us, pa);
            conDB conn=new conDB();        
           // java.sql.Date sqldate=new java.sql.Date(thang.getTime());
         //   int month=thang.getMonth()+1;
           // System.out.println(month);
            HashMap hash=new HashMap();
            hash.put("TEN_CH", maCH);
            hash.put("NGAY_BD",ngaybd);
            hash.put("NGAY_KT",ngaykt );
            JasperReport jr = JasperCompileManager.compileReport(link);
            //tao Jasper Print
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, con);
            //de hien thi tieng Viet khi save PDF
            JRStyle[] styles= jp.getStyles();
            for(int i=0; i<styles.length; i++){
                styles[i].setPdfFontName("C:/Windows/Fonts/arial.ttf");
            }
            //tao Jasper View   
            JasperViewer.viewReport(jp,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    public static void main(String[] args) {
       // ReportBanHang();
       BUS_Report br=new BUS_Report();
       java.util.Date dt=new Date();
       br.ReportNKMH("abc", dt);
     //  br.ReportNKBH();
     
//       br.ReportBanHang("MaHD", "TenCH", "TenKH", "DiaChiKH"
//               , "SoHD", "TaiKhoan", "MaSoThueKH", "LyDo", date,
//               "SoSeri", "ThueSuat", "TongTien","TienThue", "TongTong", "TienRaChu");
 
    }
}

package contactmanagerappdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    public static Connection setKoneksi() {
        String konString = "jdbc:mysql://localhost:3306/db_contactmanagerapp";
        Connection koneksi = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString, "root", "");
            System.out.println("Koneksi Berhasil");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Koneksi Gagal");
        } catch(SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null, ex);
            System.out.println("Koneksi Gagal");
        }
        return koneksi;
    }
    
    public static int execute(String SQL) {
        int status = 0;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch(SQLException ex) {
             Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL) {
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch(SQLException ex) {
             Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null, ex);
        }
        return rs;
    }
    
    public static void testQuery() {
    try {
        ResultSet rs = executeQuery("SELECT * FROM contact LIMIT 1");
        if (rs.next()) {
            System.out.println("Data pertama: " + rs.getString(1));
        } else {
            System.out.println("Koneksi berhasil, tetapi tabel kosong atau tidak ditemukan.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Gagal menjalankan query.");
    }
}
}

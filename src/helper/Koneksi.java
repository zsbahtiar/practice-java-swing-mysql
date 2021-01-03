/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author zsbahtiar
 * implementasi koneksi database menggunakan design pattern singleton
 * terima kasih kepada alimshare: https://alimshare.com/membuat-koneksi-ke-database-mysql-pada-java/
 */
public class Koneksi {
    private static Connection conn;
    private static final String HOST  = "localhost";
    private static String USER = "zsbahtiar";
    private static String PASSWORD = "secret";
    private static final String DATABASE = "project6";
    

    
    private static Connection openConnection(){
        conn = null;
        try{
            String connectionString = "jdbc:mysql://"+HOST+"/"+DATABASE;
            conn = DriverManager.getConnection(connectionString, USER, PASSWORD);
            System.out.println("Connected");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Maaf, aplikasi terdapat masalah: " + e.getMessage());
            
        }
        
        return conn;
    }
    
    public static Connection getConnection(){
    
        return conn == null ? Koneksi.openConnection():conn;
    
    }
    
    
    
    
    
    
    
    
}

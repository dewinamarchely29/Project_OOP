/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author LENOVO
 */
public class Koneksi {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_myshop";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    public static Connection connection;
    protected static PreparedStatement statement;
    protected static ResultSet resultSet;
    protected static Statement stmt;
    
    public static Connection connection() {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                System.out.println("Data Base Connected Succes");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection: Gagal");
            }
            return connection;
    }
    public static void main(String args[]) {
        connection();
    }
}

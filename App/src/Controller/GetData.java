/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Produk;
import config.Koneksi;
import static config.Koneksi.connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class GetData extends Koneksi {
    public static List<Produk> readData() {
        connection();
        List<Produk> dataList = new ArrayList<>();
        
        try {
            statement = connection.prepareStatement("SELECT * FROM `tb_product` ");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAMA");
                int harga = resultSet.getInt("HARGA");
                int jumlah = resultSet.getInt("STOK");

                Produk produk = new Produk(id, name, harga, jumlah);
                dataList.add(produk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
    
    public static void deleteData(int id) {
        connection();

        try {
            String query = "DELETE FROM `tb_product` WHERE `tb_product`.`ID` = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            updateId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static void insertData(String nama, long harga, int jumlah) {
        connection();
        try {
            resetId();
            statement = connection.prepareStatement("INSERT INTO tb_product (NAMA, HARGA, STOK) VALUES (?, ?, ?)");
            statement.setString(1, nama);
            statement.setLong(2, harga);
            statement.setInt(3, jumlah);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateJumlah(int id, int stock) {
        connection();
        try {
            statement = connection.prepareStatement("UPDATE tb_product SET STOK=? WHERE ID=?");
            statement.setInt(1, stock);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long harga) {
        connection();
        try {
            statement = connection.prepareStatement("UPDATE tb_product SET HARGA=? WHERE ID=?");
            statement.setLong(1, harga);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNama(int id, String nama) {
        connection();
        try {
            statement = connection.prepareStatement("UPDATE tb_product SET NAMA=? WHERE ID=?");
            statement.setString(1, nama);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void resetId(){
        connection();
        try{
            statement = connection.prepareStatement("ALTER TABLE `tb_product` AUTO_INCREMENT = 1");
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateId(){
        connection();
        try{
            List<Produk> dataList = readData();
            for (int i = 0; i < dataList.size(); i++){
                Produk data = dataList.get(i);
                int newId = i + 1;
                statement = connection.prepareStatement("UPDATE tb_product SET ID = ? WHERE ID = ?");
                statement.setInt(1, newId);
                statement.setInt(2, data.getId());
                statement.executeUpdate();
                statement.close();
            } 
        } catch (SQLException e){
                e.printStackTrace();
        }
    }
 
    
}
package com.com.Layouts;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.com.DataAccesor.DataAccessor;
import com.com.Models.Product;

public class ProductReader {
    private DataAccessor dataAccessor;

    public ProductReader(DataAccessor dataAccessor){
        this.dataAccessor = dataAccessor;
    }

    public void readData(){
        try {
            ResultSet resultSet = dataAccessor.executeQuery("SELECT NAMA, HARGA, STOK FROM `tb_product` ORDER BY ID DESC");
            
            while (resultSet.next()) {
                String nama = resultSet.getString("NAMA");
                double harga = resultSet.getDouble("HARGA");
                int stok = resultSet.getInt("STOK");

                Product product = new Product(0, nama, harga, stok);
                System.out.println(product.getNama() + ": Rp." + product.getHarga() + " (" + product.getStok() + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
        }
    }
}

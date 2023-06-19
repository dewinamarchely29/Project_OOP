package com.com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.com.DataAccesor.DataAccessor;

public class ProductEditor {
    private DataAccessor dataAccessor;

    public ProductEditor(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void editData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID yang ingin diubah : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan data baru untuk NAMA: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan data baru untuk HARGA: ");
        double harga = scanner.nextDouble();

        System.out.print("Masukkan data baru untuk STOK: ");
        int stok = scanner.nextInt();

        try {
            String query = "UPDATE `tb_product` SET `NAMA` = '" + nama + "', `HARGA` = '" + harga + "', `STOK` = '" + stok + " WHERE `tb_product`.`ID` = " + id;
            dataAccessor.executeUpdate(query);
            System.out.println("Data berhasil diperbarui");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
            scanner.close();
        }
    }
}

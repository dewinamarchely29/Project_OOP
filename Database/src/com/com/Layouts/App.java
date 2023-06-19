package com.com.Layouts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.com.DataAccesor.DataAccessor;
import com.com.config.DBConnector;

public class App {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        int pilihan ;

        System.out.println("---------------------------------");
        System.out.println("WELCOME TO....... ");
        System.out.println("---------------------------------");
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Edit Data");
        System.out.println("----------------------------------");

        Connection connection = null;
        try {
            connection = DBConnector.getConnection();
            DataAccessor dataAccessor = new DataAccessor(connection);
        
            while (true) {
                System.out.print("Pilih: ");
                pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        ProductReader productReader = new ProductReader(dataAccessor);
                        productReader.readData();
                        break;
                    case 2:
                        ProductWriter productWriter = new ProductWriter(dataAccessor);
                        productWriter.insertData();
                        break;
                    case 3:
                        ProductEditor productEditor = new ProductEditor(dataAccessor);
                        productEditor.editData();
                        break;
                    case 4:
                        ProductDeleter productDeleter = new ProductDeleter(dataAccessor);
                        productDeleter.deleteData();
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                        break;                    
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            input.close();
        }
    }
}


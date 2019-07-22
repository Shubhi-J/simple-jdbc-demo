package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    public void getDatabaseMetaDeta() {
        try {
           /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
           // catch exception for driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
              /*Use DriverManager to get Connection*/
              Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
        ) {
            // create object of Databasemetadata
            DatabaseMetaData databaseMetadata = connection.getMetaData();

            // print meta data related to database
            System.out.println("Driver Name: " + databaseMetadata.getDriverName());
            System.out.println("Driver Version: " + databaseMetadata.getDriverVersion());
            System.out.println("UserName: " + databaseMetadata.getUserName());
            System.out.println("Database Product Name: " + databaseMetadata.getDatabaseProductName());
            System.out.println("Database Product Version: " + databaseMetadata.getDatabaseProductVersion());

        // catch exceptions
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

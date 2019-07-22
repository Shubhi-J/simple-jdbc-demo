package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getResultSetMetaDeta(){
            try {

            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // catch driver exception
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        try (
            /*Use DriverManager to get Connection*/
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
            // create statements
            Statement statement=connection.createStatement();){

            // fetch data from table
            ResultSet resultSet=statement.executeQuery("select * from employee");

            // get meta data about result set data
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

            // print information about resultset meta data
            System.out.println("Total columns: "+resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: "+resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+resultSetMetaData.getColumnTypeName(1));
            // catch exceptions
                } catch (
            SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
}

}

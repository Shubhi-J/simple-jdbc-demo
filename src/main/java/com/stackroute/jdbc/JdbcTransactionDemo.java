package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo {

    public void transactionDemo(String query1,String query2) {
        Connection connection=null;
        try {
            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // catch driver exceptions
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
        try
            {
            /*Use DriverManager to get Connection*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");

            // create statement
            Statement statement = connection.createStatement();
            // set autocommit to false
            connection.setAutoCommit(false);

            // execute two updates to database, as we are using transaction, if a query has errors, no update will take place
            // first query has no errors
            statement.executeUpdate(query1);
            // second query has errors
            statement.executeUpdate(query2);

            // only if there are no errors, update will occur
            connection.commit();
            // print success message
            System.out.println("saved successfully");

            // catch exception
            } catch (
                SQLException e) {
            // if there is some exception thrown, rollback the transaction
            try {
                connection.rollback();
                // give error message
                System.out.println("Data not saved due to exception");
                // close the connection
                connection.close();
                // catch exceptions
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
